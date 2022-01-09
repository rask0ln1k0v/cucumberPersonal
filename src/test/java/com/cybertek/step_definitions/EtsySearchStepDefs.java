package com.cybertek.step_definitions;

import com.cybertek.pages.EtsyAllCategoriesPage;
import com.cybertek.pages.EtsyHomePage;
import com.cybertek.utilities.BrowserUtils;
import com.cybertek.utilities.ConfigurationReader;
import com.cybertek.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.fr.Et;
import org.junit.After;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class EtsySearchStepDefs {

    WebDriver driver;

    @Given("User is on etsy homepage")
    public void user_is_on_etsy_homepage() {
        driver = Driver.getDriver();
        Driver.getDriver().get(ConfigurationReader.getProperty("etsy.url"));
    }
    @Then("page title should be as expected")
    public void page_title_should_be_as_expected() {
        String expTitle = "Etsy - Shop for handmade, vintage, custom, and unique gifts for everyone";
        String actTitle = driver.getTitle();
        Assert.assertEquals(expTitle,actTitle);
    }
    @When("User searches for wooden spoon")
    public void user_searches_for_wooden_spoon() {
        EtsyHomePage homepage = new EtsyHomePage();
        homepage.searchFor("Wooden spoon");

    }
    @Then("Page title should start with wooden spoon")
    public void page_title_should_start_with_wooden_spoon() {
        BrowserUtils.sleep(1);
    Assert.assertTrue(driver.getTitle().startsWith("Wooden spoon"));
    }


    @When("User searches for empty value")
    public void userSearchesForEmptyValue() {
        EtsyHomePage homepage = new EtsyHomePage();
        homepage.searchFor("");

    }

    @Then("All categories should be displayed")
    public void allCategoriesShouldBeDisplayed() {

        WebDriverWait wait = new WebDriverWait(driver,20);
        wait.until(ExpectedConditions.titleIs("All categories | Etsy"));

        Assert.assertEquals("All categories | Etsy", driver.getTitle()); //1
        EtsyAllCategoriesPage etsyAllCategoriesPage = new EtsyAllCategoriesPage(); //2
        Assert.assertTrue(etsyAllCategoriesPage.allCategoriesHeader.isDisplayed());
    }
}
