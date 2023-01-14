package com.epam.tc.hw4.steps;

import com.epam.tc.hw4.pages.DifferentElementsPage;
import com.epam.tc.hw4.pages.HeaderMenuPage;
import com.epam.tc.hw4.pages.LeftMenuPage;
import com.epam.tc.hw4.pages.MainPage;
import io.qameta.allure.Step;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class ActionStep extends AbstractStep {

    private final String scrollFooter = "window.scrollBy(0,500)";
    private final String scrollHeader = "window.scrollBy(0,-500)";

    private final DifferentElementsPage differentElementsPage;
    private final HeaderMenuPage headerMenuPage;
    private final LeftMenuPage leftMenuPage;
    private final MainPage mainPage;

    public ActionStep(WebDriver driver) {
        super(driver);
        differentElementsPage = new DifferentElementsPage(driver);
        headerMenuPage = new HeaderMenuPage(driver);
        leftMenuPage = new LeftMenuPage(driver);
        mainPage = new MainPage(driver);
    }

    @Step
    public void setupDifferentElementPage() {
        differentElementsPage.waitForElementLocatedBy(driver, differentElementsPage.getWaterCheckbox());
        differentElementsPage.clickOnWaterCheckbox();
        differentElementsPage.clickOnWindCheckbox();
        differentElementsPage.clickOnSelenRadioButton();
        differentElementsPage.clickOnColorsDropDownMenu();
        differentElementsPage.clickOnYellowOptionColors();
    }

    @Step
    public void login() {
        headerMenuPage.clickOnDropdownUserIcon();
        headerMenuPage.waitForElementLocatedBy(driver, headerMenuPage.getFieldUserName());
        headerMenuPage.clickOnFieldUserName();
        headerMenuPage.enterUserName();
        headerMenuPage.clickOnFieldUserPassword();
        headerMenuPage.enterUserPassword();
        headerMenuPage.clickOnloginButton();
    }

    @Step
    public void openDifferentElementsPage() {
        headerMenuPage.clickOnServiceHeaderMenu();
        headerMenuPage.waitForElementLocatedBy(driver,
                headerMenuPage.getDifferentElementsServiceElement());
        headerMenuPage.clickOnDifferentElementsServiceElement();
    }

    @Step
    public void openHomePage() {
        mainPage.openPage();
    }

    @Step
    public void scrollUp() {
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript(scrollHeader);
    }

    @Step
    public void scrollDown() {
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript(scrollFooter);
    }

}
