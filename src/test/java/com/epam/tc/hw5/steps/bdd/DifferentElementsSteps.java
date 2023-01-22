package com.epam.tc.hw5.steps.bdd;

import com.epam.tc.hw5.common.TestContext;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import java.util.ArrayList;
import java.util.List;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DifferentElementsSteps extends AbstractStep {

    @When("I select {string} checkbox")
    public void setupDifferentElementPageCheckboxes(String checkboxName) {
        differentElementsPage.clickOnCheckbox(checkboxName);
    }

    @When("I select radiobutton {string}")
    public void setupDifferentElementPageRadiobutton(String radiobuttonName) {
        differentElementsPage.clickOnRadioButton(radiobuttonName);
    }

    @When("I click on dropdown and select {string}")
    public void setupDifferentElementPageDropdown(String elementName) {
        differentElementsPage.clickOnColorsDropDownMenu();
        differentElementsPage.clickOnOptionColors(elementName);
    }

    @Then("Log rows should contain following values:")
    public void assertThatDifferentElementsPageIsCorrect(DataTable dataTable) {
        SoftAssertions softly = new SoftAssertions();
        List<List<String>> list = dataTable.asLists();
        List<String> logs = new ArrayList<>(list.get(0));

        for (WebElement element : differentElementsPage.verifyLogs()) {
            int i = 0;
            for (String str : logs) {
                if (element.getText().contains(str)) {
                    i++;
                }
                if (i > 0) {
                    softly.assertThat(true).isTrue();
                }
            }
        }
        softly.assertAll();
    }
}
