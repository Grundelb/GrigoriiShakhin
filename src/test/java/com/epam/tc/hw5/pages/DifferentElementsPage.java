package com.epam.tc.hw5.pages;

import java.util.ArrayList;
import java.util.List;
import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Getter
public class DifferentElementsPage extends AbstractPage {

    @FindBy(xpath = "//*[contains(.,'Water')]/input")
    private WebElement waterCheckbox;
    @FindBy(xpath = "//*[contains(.,'Wind')]/input")
    private WebElement windCheckbox;
    @FindBy(xpath = "//*[contains(.,'Selen')]/input")
    private WebElement selenRadioButton;
    @FindBy(className = "colors")
    private WebElement colorsDropDownMenu;
    @FindBy(xpath = "//option[text()='Yellow']")
    private WebElement yellowOptionColors;
    @FindBy(xpath = "//li[contains(.,'Water: condition changed to true')]")
    private WebElement containWaterLog;
    @FindBy(xpath = "//li[contains(.,'Wind: condition changed to true')]")
    private WebElement containWindLog;
    @FindBy(xpath = "//li[contains(.,'metal: value changed to  Selen')]")
    private WebElement containSelenLog;
    @FindBy(xpath = "//li[contains(.,'Colors: value changed to Yellow')]")
    private WebElement containYellowLog;

    public DifferentElementsPage(WebDriver driver) {
        super(driver);
    }

    public void clickOnWaterCheckbox() {
        waterCheckbox.click();
    }

    public void clickOnWindCheckbox() {
        windCheckbox.click();
    }

    public void clickOnSelenRadioButton() {
        selenRadioButton.click();
    }

    public void clickOnColorsDropDownMenu() {
        colorsDropDownMenu.click();
    }

    public void clickOnYellowOptionColors() {
        yellowOptionColors.click();
    }

    public List<WebElement> verifyLogs() {
        List<WebElement> list = new ArrayList<>();
        list.add(containSelenLog);
        list.add(containWaterLog);
        list.add(containWindLog);
        list.add(containYellowLog);
        return list;
    }

}
