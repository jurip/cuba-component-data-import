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
            if (reader.footer) return
            labels = reader.labels
            def rowResult = [:]
            labels.each {
                rowResult["$it"] = ''
            }


            row.cellIterator().each { Cell cell ->

                rowResult[labels[cell.columnIndex]] = dataFormatter.formatCellValue(cell)


                switch (cell.getCellType()) {
                    case CellType.NUMERIC:
                        if (DateUtil.isCellDateFormatted(cell, null)) {
                            //DateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy");
                            //String strDate = dateFormat.format(cell.getDateCellValue());
                            String strDate = DateUtil.getLocalDateTime(cell.getNumericCellValue()).format('dd-MMM-yyyy')
                            rowResult[labels[cell.columnIndex]] = strDate;
                        } else {
                            double n = cell.getNumericCellValue();
                            rowResult[labels[cell.columnIndex]] = java.lang.String.valueOf(n);
                        }
                        break
                    case CellType.STRING:
                        if (cell.getStringCellValue().contains("Всего документов:")
                                || cell.getStringCellValue().contains("Итого обороты:")
                                || cell.getStringCellValue().contains("Исходящий остаток")
                                || cell.getStringCellValue().contains("Итого")
                                || cell.getStringCellValue().contains("Всего")
                                || cell.getStringCellValue().contains("Обороты за период с")
                                || cell.getStringCellValue().contains("Спасибо, что Вы с нами!")

                        ) {
                            reader.footer = 1
                            return
                        }

                }

            }
            if (reader.footer)
                return


            def incomeIndex = 27;
            def outcomeIndex = 28;



            def String o = rowResult[labels[outcomeIndex]];
            if (o == "" || o == null)
                o = "0"
            def String inco = rowResult[labels[incomeIndex]];
            if (inco == "" || inco == null)
                inco = "0"



            if (reader.first == 1) {
                reader.currentOstatok = reader.getOstatok();
            }

            def accountIndex = 20
            if(reader.sberAccount != ""){
                rowResult[labels[accountIndex]] = java.lang.String.valueOf(reader.sberAccount);
            }

            rowResult['21'] = java.lang.String.valueOf(reader.currentOstatok);
            if (!o.isNumber() && !inco.isNumber())
                return
            def Double o1 = Double.valueOf(o)
            def Double inco1 = Double.valueOf(inco)

            reader.currentOstatok = reader.currentOstatok - o1 + inco1
            reader.currentOstatok = reader.currentOstatok.round(2)


            rowResult['22'] = java.lang.String.valueOf(reader.getOstatokDate());

            rowResult['23'] = java.lang.String.valueOf(reader.first);
            reader.first = reader.first + 1;

            rowResult['24'] = reader.bank;


            result.columns = labels
            def dataRow = DataRowImpl.ofMap(rowResult)
            if (!dataRow.empty && reader.footer != 1) {
                result.rows << dataRow
            }


        }


    }

    private String trimVtb(String s){
        s.replace("," ,".").replace(" ", "").replace("-", "").replace("RUR", "")
    }


}
