package com.epam.tc.hw5.steps_bdd;

import com.epam.tc.hw5.common.TestContext;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DifferentElementsSteps extends AbstractStep {

    @When("I select {string} checkbox")
    public void setupDifferentElementPageCheckboxes(String checkboxName) {
        WebDriver driver = TestContext.getInstance().get("driver", ChromeDriver.class);
        differentElementsPage.waitForElementLocatedBy(driver,
                differentElementsPage.getCheckbox(checkboxName));
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
    public void assertThatDifferentElementsPageIsCorrect(DataTable dataTable) {
        SoftAssertions softly = new SoftAssertions();
       List<List<String>> list = dataTable.asLists(String.class);
        List<String> logs = new ArrayList<>(list.get(0));

        for (WebElement element: differentElementsPage.verifyLogs()) {
            for (String str:logs) {
                softly.assertThat(element.getText().contains(str)).isTrue();
            }
        }
        softly.assertAll();
    }
}
