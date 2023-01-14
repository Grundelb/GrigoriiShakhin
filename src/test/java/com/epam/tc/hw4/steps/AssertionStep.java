package com.epam.tc.hw4.steps;

import com.epam.tc.hw4.pages.DifferentElementsPage;
import com.epam.tc.hw4.pages.HeaderMenuPage;
import com.epam.tc.hw4.pages.LeftMenuPage;
import com.epam.tc.hw4.pages.MainPage;
import io.qameta.allure.Step;
import org.assertj.core.api.Assertions;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Iterator;

public class AssertionStep extends ActionStep {

    private DifferentElementsPage differentElementsPage;
    private HeaderMenuPage headerMenuPage;
    private MainPage mainPage;
    private LeftMenuPage leftMenuPage;

    public AssertionStep(WebDriver driver) {
        super(driver);
        differentElementsPage = new DifferentElementsPage(driver);
        headerMenuPage = new HeaderMenuPage(driver);
        mainPage = new MainPage(driver);
    }

    @Step
    public void assertThatBrowserTitleIsCorrect(String result) {
        String actualTitle = mainPage.getBrowserTitle();
        Assertions.assertThat(actualTitle).isEqualTo(result);
    }


    @Step
    public void assertThatUserNameIsCorrect(String result) {
        String actualUserName = headerMenuPage.getUserNameHeaderText();
        Assertions.assertThat(actualUserName).isEqualTo(result);
    }


    @Step
    public void assertThatDifferentElementsPageIsCorrect() {
        SoftAssertions softly = new SoftAssertions();
        Iterator<WebElement> webElementIterator = differentElementsPage.verifyLogs().iterator();
        while (webElementIterator.hasNext()) {
            softly.assertThat(webElementIterator.next().isDisplayed());
        }
        softly.assertAll();
    }

    @Step
    public void assertThatHeaderMenuElementsAreDisplayed() {
        SoftAssertions softly = new SoftAssertions();
        Iterator<WebElement> webElementIterator = headerMenuPage.verifyHeaderMenuElements().iterator();
        while (webElementIterator.hasNext()) {
            softly.assertThat(webElementIterator.next().isDisplayed());
        }
        softly.assertAll();
    }

    @Step
    public void assertThatImagesAreDisplayed() {
        SoftAssertions softly = new SoftAssertions();
        Iterator<WebElement> webElementIterator = mainPage.getIconsHomePage().iterator();
        while (webElementIterator.hasNext()) {
            softly.assertThat(webElementIterator.next().isDisplayed());
        }
        softly.assertAll();
    }

    @Step
    public void assertThatTextsAreCorrect(String result) {
        Assertions.assertThat(mainPage.getTextsIconsHomePage())
                .contains(result);

    }

    @Step
    public void assertThatFrameIsDisplayed() {
        mainPage.switchToFrame();
        Assertions.assertThat(mainPage.getFrame().isDisplayed());
    }

    @Step
    public void assertThatFrameButtonIsDisplayed() {
        Assertions.assertThat(mainPage.getFrameButton().isDisplayed());
        mainPage.switchToHomePage();
    }


    @Step
    public void assertThatLeftMenuElementsAreDisplayed() {
        SoftAssertions softly = new SoftAssertions();
        Iterator<WebElement> webElementIterator = leftMenuPage.verifyLeftMenu().iterator();
        while (webElementIterator.hasNext()) {
            softly.assertThat(webElementIterator.next().isDisplayed());
        }
        softly.assertAll();
    }
}
