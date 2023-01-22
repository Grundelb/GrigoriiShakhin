package com.epam.tc.hw5.steps_bdd;

import com.epam.tc.hw5.common.TestContext;
import com.epam.tc.hw5.pages.HeaderMenuPage;
import com.epam.tc.hw5.pages.MainPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class GeneralSteps extends AbstractStep{

    @Given("I open JDI GitHub site")
    public void openHomePage() {
        mainPage.openPage();
    }

    @Given("I login as user \"Roman Iovlev\"")
    public void login() {
        WebDriver driver = TestContext.getInstance().get("driver", ChromeDriver.class);
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

    @And("I click on {string} button in Service dropdown")
    public void openChoosedElementsPage(String buttonName) {
        WebDriver driver = TestContext.getInstance().get("driver", ChromeDriver.class);
        headerMenuPage.waitForElementLocatedBy(driver,
                headerMenuPage.getDifferentElementsServiceElement());
        headerMenuPage.clickOnElementsServiceElement(buttonName);
    }

}
