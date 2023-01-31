package com.epam.tc.hw5.pages;

import java.util.ArrayList;
import java.util.List;

import com.epam.tc.hw5.common.TestContext;
import com.epam.tc.hw5.driver.DriverManager;
import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;

@Getter
public class MainPage extends AbstractPage {
    @FindBy(css = ".icons-benefit.icon-practise")
    private WebElement practiseIcon;
    @FindBy(css = ".icons-benefit.icon-custom")
    private WebElement customIcon;
    @FindBy(css = ".icons-benefit.icon-multi")
    private WebElement multiIcon;
    @FindBy(css = ".icons-benefit.icon-base")
    private WebElement baseIcon;
    @FindBy(xpath = "//span"
            + "[@class='icons-benefit icon-practise']"
            + "/parent::div/following-sibling::span[@class = 'benefit-txt']")
    private WebElement practiseText;
    @FindBy(xpath = "//span"
            + "[@class='icons-benefit icon-custom']"
            + "/parent::div/following-sibling::span[@class = 'benefit-txt']")
    private WebElement customText;
    @FindBy(xpath = "//span"
            + "[@class='icons-benefit icon-multi']"
            + "/parent::div/following-sibling::span[@class = 'benefit-txt']")
    private WebElement multiText;
    @FindBy(xpath = "//span[@class='icons-benefit icon-base']"
            + "/parent::div/following-sibling::span[@class = 'benefit-txt']")
    private WebElement baseText;
    @FindBy(id = "frame")
    private WebElement frame;
    @FindBy(id = "frame-button")
    private WebElement frameButton;

    public MainPage() {
    }

    public void switchToFrame() {
        DriverManager.getDriver().switchTo().frame(frame);
    }

    public void switchToHomePage() {
        DriverManager.getDriver().switchTo().defaultContent();
    }

    public void openPage() {
        DriverManager.getDriver().get(HOMEPAGE_URL);
    }

    public String getBrowserTitle() {
        return DriverManager.getDriver().getTitle();
    }

    public List<WebElement> getIconsHomePage() {
        List<WebElement> iconsList = new ArrayList<>();
        iconsList.add(practiseIcon);
        iconsList.add(customIcon);
        iconsList.add(multiIcon);
        iconsList.add(baseIcon);
        return iconsList;
    }

    public List<String> getTextsIconsHomePage() {
        List<String> textsList = new ArrayList<>();
        textsList.add(practiseText.getText());
        textsList.add(customText.getText());
        textsList.add(multiText.getText());
        textsList.add(baseText.getText());
        return textsList;
    }

}