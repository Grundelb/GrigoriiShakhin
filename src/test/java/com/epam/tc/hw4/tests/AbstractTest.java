package com.epam.tc.hw4.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

public abstract class AbstractTest {

    protected SoftAssertions softly;
    protected WebDriver driver;

    @BeforeClass
    protected void setDriver() {
        driver = new ChromeDriver();
        WebDriverManager.chromedriver().setup();
        driver.manage().window().maximize();
    }

    @AfterClass
    protected void teardownDriver() {
        if (driver != null) {
            driver.quit();
        }
    }
}