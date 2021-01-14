package de.diedavids.cuba.dataimport.converter

import de.diedavids.cuba.dataimport.dto.DataRowImpl
import de.diedavids.cuba.dataimport.dto.ImportData
import de.diedavids.cuba.dataimport.dto.ImportDataImpl
import org.apache.poi.ss.usermodel.Cell
import org.apache.poi.ss.usermodel.CellType
import org.apache.poi.ss.usermodel.DataFormatter
import org.apache.poi.ss.usermodel.DateUtil
import org.apache.poi.ss.usermodel.FormulaError
import org.apache.poi.ss.usermodel.Row

import java.text.DateFormat
import java.text.SimpleDateFormat

class ExcelImportDataConverter implements ImportDataConverter {

    @Override
    ImportData convert(String content) {
        throw new IllegalArgumentException('String conversion is not supported in case of Excel')
    }

    @Override
    ImportData convert(File file, String fileCharset) {
        def result = new ImportDataImpl()

        parse(file, result)

        result
    }

    private void parse(File file, ImportData result) {

        def reader = new ExcelReader(file)

        DataFormatter dataFormatter = new DataFormatter()
        //dataFormatter.addFormat("General", new java.text.DecimalFormat("##############.##"));

        def labelds = [:];
        labelds.offset = 1;

        reader.eachLine(labelds) { Row row ->
            def labels = ['0','1','2', '3', '4','5', '6', '7', '8', '9', '10', '11', '12', '13', '14', '15', '16','17', '18', '19', '20', '21', '22', '23', '24', '25','26' ]
            def rowResult = [:]
            labels.each {
                rowResult["$it"] = ''
            }

            def footer = 0



            row.cellIterator().each { Cell cell ->

                rowResult[labels[cell.columnIndex]] = dataFormatter.formatCellValue(cell)


                        switch (cell.getCellType()) {
                            case CellType.NUMERIC :
                                if (!DateUtil.isCellDateFormatted(cell, null)) {
//                                    DateFormat dateFormat = new SimpleDateFormat("dd.mm.yyyy");
//                                    String strDate = dateFormat.format(cell.getDateCellValue());
//                                    rowResult[labels[cell.columnIndex]] = strDate ;
//                                }else {
                                    double n = cell.getNumericCellValue();
                                    rowResult[labels[cell.columnIndex]] = java.lang.String.valueOf(n);
                                }
                            break
                            case CellType.STRING :
                                if(cell.getStringCellValue().contains("Всего документов:")
                                        || cell.getStringCellValue().contains("Итого обороты:")
                                        || cell.getStringCellValue().contains("Исходящий остаток")
                                        || cell.getStringCellValue().contains("Итого")

                                ){
                                    footer = 1;
                                }

                        }

            }
            if(reader.getSberAccount()!=""){
                rowResult['20'] = reader.getSberAccount()
            }
            if(reader.getBank() == "TOCHKA"){
                reader.outcome = '18';
                reader.income = '19';
            }
            if(reader.getBank() == "SKB"){
                reader.outcome = '11';
                reader.income = '12';
            }
            if(reader.getBank() == "SBERBANK"){
                reader.outcome = '14';
                reader.income = '15';
            }
            if(reader.getBank() == "ROSBANK"){
                reader.outcome = '11';
                reader.income = '12';
            }

            def o = rowResult[reader.outcome];
            if(o == "")
                o = "0"

            def inco = rowResult[reader.income];
            if(inco == "")
                inco = "0"

            if(reader.first == 1){
                reader.currentOstatok = reader.getOstatok() - Double.valueOf(o)+Double.valueOf(inco)
                reader.currentOstatok = reader.currentOstatok.round(2)
                rowResult['21'] = java.lang.String.valueOf(reader.currentOstatok);
            }else {
                reader.currentOstatok = reader.currentOstatok - Double.valueOf(o)+Double.valueOf(inco)
                reader.currentOstatok = reader.currentOstatok.round(2)
                rowResult['21'] = java.lang.String.valueOf(reader.currentOstatok);
            }



            rowResult['22'] = java.lang.String.valueOf(reader.getOstatokDate());
            rowResult['23'] = java.lang.String.valueOf(reader.first);
            reader.first = reader.first + 1;

            rowResult['24'] = reader.bank;


            result.columns = labels
            def dataRow = DataRowImpl.ofMap(rowResult)
            if (!dataRow.empty && footer != 1) {
                result.rows << dataRow
            }
        }


    }


}
