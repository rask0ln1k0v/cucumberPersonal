package com.cybertek.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Spartan_ConfirmationPage extends BasePage{
    @FindBy(xpath = "//div[@class='alert alert-success']")
    public WebElement successMsg;

    @FindBy(id = "name")
    public WebElement spartanName;
    @FindBy(id = "gender")
    public WebElement spartanGender;

    @FindBy(id = "phone")
    public WebElement spartanPhone;

}
