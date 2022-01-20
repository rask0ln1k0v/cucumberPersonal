package com.cybertek.pages;

import com.cybertek.utilities.Driver;
import org.jsoup.Connection;
import org.openqa.selenium.support.PageFactory;

public abstract class BasePage {

    public BasePage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }



}
