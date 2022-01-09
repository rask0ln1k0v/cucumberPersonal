package com.cybertek.pages;

import com.cybertek.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CloudTables_HomePage {
    public  CloudTables_HomePage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//span[.='New']/..")
    public WebElement newBtn;

    @FindBy(id = "DTE_Field_first_name")
    public WebElement firstNameField;

    @FindBy(id = "DTE_Field_last_name")
    public WebElement lastNameField;

    @FindBy(id = "DTE_Field_position")
    public WebElement positionField;

    @FindBy(id = "DTE_Field_salary")
    public WebElement salaryField;

    @FindBy(xpath = "//button[.='Create']")
    public WebElement createBtn;

    @FindBy(xpath = "//div[@id='example_filter']/label/input")
    public WebElement searchField;

    @FindBy(xpath = "//tr[@class='odd']/td[2]")
    public WebElement newAddedUser;


}
