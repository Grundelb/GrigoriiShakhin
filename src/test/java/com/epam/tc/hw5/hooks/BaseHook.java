package com.epam.tc.hw5.hooks;

import com.epam.tc.hw5.driver.DriverManager;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeStep;

public class BaseHook {
    @Before
    public void setupDriver() {
        DriverManager.setupDriver();
    }

    @After
    public void teardownDriver() {
        DriverManager.quitDriver();
    }
}
