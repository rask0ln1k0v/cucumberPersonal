package com.cybertek.step_definitions;

import com.cybertek.utilities.Driver;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {

    //Import from io.cucumber.java not from junit
    @Before
    public void setupScenario(){
        System.out.println("--Setting up browser with further details...");
    }

    @After
    public void tearDownScenario(){
        System.out.println("--Teardown steps are being applied...");
        Driver.closeDriver();
    }

}
