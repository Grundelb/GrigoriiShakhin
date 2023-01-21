package com.epam.tc.hw5.steps_bdd;

import com.epam.tc.hw5.common.TestContext;
import com.epam.tc.hw5.pages.DifferentElementsPage;
import com.epam.tc.hw5.pages.HeaderMenuPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.Iterator;

public class DifferentElementsSteps {
    private WebDriver driver = TestContext.getInstance().get("driver", ChromeDriver.class);
    private DifferentElementsPage differentElementsPage = new DifferentElementsPage(driver);
    private HeaderMenuPage headerMenuPage = new HeaderMenuPage(driver);

    @When("I select {string} checkbox")
    public void setupDifferentElementPageCheckboxes(String checkboxName) {
        differentElementsPage.clickOnCheckbox(checkboxName);
    }

    @When("I select radiobutton {string}")
    public void setupDifferentElementPageRadiobutton(String radiobuttonName) {
        differentElementsPage.clickOnRadioButton(radiobuttonName);
    }

    @When("I click on dropdown and select {string}")
    public void setupDifferentElementPageDropdown(String elementName){
        differentElementsPage.clickOnColorsDropDownMenu();
        differentElementsPage.clickOnOptionColors(elementName);
    }

    @Then("Log rows should contain following values:")
    public void assertThatDifferentElementsPageIsCorrect(String Description) {
        SoftAssertions softly = new SoftAssertions();
        Iterator<WebElement> webElementIterator = differentElementsPage.verifyLogs().iterator();
        while (webElementIterator.hasNext()) {
            softly.assertThat(webElementIterator.next().getText().contains(Description));
        }
        softly.assertAll();
    }
}
