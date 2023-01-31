package com.epam.tc.hw5.steps.bdd;

import io.cucumber.java.en.When;

public class GeneralSteps extends AbstractStep {

    @When("I open JDI GitHub site")
    public void openHomePage() {
        mainPage.openPage();
    }

    @When("I login as user \"Roman Iovlev\"")
    public void login() {
        headerMenuPage.clickOnDropdownUserIcon();
        headerMenuPage.clickOnFieldUserName();
        headerMenuPage.enterUserName();
        headerMenuPage.clickOnFieldUserPassword();
        headerMenuPage.enterUserPassword();
        headerMenuPage.clickOnloginButton();
    }

    @When("I click on {string} button in Header")
    public void openServiceHeaderMenu(String buttonName) {
        headerMenuPage.clickOnServiceHeaderMenu(buttonName);
    }

    @When("I click on {string} button in Service dropdown")
    public void openChoosedElementsPage(String buttonName) {
        headerMenuPage.clickOnElementsServiceElement(buttonName);
    }
}
