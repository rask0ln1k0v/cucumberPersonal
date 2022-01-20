package com.cybertek.pages;

import com.cybertek.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class VyTrack_LoginPage extends BasePage {

    @FindBy(id = "prependedInput")
    public WebElement idField;

    @FindBy(id = "prependedInput2")
    public WebElement passwordField;

    @FindBy(id = "_submit")
    public WebElement loginBtn;


    public void login(String id, String pw){
        idField.sendKeys(id);
        passwordField.sendKeys(pw);
        loginBtn.click();
    }

}
