package com.epam.tc.hw5.steps_bdd;

import org.openqa.selenium.WebDriver;

public abstract class AbstractStep {

    protected WebDriver driver;

    protected AbstractStep(WebDriver driver) {
        this.driver = driver;
    }

    protected void teardownDriver() {
        if (driver != null) {
            driver.quit();
        }
    }
}
