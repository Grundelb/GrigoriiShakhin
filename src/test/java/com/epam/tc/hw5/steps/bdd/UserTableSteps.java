package com.epam.tc.hw5.steps.bdd;

import static org.assertj.core.api.Assertions.assertThat;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import java.util.ArrayList;
import java.util.List;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.WebElement;

public class UserTableSteps extends AbstractStep {

    @When("I select vip checkbox for Sergey Ivan")
    public void selectCheckboxSergeyIvan() {
        userTablePage.clickOnSergeiIvanUserTableCheckbox();
    }

    @Then("1 log row has Vip: condition changed to true text in log section")
    public void checkThatLogRowHasTextInLogSection() {
        assertThat(userTablePage.getVipUserTableLogRow().isDisplayed());
    }

    @Then("{string} page should be opened")
    public void checkThatUserTablePageIsOpened(String pageTitle) {
        assertThat(userTablePage.getBrowserTitle()).isEqualTo(pageTitle);
    }

    @Then("{int} Number Type Dropdowns should be displayed on Users Table on User Table Page")
    public void checkThatUserTablePageConatainAllDropDowns(Integer dropdownCount) {
        assertThat(userTablePage.getDropDowns()).hasSize(dropdownCount);
    }

    @Then("{int} Usernames should be displayed on Users Table on User Table Page")
    public void usernamesShouldBeDisplayedOnUsersTableOnUserTablePage(Integer userCount) {
        assertThat(userTablePage.getUserNames()).hasSize(userCount);
    }

    @Then("{int} Description texts under images should be displayed on Users Table on User Table Page")
    public void descriptionTextsUnderImagesShouldBeDisplayedOnUsersTableOnUserTablePage(Integer descriptionTextCount) {
        assertThat(userTablePage.getDescriptionTexts()).hasSize(descriptionTextCount);
    }

    @Then("{int} checkboxes should be displayed on Users Table on User Table Page")
    public void checkboxesShouldBeDisplayedOnUsersTableOnUserTablePage(Integer checkboxesCount) {
        assertThat(userTablePage.getAllCheckboxes()).hasSize(checkboxesCount);
    }

    @Then("User table should contain following values:")
    public void userTableShouldContainFollowingValues(DataTable dataTable) {
        SoftAssertions softly = new SoftAssertions();
        List<List<String>> list = dataTable.asLists();
        List<List<String>> listData = new ArrayList<>(list);
        listData.remove(0);

        boolean numbers = userTablePage.getNumberType()
                .stream()
                .anyMatch(element -> listData.get(0)
                        .contains(Integer.parseInt(element.getText())));
        softly.assertThat(numbers).isTrue();
        boolean users = userTablePage.getUsers()
                .stream()
                .anyMatch(element -> listData.get(1)
                        .contains(element.getText()));
        softly.assertThat(users).isTrue();
        boolean text = userTablePage.getDescriptionTexts()
                .stream()
                .anyMatch(element -> listData.get(2)
                        .contains(element.getText()));
        softly.assertThat(text).isTrue();

        softly.assertAll();
    }

    @Then("droplist should contain values in column Type for user Roman")
    public void droplistShouldContainValuesInColumnTypeForUserRoman(List<String> expectedCheckboxes) {
        assertThat(userTablePage.getCheckBoxes())
                .extracting(WebElement::getText)
                .as("Some of the checkboxes are not as expected")
                .containsAll(expectedCheckboxes);
    }
}
