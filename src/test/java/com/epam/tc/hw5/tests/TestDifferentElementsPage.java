package com.epam.tc.hw5.tests;

import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.annotations.Test;

@Feature("Different Elements Page")
@Story("Check Different Elements Page options")
public class TestDifferentElementsPage extends AbstractTest {
    @Test(priority = 1, description = "Assert that browser title is displayed",
            dataProviderClass = DataProviderTest.class, dataProvider = "browserTitleCorrectData")
    public void verifyBrowserTitle(String result) {
        actionStep.openHomePage();
        assertionStep.assertThatBrowserTitleIsCorrect(result);
    }

    @Test(priority = 2, description = "Assert that user name is displayed",
            dataProviderClass = DataProviderTest.class,
            dataProvider = "userNameCorrectData")
    public void verifyUserName(String result) {
        actionStep.login();
        assertionStep.assertThatUserNameIsCorrect(result);
    }

    @Test(priority = 3, description = "Assert that"
            + "• for each checkbox there is an individual log row and value is corresponded to the status of checkbox"
            + "• for radio button there is a log row and value is corresponded to the status of radio button"
            + "• for dropdown there is a log row and value is corresponded to the selected value.")
    public void verifyDifferentElementsPage() {
        actionStep.openDifferentElementsPage();
        actionStep.setupDifferentElementPage();
        assertionStep.assertThatDifferentElementsPageIsCorrect();
    }

}
