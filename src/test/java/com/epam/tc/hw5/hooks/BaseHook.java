package com.epam.tc.hw5.hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import com.epam.tc.hw5.common.TestContext;

public class BaseHook {
    private WebDriver driver;

    @BeforeAll
    public static void setUpAll() {
        WebDriverManager.chromedriver().setup();
    }

    @Before
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        TestContext.getInstance().set("driver", driver);
    }

    @After
    public void teardownDriver() {
        if (driver != null) {
            driver.quit();
        }
        TestContext.getInstance().clear();
    }
}
