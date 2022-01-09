package com.cybertek.step_definitions;

import com.cybertek.utilities.Driver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ReRunDemo_StepDefs {

    @Given("User adds two numbers")
    public void user_adds_two_numbers() {
        System.out.println("User adds two numbers");
    }
    @Given("User adds three numbers")
    public void userAddsThreeNumbers() {
        Assert.assertEquals(5,10);
    }


    @Then("Result should be as expected")
    public void resultShouldBeAsExpected() {
        System.out.println("Result is as expected");
    }

    @Then("Result should be sum of three numbers")
    public void resultShouldBeSumOfThreeNumbers() {
        Assert.assertEquals(1,2);
    }

    @Given("User divides two numbers")
    public void userDividesTwoNumbers() {
        System.out.println("something");
    }

    @Then("Result should be division result")
    public void resultShouldBeDivisionResult() {
        System.out.println("pass");
    }


}
