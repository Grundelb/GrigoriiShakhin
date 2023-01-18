package com.epam.tc.hw5.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UserTablePage extends AbstractPage {

    @FindBy(xpath = "//input[@id='ivan']")
    private WebElement sergeiIvanUserTableCheckbox;
    @FindBy(xpath = "//li[contains(.,'Vip: condition changed to true')]")
    private WebElement vipUserTableLogRow;

    public WebElement getVipUserTableLogRow() {
        return vipUserTableLogRow;
    }

    public UserTablePage(WebDriver driver) {
        super(driver);
    }

    public void clickOnSergeiIvanUserTableCheckbox() {sergeiIvanUserTableCheckbox.click();}

}
