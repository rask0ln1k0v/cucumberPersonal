package com.cybertek.step_definitions;

import com.cybertek.utilities.ConfigurationReader;
import com.cybertek.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import java.security.Key;

public class Dice_JobSearchStepDefs {

    @Given("User is on dice homepage")
    public void user_is_on_dice_homepage() {
        System.out.println("USER IS ON DICE HOMEPAGE");
        Driver.getDriver().get(ConfigurationReader.getProperty("dice.url"));
    }

    @When("User enters keyword and zipcode")
    public void user_enters_keyword_and_zipcode() {
        System.out.println("USER ENTERS JAVA AND 11230");
        WebElement keyword = Driver.getDriver().findElement(By.id("typeaheadInput"));
        WebElement zipcode = Driver.getDriver().findElement(By.id("google-location-search"));
        keyword.sendKeys("Java");
        zipcode.sendKeys("11230", Keys.ENTER);
    }

    @Then("User should see search results")
    public void user_should_see_search_results() {
        System.out.println("USER SHOULD SEE SEARCH RESULTS..");
        WebElement results =Driver.getDriver().findElement(By.xpath("//div[.='Filter Results:']"));
        WebElement searchCount = Driver.getDriver().findElement(By.xpath("//span[@data-cy='search-count']"));

        System.out.println("Job Count: " + searchCount.getText());
        Assert.assertTrue(results.isDisplayed());
    }

}
