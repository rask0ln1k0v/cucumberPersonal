package com.cybertek.step_definitions;

import com.cybertek.pages.CloudTables_HomePage;
import com.cybertek.utilities.ConfigurationReader;
import com.cybertek.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CloudTables_StepDefs {
    CloudTables_HomePage cloudPage = new CloudTables_HomePage();


    @Given("User is on cloudtables homepage")
    public void user_is_on_cloudtables_homepage() {

        Driver.getDriver().get(ConfigurationReader.getProperty("cloudtables.url"));
        String expectedTitle = "Editor | Editing for DataTables";
        String actualTitle = Driver.getDriver().getTitle();
        Assert.assertEquals(expectedTitle,actualTitle);
    }
    @When("User clicks on New button")
    public void user_clicks_on_new_button() {
cloudPage.newBtn.click();
    }

    @When("User enters {string} to firstname field")
    public void user_enters_to_firstname_field(String firstName) {
    cloudPage.firstNameField.sendKeys(firstName);
    }
    @And("User enters {string} to lastname field")
    public void user_enters_to_lastname_field(String lastName) {
cloudPage.lastNameField.sendKeys(lastName);
    }
    @And("User enters {string} to position field")
    public void user_enters_to_position_field(String position) {
cloudPage.positionField.sendKeys(position);
    }
    @And("User enters {string} to salary field")
    public void user_enters_to_salary_field(String salary) {
cloudPage.salaryField.sendKeys(salary);
    }
    @And("User clicks on create button")
    public void user_clicks_on_create_button() {
cloudPage.createBtn.click();
    }



    @Then("User {string} and {string} should be created")
    public void userAndShouldBeCreated(String firstname, String lastname) {
    cloudPage.searchField.sendKeys(firstname, Keys.ENTER);
    String expectedUser = firstname+ " " + lastname;
    String actualUser = cloudPage.newAddedUser.getText();
    Assert.assertTrue(actualUser.contains(expectedUser));

    }
}
