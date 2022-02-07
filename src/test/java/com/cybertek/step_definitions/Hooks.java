package com.cybertek.step_definitions;


import com.cybertek.utilities.DBUtils;
import com.cybertek.utilities.Driver;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class Hooks {

    @Before
    public void setUpScenario(){
        System.out.println("BEFORE - setUp method is running before the scenario");
    }


    @After
    public void tearDownScenario(Scenario scenario) {
        /**
         * Scenario scenario: represents current running cucumber scenario
         * -cast webdriver to TakesScreenshot interface.(TakesScreenshot)Driver.getDriver()
         * -call getScreenShotAs method and output type as OutputType.BYTES
         * -save the result into byte[] array: byte[] image
         * -attach the image into the scenario html report: scenario.attach(image, "image/png", scenario.getName());
         */
        if (scenario.isFailed()) {
            byte[] image = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(image, "image/png", scenario.getName());
        }

        System.out.println("AFTER - tearDown method is running after the scenario:" + scenario.getName());
//        Driver.closeDriver();
    }

    @Before("@db")
    public void setupDB(){
        System.out.println("Setting up database connection");
        DBUtils.createConnection();
    }

    @After("@db")
    public void teardownDB(){
        System.out.println("Closing db connection");
        DBUtils.destroy();
    }

//    @AfterStep
//    public void tearDownStep(Scenario scenario){
//        byte[] image = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
//        scenario.attach(image, "image/png", scenario.getName());
//    }

}
