package com.cybertek.step_definitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.List;

public class DataTables_StepDefinitions {

    @Given("user is on the login page of library app")
    public void user_is_on_the_login_page_of_library_app() {
        System.out.println("User is on the login page!");
    }
    @When("user enters username and password as below")
    public void user_enters_username_and_password_as_below(io.cucumber.datatable.DataTable dataTable) {
        // Write code here that turns the phrase above into concrete actions
        // For automatic transformation, change DataTable to one of
        // E, List<E>, List<List<E>>, List<Map<K,V>>, Map<K,V> or
        // Map<K, List<V>>. E,K,V must be a String, Integer, Float,
        // Double, Byte, Short, Long, BigInteger or BigDecimal.
        //
        // For other transformations you can register a DataTableType.
        throw new io.cucumber.java.PendingException();
    }
    @Then("user should see title is something")
    public void user_should_see_title_is_something() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }


    @Then("user should see below words displayed")
    public void user_should_see_below_words_displayed(List<String> listOfFruits) {

        System.out.println("listOfFruits.size() = " + listOfFruits.size());
        System.out.println("listOfFruits = " + listOfFruits);


    }


}
