package com.cybertek.step_definitions;

import com.cybertek.pages.PercentageCalculatorPage;
import com.cybertek.utilities.BrowserUtils;
import com.cybertek.utilities.ConfigurationReader;
import com.cybertek.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.Keys;

import java.util.Map;

public class PercentageCalculatorStepDefs {

PercentageCalculatorPage page = new PercentageCalculatorPage();
    @Given("User is on percentage calculator page")
    public void user_is_on_percentage_calculator_page() {
        Driver.getDriver().get(ConfigurationReader.getProperty("percentage_calculator.url"));
        Assert.assertEquals("Percentage Calculator",Driver.getDriver().getTitle());
    }

    @Then("User should see following calculations:")
    public void user_should_see_following_calculations(Map <Integer,Integer> mapValues) {
        System.out.println("Map Values: " + mapValues);
        page.percent.sendKeys("5");
        //loop through keys in the map

        for (Integer inputKey : mapValues.keySet()){
            page.input.clear();
            page.input.sendKeys(inputKey+"", Keys.ENTER);
            BrowserUtils.sleep(1);

            System.out.println("INPUT VALUE = " +  inputKey);
            System.out.println("EXPECTED %5 VALUE = " + mapValues.get(inputKey));
            System.out.println("ACTUAL %5 CALCULATED = " + page.result.getAttribute("value"));
            System.out.println("_____________________________________________________");

            Assert.assertEquals(mapValues.get(inputKey),Integer.valueOf(page.result.getAttribute("value")));
        }


    }



}
