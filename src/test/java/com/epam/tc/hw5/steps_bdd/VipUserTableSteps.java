package com.epam.tc.hw5.steps_bdd;

import com.epam.tc.hw5.common.TestContext;
import com.epam.tc.hw5.pages.HeaderMenuPage;
import com.epam.tc.hw5.pages.MainPage;
import com.epam.tc.hw5.pages.UserTablePage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class VipUserTableSteps extends AbstractStep{

    HeaderMenuPage headerMenuPage;
    MainPage mainPage;
    UserTablePage userTablePage;

    protected VipUserTableSteps(WebDriver driver) {
        super(driver);
    }

    @Given("I open JDI GitHub site")
    public void openHomePage() {
        mainPage.openPage();
    }

    @Given("I login as user Roman Iovlev")
    public void login() {
        headerMenuPage.clickOnDropdownUserIcon();
        headerMenuPage.waitForElementLocatedBy(driver, headerMenuPage.getFieldUserName());
        headerMenuPage.clickOnFieldUserName();
        headerMenuPage.enterUserName();
        headerMenuPage.clickOnFieldUserPassword();
        headerMenuPage.enterUserPassword();
        headerMenuPage.clickOnloginButton();
    }

    @Given("I click on Service button in Header")
    public void i_click_on_button_in_header() {
        headerMenuPage.clickOnServiceHeaderMenu();
    }

    @Given("I click on User Table button in Service dropdown")
    public void i_click_on_button_in_service_dropdown() {
        headerMenuPage.clickOnUserTableServiceElement();
    }

    @When("I select vip checkbox for Sergey Ivan")
    public void i_select_checkbox_for() {
        userTablePage.clickOnSergeiIvanUserTableCheckbox();
    }

    @Then("1 log row has Vip: condition changed to true text in log section")
    public void log_row_has_text_in_log_section() {
        Assertions.assertThat(userTablePage.getVipUserTableLogRow().isDisplayed());
    }


}
