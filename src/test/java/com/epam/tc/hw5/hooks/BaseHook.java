package com.epam.tc.hw5.hooks;

import com.epam.tc.hw5.driver.DriverManager;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class BaseHook {

    @Before
    public void setUp() {
        DriverManager.setupDriver();
    }

    @After
    public void teardownDriver() {
        DriverManager.quitDriver();
    }
}
