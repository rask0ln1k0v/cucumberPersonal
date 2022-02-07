package com.cybertek.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class Spartan_AddSpartanPage extends BasePage{

    @FindBy(xpath = "//input[@id='name']")
    public WebElement nameInput;

    @FindBy(xpath = "//select[@id='genderSelect']")
    public WebElement genderElem;

    @FindBy(xpath = "//input[@id='phone']")
    public WebElement phoneNumberInput;

    @FindBy(id = "submit_btn")
    public WebElement submitBtn;

    public void selectGender(String gender){
        new Select(genderElem).selectByVisibleText(gender);
    }

}
