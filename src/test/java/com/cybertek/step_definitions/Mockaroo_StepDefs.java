package com.cybertek.step_definitions;

import com.cybertek.pages.Mockaroo_HomePage;
import com.cybertek.utilities.BrowserUtils;
import com.cybertek.utilities.ConfigurationReader;
import com.cybertek.utilities.Driver;
import com.cybertek.utilities.ExcelUtil;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Mockaroo_StepDefs {
 Mockaroo_HomePage page = new Mockaroo_HomePage();
    @Given("User is on mockaroo homepage")

   public void user_is_on_mockaroo_homepage() {
       Driver.getDriver().get(ConfigurationReader.getProperty("mockaroo.url"));
    page.homePageTitleVerification();
    }

    @Given("Number of rows is {int}")
    public void number_of_rows_is(int rowsCount) {

      page.rowsField.sendKeys(Keys.DELETE);
      page.rowsField.sendKeys(rowsCount+"");
    }

    @Given("Format is Excel")
    public void format_is_excel() {
        BrowserUtils.scrollDown(100);
   page.formatDropdown.click();
   page.excelOption.click();

//   page.selectExcelFormat();
    }

    @When("User clicks on preview")
    public void user_clicks_on_preview() {
        page.previewBtn.click();
    }

    @Then("following columns should be displayed:")
    public void following_columns_should_be_displayed(List<String> expectedColumns) {

        List<String> actualColumns = new ArrayList<>();

        //Read text of each tableHeader and Store into actualColumns list
        for (WebElement headerName :page.tableHeaders) {
            actualColumns.add( headerName.getText() );
        }

        List<String> actualHeaderNames = BrowserUtils.getElementsText(page.tableHeaders);
   Assert.assertEquals(expectedColumns,actualColumns);


    }

    @Then("{int} rows of data should be displayed")
    public void rows_of_data_should_be_displayed(int expectedRowsCount
    ) {
        Assert.assertEquals(expectedRowsCount,page.tableRows.size());

    }


    @When("User clicks on download")
    public void userClicksOnDownload() {
        page.downloadDataBtn.click();
    }

    int excelRowsCount;
    @Then("following columns should be displayed in excel file:")
    public void followingColumnsShouldBeDisplayedInExcelFile(List<String> expColumns) throws IOException {
        String filePath = System.getProperty("user.home") + "/Downloads/MOCK_DATA.xlsx";
        ExcelUtil excel = new ExcelUtil(filePath,"data");
        Assert.assertEquals(expColumns,excel.getColumnsNames());
        excelRowsCount = excel.rowCount();


//        FileInputStream in = new FileInputStream(filePath);
//        XSSFWorkbook workbook = new XSSFWorkbook(in);
//        XSSFSheet worksheet = workbook.getSheetAt(0);
//
//        int excelHeadersCount = workbook.getSheetAt(0).getRow(0).getPhysicalNumberOfCells();
//        excelRowsCount = worksheet.getLastRowNum();
//
//        List <String> actualColumns = new ArrayList<>();
//
//        //loop and read column names and store into List<String> actualcolumns
//
//        for (int i=0; i<excelHeadersCount; i++){
//            actualColumns.add(worksheet.getRow(0).getCell(i).toString());
//        }
//
//        Assert.assertEquals(expColumns,actualColumns);


    }

    @And("{int} rows of data should be displayed in excel file")
    public void rowsOfDataShouldBeDisplayedInExcelFile(int expectedRowCount) throws IOException {
   Assert.assertEquals(expectedRowCount,excelRowsCount);




    }

    @And("data should be present in excel file")
    public void dataShouldBePresentInExcelFile() {
        String filePath = System.getProperty("user.home") + "/Downloads/MOCK_DATA.xlsx";
        ExcelUtil excel = new ExcelUtil(filePath,"data");

        excel.getDataList();
        System.out.println(excel.getDataList());


    }
}
