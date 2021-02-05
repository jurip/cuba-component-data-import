package de.diedavids.cuba.dataimport.converter

import org.apache.poi.ss.usermodel.Cell
import org.apache.poi.ss.usermodel.Row
import org.apache.poi.ss.usermodel.WorkbookFactory
import org.apache.poi.ss.util.CellReference

class ExcelReader {

    def workbook
    def row
    def sberAccount = ""
    def ostatok = 0;
    def currentOstatok = 0;
    def first = 1;
    def ostatokDate = "";
    def bank = "";
    def income = "";
    def outcome = "";
    def sheet
    def rowIterator
    def offset = 1;
    def footer = 0
    def ostatokRow;
    def labels = ['0','1','2', '3', '4','5', '6', '7', '8', '9', '10', '11', '12', '13', '14', '15', '16','17', '18', '19', '20', '21', '22', '23', '24', '25','26', '27', '28' ]
    private static int findRow(sheet, String cellContent) {
        for (Row row : sheet) {
            for (Cell cell : row) {
                def f = cell.getCellType().toString();
                if (cell.getCellType().toString() == "STRING") {
                    if (cell.getRichStringCellValue().getString().trim().equals(cellContent)) {
                        return row.getRowNum();
                    }
                }
            }
        }
        return 0;
    }

    ExcelReader(File file) {
        def f = file.toString()
        workbook = WorkbookFactory.create(file)
        sheet = getSheet(0)
        if(getCellStringValue('A1').contains('СКБ')){
            labels = ['0','1','2', '3', '4','5', '6', '7', '8', '9', '10', '11', '12', '13', '14', '15', '16','17', '18', '19', '20', '21', '22', '23', '24', '25','26', '12', '11' ]
            bank = "SKB"
            ostatok = getCellNumericValue('D6')
            ostatokDate = getCellStringValue('A2').split(" по")[0].split(" ")[1];
            sheet = getSheet(1)
            rowIterator = sheet.rowIterator()
        } else
        if(getCellStringValue('I2').contains('ТОЧКА')){
            labels = ['0','1','2', '3', '4','5', '6', '7', '8', '9', '10', '11', '12', '13', '14', '15', '16','17', '18', '19', '20', '21', '22', '23', '24', '25','26', '19', '18' ]
            //     acc
            bank = "TOCHKA";
            ostatok = getCellNumericValue('D8');
            ostatokDate =  getCellStringValue('B15').split(': ')[1];
            sheet = getSheet(1)
            rowIterator = sheet.rowIterator()
            offset = 2
        } else
        if( getCellStringValue('D2').contains('Сбербанк')){
            labels = ['0','1','2', '3', '4','5', '6', '7', '8', '9', '10', '11', '12', '13', '14', '15', '16','17', '18', '19', '20', '21', '22', '23', '24', '25','26', '15', '14' ]
            bank = "SBERBANK";
            offset = 13;
            sberAccount = getCellStringValue('E7')
            ostatok = getCellNumericValue('M11');
            ostatokDate = getCellStringValue('B6').split("период с ")[1].split(" по ")[0];
        }else
        if(getCellStringValue('A1').contains('ВЫПИСКА')){//rosbank
            labels = ['0','1','2', '3', '4','5', '6', '7', '8', '9', '10', '11', '12', '13', '14', '15', '16','17', '18', '19', '20', '21', '22', '23', '24', '25','26', '12', '11' ]
            offset = 5;
            bank = "ROSBANK";
            ostatok = getCellNumericValue('L3')
            ostatokDate = getCellStringValue('A3').split("остаток ")[1];
        }else
        if(getCellStringValue('A2').contains('МОСОБЛБАНК')){
            labels = ['0','1','2', '3', '4','5', '6', '7', '8', '9', '10', '11', '12', '13', '14', '15', '16','17', '18', '19', '20', '21', '22', '23', '24', '25','26','4', '3' ]
            offset = 9;
            bank = "MOSOBL";
            ostatok = Double.valueOf(getCellStringValue('A6').split(": ")[1]);
            sberAccount = getCellStringValue('A4').split("счету N ")[1].split(" с ")[0]
            ostatokDate = getCellStringValue('A4').split(" с ")[1].split(" по ")[0];
        }else
        if(getCellStringValue('A3').contains('Дата:')){
            labels = ['0','1','2', '3', '4','5', '6', '7', '8', '9', '10', '11', '12', '13', '14', '15', '16','17', '18', '19', '20', '21', '22', '23', '24', '25','26','8', '9' ]
            offset = 9;
            bank = "MODUL";
            ostatok = Double.valueOf(getCellNumericValue('I7'));
            sberAccount = getCellStringValue('A4').split("счёт № ")[1].split(" ")[0]
            ostatokDate = getCellStringValue('B3').split(" - ")[0];
        }else if(getCellStringValue('F2').contains('Сбербанк Бизнес Онлайн') ){
            labels = ['0','1','2', '3', '4','5', '6', '7', '8', '9', '10', '11', '12', '13', '14', '15', '16','17', '18', '19', '20', '21', '22', '23', '24', '25','26','27', '28' ]
            offset = 11;
            bank = "SBER21";
            sberAccount = getCellStringValue('M5')
            ostatokRow = findRow(sheet, "Входящий остаток")
            int colIdx = CellReference.convertColStringToIndex("H");
            ostatok = Double.valueOf(getCellStringValue("H"+(ostatokRow +1)).replace(",","."));

            sberAccount = getCellStringValue('M5')
            ostatokDate = getCellStringValue('M7');
        }else if(getCellStringValue('A2').contains('Мастер') ){
            labels = ['0','1','2', '3', '4','5', '6', '7', '8', '9', '10', '11', '12', '13', '14', '15', '16','17', '18', '19', '20', '21', '22', '23', '24', '25','26','7', '10' ]
            offset = 17;
            bank = "VTB";
            ostatok = Double.valueOf(getCellStringValue("A9").split(",")[0].replace(" ", ""));

            sberAccount = getCellStringValue('A4')
            ostatokDate = getCellStringValue('A5').split("выписки                 ")[1].split(" - ")[0];
        }else{
            labels = ['0','1','2', '3', '4','5', '6', '7', '8', '9', '10', '11', '12', '13', '14', '15', '16','17', '18', '19', '20', '21', '22', '23', '24', '25','26', '9','7' ]

            //         acc inc out date opis
            offset = 1;
            bank = "FIZOTKRYTIE";

        }

    }

    def getSheet(idx) {
        def sheet

        def actualIndex = idx ?: 0
        if (actualIndex instanceof Number) {
            sheet = workbook.getSheetAt(actualIndex)
        } else if (actualIndex ==~ /^\d+$/) {
            sheet = workbook.getSheetAt(Integer.valueOf(actualIndex))
        } else {
            sheet = workbook.getSheet(actualIndex)
        }
        sheet
    }

    def cell(idx) {
        def actualIndex = idx
        if (labels && (actualIndex instanceof String)) {
            actualIndex = labels.indexOf(actualIndex.toLowerCase())
        }
        row[actualIndex]
    }

    def propertyMissing(String name) {
        cell(name)
    }

    def getCellStringValue(cell){
        CellReference cellReference = new CellReference(cell);
        Row row = sheet.getRow(cellReference.getRow());
        Cell stringCell = row.getCell(cellReference.getCol());
        stringCell.getStringCellValue()
    }
    def getCellNumericValue(cell){
        CellReference cellReference = new CellReference(cell);
        Row row = sheet.getRow(cellReference.getRow());
        Cell stringCell = row.getCell(cellReference.getCol());
        stringCell.getNumericCellValue()
    }
    def eachLine(Map params = [:], Closure closure) {
        def max = params.max ?: 9999999
        def rowIterator = sheet.rowIterator()
        def linesRead = 0






        if (params.labels) {
            labels = rowIterator.next().collect { it.toString().toLowerCase().replace('.', '') }
        }
        offset.times { rowIterator.next() }

        closure.setDelegate(this)

        while (rowIterator.hasNext() && linesRead++ < max) {
            row = rowIterator.next()

            closure.call(row)
        }
    }
}
