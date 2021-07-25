package com.cybertek.tests;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;

public class ExcelRead {

    /*
    In this method we will learn how to read from excel file step by step
     */
    @Test
    public void read_from_excel_file() throws IOException {

        String path = "SampleData.xlsx";

        //To be able to read from Excel file, we need to load it into FileInputStream
        FileInputStream fileInputStream = new FileInputStream(path);

        // workbook > sheet > row > cell

        //1- Create a workbook
        XSSFWorkbook workbook = new XSSFWorkbook(fileInputStream);

        //2- We need to get the specific sheet from currently opened workbook
        XSSFSheet sheet = workbook.getSheet("Employees");

        //3- Select row and cell
        //Print out Steven's cell
        //Indexes start from 0
        sheet.getRow(1).getCell(0);


    }


}
