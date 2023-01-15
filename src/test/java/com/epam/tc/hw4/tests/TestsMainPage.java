package com.epam.tc.hw4.tests;

import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.annotations.Test;

@Feature("Main Page")
@Story("Check Main page options")
public class TestsMainPage extends AbstractTest {

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

    @Test(priority = 3, description = "Assert that there are 4 items on the header section are displayed"
            + " and they have proper texts")
    public void verifyHeaderMenuElements() {
        assertionStep.assertThatHeaderMenuElementsAreDisplayed();
    }

    @Test(priority = 4, description = "Assert that there are 4 images on the Index Page and they are displayed")
    public void verifyImages() {
        actionStep.scrollDown();
        assertionStep.assertThatImagesAreDisplayed();
    }

    @Test(priority = 5, description = "Assert that there are 4 texts "
            + "on the Index Page under icons and they have proper text",
            dataProviderClass = DataProviderTest.class, dataProvider = "textIconsCorrectData")
    public void verifyTexts(String result) {
        assertionStep.assertThatTextsAreCorrect(result);
    }

    @Test(priority = 6, description = "Assert that there is the iframe with “Frame Button” exist "
            + "and check that there is “Frame Button” in the iframe")
    public void verifyFrame() {
        actionStep.scrollUp();
        assertionStep.assertThatFrameIsDisplayed();
        assertionStep.assertThatFrameButtonIsDisplayed();
    }

    @Test(priority = 7, description = "Assert that there are 5 items "
            + "in the Left Section are displayed and they have proper text")
    public void verifyLeftMenuElements() {
        assertionStep.assertThatLeftMenuElementsAreDisplayed();
    }
}
