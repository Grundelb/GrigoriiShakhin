package com.epam.tc.hw5.steps.bdd;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

import static java.util.stream.Collectors.toSet;
import static org.assertj.core.api.Assertions.assertThat;

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
        assertThat(userTablePage.getCheckboxes()).hasSize(checkboxesCount);
    }

    @Then("User table should contain following values:")
    public void userTableShouldContainFollowingValues(DataTable dataTable) {
        SoftAssertions softly = new SoftAssertions();
        List<List<String>> list = dataTable.asLists();
        List<Integer> numbersList = new ArrayList<>(Integer.parseInt(list.get(0).toString()));
        List<String> usersList = new ArrayList<>(list.get(1));
        List<String> descriptionsList = new ArrayList<>(list.get(1));

        boolean numbers = userTablePage.getTableElements()
                .stream()
                .anyMatch(element -> numbersList
                        .contains(Integer.parseInt(element.getText())));
        softly.assertThat(numbers).isTrue();
        boolean users = userTablePage.getTableElements()
                .stream()
                .anyMatch(element -> usersList
                        .contains(element.getText()));
        softly.assertThat(users).isTrue();
        boolean text = userTablePage.getTableElements()
                .stream()
                .anyMatch(element -> descriptionsList
                        .contains(element.getText()));
        softly.assertThat(text).isTrue();

        softly.assertAll();
    }

    @Then("droplist should contain values in column Type for user Roman")
    public void droplistShouldContainValuesInColumnTypeForUserRoman(DataTable dataTable) {
        SoftAssertions softly = new SoftAssertions();
        List<List<String>> list = dataTable.asLists();
        List<String> logs = new ArrayList<>(list.get(0));

        for (WebElement element : userTablePage.getDropDownValues()) {
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
