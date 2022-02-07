package com.cybertek.step_definitions;

import com.cybertek.pages.Spartan_AddSpartanPage;
import com.cybertek.pages.Spartan_ConfirmationPage;
import com.cybertek.pages.Spartan_HomePage;
import com.cybertek.pages.Spartan_WebDataPage;
import com.cybertek.utilities.ConfigurationReader;
import com.cybertek.utilities.DBUtils;

import com.cybertek.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.HashMap;
import java.util.Map;

public class SpartanAddUser_StepDefs {

Map <String,String> spartanMap = new HashMap<>();
    @Given("User is on spartan home page")
    public void user_is_on_spartan_home_page() {
        Driver.getDriver().get(ConfigurationReader.getProperty("spartan.url"));

    }
    @When("User goes to Web Data page")
    public void user_goes_to_web_data_page() {
        Spartan_HomePage homePage = new Spartan_HomePage();
        homePage.webDataBtn.click();
    }
    @When("clicks on add spartan")
    public void clicks_on_add_spartan() {
        Spartan_WebDataPage webDataPage = new Spartan_WebDataPage();
        webDataPage.addSpartanBtn.click();
    }
    @When("enters following data and submits:")
    public void enters_following_data_and_submits(Map<String,String> spartanInfo) {
        Spartan_AddSpartanPage addSpartan = new Spartan_AddSpartanPage();

        spartanMap.putAll(spartanInfo);
        System.out.println("spartanMap" + spartanMap);
            addSpartan.nameInput.sendKeys(spartanInfo.get("name"));
            addSpartan.selectGender(spartanInfo.get("gender"));
            addSpartan.phoneNumberInput.sendKeys(spartanInfo.get("phone"));
            addSpartan.submitBtn.click();




    }
    @Then("success message should be displayed")
    public void success_message_should_be_displayed() {
        Spartan_ConfirmationPage detailPage = new Spartan_ConfirmationPage();
        Assert.assertTrue(detailPage.successMsg.isDisplayed());


    }
    @Then("data on confirmation page must be same")
    public void data_on_confirmation_page_must_be_same() {
        Spartan_ConfirmationPage detailPage = new Spartan_ConfirmationPage();

            Assert.assertEquals(detailPage.spartanGender.getAttribute("value"),spartanMap.get("gender"));
            Assert.assertEquals(detailPage.spartanName.getAttribute("value"),spartanMap.get("name"));
            Assert.assertEquals(detailPage.spartanPhone.getAttribute("value"),spartanMap.get("phone"));


    }


    @And("data in database must match")
    public void dataInDatabaseMustMatch() {

        Map<String,Object> dbMap = DBUtils.getRowMap("select * from spartans where name = 'Sissokko'");

        Assert.assertEquals(spartanMap.get("name"),dbMap.get("NAME"));
        Assert.assertEquals(spartanMap.get("gender") , dbMap.get("GENDER"));
        Assert.assertEquals(spartanMap.get("phone") , dbMap.get("PHONE"));


        //delete the spartan data after verification
        DBUtils.executeQuery("DELETE FROM spartans WHERE name = 'Sissokko'");



    }
}
