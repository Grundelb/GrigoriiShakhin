package com.epam.tc.hw5.driver;

import com.epam.tc.hw5.common.TestContext;
import io.github.bonigarcia.wdm.WebDriverManager;
import java.util.Optional;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverManager {

    private static WebDriver driver;
    private static final int PAGE_LOAD_TIMEOUT = 20;
    private static ThreadLocal<WebDriver> webDriverTreadLocal = new ThreadLocal<>();

    private DriverManager() {
    }

    public static void setupDriver() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
        webDriverTreadLocal.set(driver);
    }

    public static WebDriver getDriver() {
        return webDriverTreadLocal.get();
    }

    public static void quitDriver() {
        Optional.ofNullable(getDriver()).ifPresent(webDriver ->
                webDriver.quit());
        webDriverTreadLocal.remove();
    }
}
