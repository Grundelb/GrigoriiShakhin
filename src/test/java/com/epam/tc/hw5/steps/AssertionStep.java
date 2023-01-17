package com.epam.tc.hw5.steps;

import com.epam.tc.hw5.pages.DifferentElementsPage;
import com.epam.tc.hw5.pages.HeaderMenuPage;
import com.epam.tc.hw5.pages.LeftMenuPage;
import com.epam.tc.hw5.pages.MainPage;
import io.qameta.allure.Step;
import java.util.Iterator;
import org.assertj.core.api.Assertions;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

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
        leftMenuPage = new LeftMenuPage(driver);
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
        Assertions.assertThat(mainPage.getFrame().isDisplayed());
        mainPage.switchToFrame();
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
