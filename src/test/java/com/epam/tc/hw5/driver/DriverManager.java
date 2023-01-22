package com.epam.tc.hw5.driver;

import com.epam.tc.hw5.common.TestContext;
import io.github.bonigarcia.wdm.WebDriverManager;
import java.util.Optional;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverManager {

    private static final int PAGE_LOAD_TIMEOUT = 20;

    private DriverManager() {
    }

    public static void setupDriver() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
        TestContext.getInstance().set("driver", driver);
    }

    public static WebDriver getDriver() {
        return TestContext.getInstance().get("driver", ChromeDriver.class);
    }

    public static void quitDriver() {
        Optional.ofNullable(getDriver()).ifPresent(webDriver ->
                webDriver.quit());
        TestContext.getInstance().clear();
    }

}
