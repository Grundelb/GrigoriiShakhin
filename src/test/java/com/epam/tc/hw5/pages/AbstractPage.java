package com.epam.tc.hw5.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AbstractPage {

    protected static WebDriver driver;
    protected static final String HOMEPAGE_URL = "https://jdi-testing.github.io/jdi-light/index.html";
    protected static final int waitTimeoutSeconds = 10;

    public AbstractPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public WebElement waitForElementLocatedBy(WebDriver driver, WebElement webElement) {
        return new WebDriverWait(driver, waitTimeoutSeconds)
                .until(ExpectedConditions.visibilityOf(webElement));
    }
}
