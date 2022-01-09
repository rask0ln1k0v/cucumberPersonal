package com.cybertek.tests;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class ExcelWrite {

    @Test
    public void writeToExcelSheet() throws IOException {
        String filePath="Employees.xlsx";

        FileInputStream in = new FileInputStream(filePath);
        XSSFWorkbook workbook = new XSSFWorkbook(in);

        //go to your sheet
        XSSFSheet sheet1 = workbook.getSheetAt(0);

        //add a column name "salary" and save into file
        XSSFCell salaryColCell =sheet1.getRow(0).createCell(3);
        salaryColCell.setCellValue("Salary");

        XSSFCell salary1 = sheet1.getRow(1).createCell(3);
        salary1.setCellValue(115000);

        //save the changes
        //inputStream -> is reading
        //outputStream -> is writing
        FileOutputStream outputStream = new FileOutputStream(filePath);
        workbook.write(outputStream);
        in.close();


    }

}
