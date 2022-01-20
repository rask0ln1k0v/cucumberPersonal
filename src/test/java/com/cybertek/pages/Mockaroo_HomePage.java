package com.cybertek.pages;

import com.cybertek.utilities.BrowserUtils;
import com.cybertek.utilities.Driver;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class Mockaroo_HomePage extends BasePage{

    @FindBy(name = "num_rows")
    public WebElement rowsField;

    @FindBy(id = "mui-component-select-file_format")
    public WebElement formatDropdown;

    @FindBy(xpath = "//li[.='Excel']")
    public WebElement excelOption;

    @FindBy(xpath = "//span[.='Preview']")
    public WebElement previewBtn;

    @FindBy(xpath = "//table//th")
    public List<WebElement> tableHeaders;

    @FindBy(xpath = "//table/tbody/tr")
    public List<WebElement> tableRows;

    @FindBy(xpath = "//span[.='Download Data']")
    public WebElement downloadDataBtn;

    public void selectExcelFormat(){
        BrowserUtils.scrollDown(500);
        formatDropdown.click();
        excelOption.click();
    }

    public void homePageTitleVerification(){
    String expectedTitle = "Mockaroo - Random Data Generator and API Mocking Tool | JSON / CSV / SQL / Excel";
    String actualTitle = Driver.getDriver().getTitle();
        Assert.assertEquals("failed title verification",expectedTitle,actualTitle);

    }

}
