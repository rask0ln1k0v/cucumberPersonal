package com.cybertek.tests;

import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class ExcelRead {

    /*
    In this method we will learn how to read from excel file step by step
     */
    @Test
    public void read_from_excel_file() throws FileNotFoundException {

        String path = "SampleData.xlsx";

        //To be able to read from Excel file, we need to load it into FileInputStream
        FileInputStream fileInputStream = new FileInputStream(path);






    }


}
