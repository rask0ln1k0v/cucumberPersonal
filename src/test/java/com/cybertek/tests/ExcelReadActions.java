package com.cybertek.tests;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;

import java.io.IOException;

public class ExcelReadActions {

    String filePath="Employees.xlsx";

    @Test
    public void readExcelSheetData() throws IOException {
        XSSFWorkbook workbook = new XSSFWorkbook(filePath);

        //Go to "Sheet1" sheet

        XSSFSheet sheet1 = workbook.getSheetAt(0);

        //print column names. row is 0. cells 0,1,2
        System.out.println("COLUMN NAMES");
//        System.out.println(sheet1.getRow(0).getCell(0)); //"FirstName

        //we can loop and print all 3 column names

        for (int i=0; i<=2;i++){
            System.out.println(sheet1.getRow(0).getCell(i));
        }

        //find out number of rows in the worksheet
        int rowsCount = sheet1.getPhysicalNumberOfRows();
        System.out.println("Row's count" + rowsCount); //8 it's total rows(starts count from1)

        int usedRowsCount = sheet1.getLastRowNum();
        System.out.println("UsedrowsCount: " + usedRowsCount); //7 bc it starts from 0, index


        //print all firstNames
        for (int i=1; i<=sheet1.getLastRowNum(); i++){
            System.out.println(sheet1.getRow(i).getCell(0));
        }
        System.out.println("________________________________________________");
        //loop and find Fahima in first name column
        //then print her lastname and JobID
        int j=0;

        for (int i=0; i<=sheet1.getLastRowNum();i++){

            if (sheet1.getRow(i).getCell(0).toString().equals("Fahima")){
                System.out.println(sheet1.getRow(i).getCell(0)+ " | " +
                        sheet1.getRow(i).getCell(1) +" | "+
                        sheet1.getRow(i).getCell(2));
                break;

            }

        }


    }

}
