package com.cybertek.pages;

import com.cybertek.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class LyftHomePage {

    public LyftHomePage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(name = "fare-start")
    public WebElement pickUpField;

    @FindBy(name = "fare-end")
    public WebElement dropOffField;

    @FindBy(xpath = "//button[.='Get estimate']")
    public WebElement getPriceBtn;

    @FindBy(xpath = "//span[.='Lyft']")
    public WebElement lyftText;

    @FindBy(xpath = "//h3[.='RIDE TYPES']")
    public WebElement rideType;

    @FindBy (xpath = "//table/tbody/tr[1]/td[3]")
    public WebElement lyftPrice;

    @FindBy(xpath = "//small[.='Please select a valid location.']")
    public WebElement locationErrorMsg;

    public void enterPickupLocation(String str){
        pickUpField.sendKeys(str);
    }




}
