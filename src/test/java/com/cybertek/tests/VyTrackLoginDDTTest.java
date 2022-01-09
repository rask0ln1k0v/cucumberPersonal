package com.cybertek.tests;

import com.cybertek.utilities.BrowserUtils;
import com.cybertek.utilities.Driver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class VyTrackLoginDDTTest {

    String filePath="VyTrackQa2Users.xlsx";
    @Test
    public void loginDDTTEst() throws IOException {
        FileInputStream in = new FileInputStream(filePath);

        XSSFWorkbook workbook = new XSSFWorkbook(in);
        XSSFSheet data = workbook.getSheetAt(0);

        Driver.getDriver().get("https://qa2.vytrack.com/user/login");


        for (int i=1; i<=data.getLastRowNum();i++){
            WebElement id = Driver.getDriver().findElement(By.id("prependedInput"));
            WebElement pw = Driver.getDriver().findElement(By.id("prependedInput2"));
            WebElement loginbtn= Driver.getDriver().findElement(By.id("_submit"));

            id.sendKeys(data.getRow(i).getCell(0).toString());
            pw.sendKeys(data.getRow(i).getCell(1).toString());
            loginbtn.click();

            WebElement user = Driver.getDriver().findElement(By.xpath("//li[@id='user-menu']"));
            WebElement logout =Driver.getDriver().findElement(By.xpath("//*[.='Logout']"));

            if (user.isDisplayed()) {
                XSSFCell testResult = data.getRow(i).getCell(4);
                testResult.setCellValue("PASS");
                FileOutputStream outputStream = new FileOutputStream(filePath);
                workbook.write(outputStream);
            }
            BrowserUtils.sleep(3);
            user.click();
            logout.click();
            BrowserUtils.sleep(3);
        }

    }


}
