package com.epam.tc.hw5.tests;

import com.epam.tc.hw5.steps.ActionStep;
import com.epam.tc.hw5.steps.AssertionStep;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

public abstract class AbstractTest {

    protected WebDriver driver;
    protected ActionStep actionStep;
    protected AssertionStep assertionStep;

    @BeforeClass
    protected void setDriver(ITestContext context) {
        driver = new ChromeDriver();
        WebDriverManager.chromedriver().setup();
        driver.manage().window().maximize();
        context.setAttribute("driver", driver);
    }

    @AfterClass
    protected void teardownDriver() {
        if (driver != null) {
            driver.quit();
        }
    }

    @BeforeMethod
    protected void setUp() {
        actionStep = new ActionStep(driver);
        assertionStep = new AssertionStep(driver);
    }
}
