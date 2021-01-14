package de.diedavids.cuba.dataimport.converter

import org.apache.poi.ss.usermodel.Cell
import org.apache.poi.ss.usermodel.Row
import org.apache.poi.ss.usermodel.WorkbookFactory
import org.apache.poi.ss.util.CellReference

class ExcelReader {

    def workbook
    def labels
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


    ExcelReader(File file) {
        workbook = WorkbookFactory.create(file)
        sheet = getSheet(0)

        if(getCellStringValue('A1').contains('СКБ')){
            bank = "SKB"
            ostatok = getCellNumericValue('D6')
            ostatokDate = getCellStringValue('A2').split(" по")[0].split(" ")[1];
            sheet = getSheet(1)
            rowIterator = sheet.rowIterator()
        } else
        if(getCellStringValue('I2').contains('ТОЧКА')){
            bank = "TOCHKA";
            ostatok = getCellNumericValue('D8');
            ostatokDate =  getCellStringValue('B15').split(': ')[1];
            sheet = getSheet(1)
            rowIterator = sheet.rowIterator()
            offset = 2
        } else
        if( getCellStringValue('D2').contains('Сбербанк')){
            bank = "SBERBANK";
            offset = 13;
            sberAccount = getCellStringValue('E7')
            ostatok = getCellNumericValue('M11');
            ostatokDate = getCellStringValue('B6').split("период с ")[1].split(" по ")[0];
        }else
        if(getCellStringValue('A1').contains('ВЫПИСКА')){//rosbank
            offset = 5;
            bank = "ROSBANK";
            ostatok = getCellNumericValue('L3')
            ostatokDate = getCellStringValue('A3').split("остаток ")[1];
        }else{
            bank = "NEIZVESTNYJ";
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
        sheet = getSheet(params.sheet)
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
