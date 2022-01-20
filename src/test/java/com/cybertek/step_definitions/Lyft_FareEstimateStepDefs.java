package com.cybertek.step_definitions;

import com.cybertek.pages.BasePage;
import com.cybertek.pages.LyftHomePage;
import com.cybertek.pages.VyTrack_LoginPage;
import com.cybertek.utilities.BrowserUtils;
import com.cybertek.utilities.ConfigurationReader;
import com.cybertek.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.jsoup.Connection;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import static org.junit.Assert.*;



public class Lyft_FareEstimateStepDefs {
    LyftHomePage lyftHomePage = new LyftHomePage();

    @Given("User is lyft fare estimate page")
    public void user_is_lyft_fare_estimate_page() {
        Driver.getDriver().get(ConfigurationReader.getProperty("lyft_price_estimate.url"));
        String expectedTitle = "Get Fare Estimates for Your City - Lyft Price Estimate | Lyft";
        String actualTitle = Driver.getDriver().getTitle();
        assertEquals("Fare estimate page isn't displayed",expectedTitle,actualTitle);
    }
    @And("User enters {string} to pickup address")
    public void user_enters_to_pickup_address(String pickUpLocation) {
    lyftHomePage.pickUpField.sendKeys(pickUpLocation);



    }

    @And("User enters {string} to drop address")
    public void user_enters_to_drop_address(String dropOffLocation) {
        lyftHomePage.dropOffField.sendKeys(dropOffLocation);
    }

    @And("User clicks on get estimate")
    public void user_clicks_on_get_estimate() {
        lyftHomePage.getPriceBtn.click();
        BrowserUtils.sleep(1);
        lyftHomePage.getPriceBtn.click();





    }

    @Then("User should see estimated prices")
    public void user_should_see_estimated_prices() {
        assertTrue(lyftHomePage.rideType.isDisplayed());

//        String [] price = lyftHomePage.lyftPrice.getText().split(" "); price[0]
        System.out.println("Lyft price: " +  lyftHomePage.lyftPrice.getText().substring(0,6));


    }


    @Then("User should see error message")
    public void userShouldSeeErrorMessage() {
        assertTrue(lyftHomePage.locationErrorMsg.isDisplayed());
    }
}
