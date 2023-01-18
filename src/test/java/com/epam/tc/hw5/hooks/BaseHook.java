package com.epam.tc.hw5.hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import com.epam.tc.hw5.common.TestContext;

public class BaseHook {
    private WebDriver driver;

    @Before
    public void setUp() {
        driver = new ChromeDriver();
        WebDriverManager.chromedriver().setup();
        driver.manage().window().maximize();
        TestContext.getInstance().set("driver", driver);
    }

    @After
    protected void teardownDriver() {
        if (driver != null) {
            driver.quit();
        }
        TestContext.getInstance().clear();
    }
}
