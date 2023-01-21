package com.epam.tc.hw5.steps_bdd;

import com.epam.tc.hw5.common.TestContext;
import com.epam.tc.hw5.pages.HeaderMenuPage;
import com.epam.tc.hw5.pages.MainPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

public class GeneralSteps {

    private WebDriver driver = TestContext.getInstance().get("driver", WebDriver.class);

    private HeaderMenuPage headerMenuPage = new HeaderMenuPage(driver);
    private MainPage mainPage = new MainPage(driver);

    @Given("I open JDI GitHub site")
    public void openHomePage() {
        mainPage.openPage();
    }

    @Given("I login as user \"Roman Iovlev\"")
    public void login() {
        headerMenuPage.clickOnDropdownUserIcon();
        headerMenuPage.waitForElementLocatedBy(driver, headerMenuPage.getFieldUserName());
        headerMenuPage.clickOnFieldUserName();
        headerMenuPage.enterUserName();
        headerMenuPage.clickOnFieldUserPassword();
        headerMenuPage.enterUserPassword();
        headerMenuPage.clickOnloginButton();
    }

    @Given("I click on {string} button in Header")
    public void openServiceHeaderMenu(String buttonName) {
        headerMenuPage.clickOnServiceHeaderMenu(buttonName);}

    @Given("I click on {string} button in Service dropdown")
    @When("I click on {string} button in Service dropdown")
    public void openChoosedElementsPage(String buttonName) {
        headerMenuPage.waitForElementLocatedBy(driver,
                headerMenuPage.getDifferentElementsServiceElement());
        headerMenuPage.clickOnElementsServiceElement(buttonName);
    }

}
