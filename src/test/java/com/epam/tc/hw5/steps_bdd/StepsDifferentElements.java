package com.epam.tc.hw5.steps_bdd;

import com.epam.tc.hw5.pages.DifferentElementsPage;
import com.epam.tc.hw5.pages.HeaderMenuPage;
import com.epam.tc.hw5.pages.MainPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Iterator;

public class StepsDifferentElements extends AbstractStep{
    private MainPage mainPage;
    private DifferentElementsPage differentElementsPage;
    private HeaderMenuPage headerMenuPage;

    public StepsDifferentElements(WebDriver driver) {
        super(driver);
        differentElementsPage = new DifferentElementsPage(driver);
        headerMenuPage = new HeaderMenuPage(driver);
        mainPage = new MainPage(driver);
    }

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

    @Given("I click on \"Service\" button in Header")
    public void openServiceHeaderMenu() {
        headerMenuPage.clickOnServiceHeaderMenu();}

    @Given("I click on \"Different Elements\" button in Service dropdown")
    public void openDifferentElementsPage() {
        headerMenuPage.waitForElementLocatedBy(driver,
                headerMenuPage.getDifferentElementsServiceElement());
        headerMenuPage.clickOnDifferentElementsServiceElement();
    }

    @When("I select checkboxes \"Water\" and \"Wind\"")
    public void setupDifferentElementPageCheckboxes() {
        differentElementsPage.waitForElementLocatedBy(driver, differentElementsPage.getWaterCheckbox());
        differentElementsPage.clickOnWaterCheckbox();
        differentElementsPage.clickOnWindCheckbox();
    }

    @When("I select radiobutton \"Selen\"")
    public void setupDifferentElementPageRadiobutton() {
        differentElementsPage.clickOnSelenRadioButton();
    }

    @When("I click on dropdown and select \"Yellow\"")
    public void setupDifferentElementPageDropdown(){
        differentElementsPage.clickOnColorsDropDownMenu();
        differentElementsPage.clickOnYellowOptionColors();
    }

    @Then("Log rows should contain following values:")
    public void assertThatDifferentElementsPageIsCorrect() {
        SoftAssertions softly = new SoftAssertions();
        Iterator<WebElement> webElementIterator = differentElementsPage.verifyLogs().iterator();
        while (webElementIterator.hasNext()) {
            softly.assertThat(webElementIterator.next().isDisplayed());
        }
        softly.assertAll();
    }

}
