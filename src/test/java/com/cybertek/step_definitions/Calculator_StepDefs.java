package com.cybertek.step_definitions;

import com.cybertek.pages.CalculatorPage;
import com.cybertek.utilities.ConfigurationReader;
import com.cybertek.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;

public class Calculator_StepDefs {
CalculatorPage calculatorPage = new CalculatorPage();

    @Given("User is on calculator page")
    public void user_is_on_calculator_page() {
        Driver.getDriver().get(ConfigurationReader.getProperty("calculator.url"));
    }
    @Given("User clicks on {string} on calculator")
    public void user_clicks_on_on_calculator(String button) {
    calculatorPage.clickOn(button);

    }
    @Then("result {string} should be displayed")
    public void result_should_be_displayed(String expectedResult) {
    String actualResult = calculatorPage.resultField.getText().trim();
        System.out.println("actual result should be: "+ actualResult);
        System.out.println("Expected result should be" + expectedResult);

        Assert.assertEquals(expectedResult,actualResult);
    }

}
