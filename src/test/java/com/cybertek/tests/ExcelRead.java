package com.cybertek.tests;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;

import java.io.IOException;
import java.util.Iterator;

public class ExcelRead {

    @Test
    public void readingFromExcel() throws IOException {
    //Open excel workbook using XSSFWorkbook class
    //pass file name in the constructor

        XSSFWorkbook workbook = new XSSFWorkbook("Employees.xlsx");

        //Go to worksheet. pass the sheet name
        XSSFSheet worksheet = workbook.getSheet("Sheet1");

        //print
        System.out.println(worksheet.getRow(2).getCell(0));
        Iterator<Row> itr = worksheet.iterator();
        while(itr.hasNext()) {
            System.out.println(itr.next().getCell(0));
        }



}

}
