package com.epam.tc.hw5.pages;

import java.util.ArrayList;
import java.util.List;
import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Getter
public class HeaderMenuPage extends AbstractPage {
    private final String credentionalsUserName = "Roman";
    private final String credentionalsUserPassword = "Jdi1234";

    @FindBy(xpath = "//a[text()='Different elements']")
    private WebElement differentElementsServiceElement;
    @FindBy(id = "user-icon")
    private WebElement dropdownUserIcon;
    @FindBy(id = "name")
    private WebElement fieldUserName;
    @FindBy(id = "password")
    private WebElement fieldUserPassword;
    @FindBy(id = "login-button")
    private WebElement loginButton;
    @FindBy(css = "#user-name")
    private WebElement userNameHeaderView;
    @FindBy(partialLinkText = "HOME")
    private WebElement homeHeaderMenu;
    @FindBy(partialLinkText = "CONTACT FORM")
    private WebElement contactFormHeaderMenu;
    @FindBy(partialLinkText = "SERVICE")
    private WebElement serviceHeaderMenu;
    @FindBy(partialLinkText = "METALS & COLORS")
    private WebElement metalsAndColorsHeaderMenu;

    public HeaderMenuPage(WebDriver driver) {
        super(driver);
    }

    public String getUserNameHeaderText() {
        return userNameHeaderView.getText();
    }

    public void clickOnDropdownUserIcon() {
        dropdownUserIcon.click();
    }

    public void clickOnFieldUserName() {
        fieldUserName.click();
    }

    public void clickOnFieldUserPassword() {
        fieldUserPassword.click();
    }

    public void clickOnloginButton() {
        loginButton.click();
    }

    public void enterUserName() {
        fieldUserName.sendKeys(credentionalsUserName);
    }

    public void enterUserPassword() {
        fieldUserPassword.sendKeys(credentionalsUserPassword);
    }

    public void clickOnServiceHeaderMenu() {
        serviceHeaderMenu.click();
    }

    public void clickOnDifferentElementsServiceElement() {
        differentElementsServiceElement.click();
    }

    public List<WebElement> verifyHeaderMenuElements() {
        List<WebElement> webElementList = new ArrayList<>();
        webElementList.add(homeHeaderMenu);
        webElementList.add(contactFormHeaderMenu);
        webElementList.add(serviceHeaderMenu);
        webElementList.add(metalsAndColorsHeaderMenu);
        return webElementList;
    }
}
