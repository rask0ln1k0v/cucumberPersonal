package com.cybertek.step_definitions;

import com.cybertek.utilities.ConfigurationReader;
import com.cybertek.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class Etsy_StepDefinitions {

    @Given("user is on the Etsy landing page")
    public void user_is_on_the_etsy_landing_page() {
        String url = ConfigurationReader.getProperty("etsyUrl");
        Driver.getDriver().get(url);
    }
    @Then("user should see Etsy title as expected")
    public void user_should_see_etsy_title_as_expected() {

    }

}
