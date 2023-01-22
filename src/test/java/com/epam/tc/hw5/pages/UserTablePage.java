package com.epam.tc.hw5.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UserTablePage extends AbstractPage {

    @FindBy(xpath = "//input[@id='ivan']")
    private WebElement sergeiIvanUserTableCheckbox;
    @FindBy(xpath = "//li[contains(.,'Vip: condition changed to true')]")
    private WebElement vipUserTableLogRow;
    @FindBy(xpath = "(//option[contains(text(),'Admin')])[1]")
    private WebElement adminCheckbox;
    @FindBy(xpath = "(//option[contains(text(),'User')])[1]")
    private WebElement userCheckbox;
    @FindBy(xpath = "(//option[contains(text(),'Manager')])[1]")
    private WebElement managerCheckbox;
    private final String DROPDOWN_LIST = "//option[contains(., 'Admin')]";
    private final String USERS_LIST = "//tbody//a";
    private final String DESCRIPTION_TEXT_LIST = "//tbody//span";
    private final String CHECKBOXES_LIST = "//tbody//input";
    private final String TABLE_ELEMENTS = "//table[@id='user-table']";

    private List<WebElement> userTable;

    public WebElement getVipUserTableLogRow() {
        return vipUserTableLogRow;
    }

    public UserTablePage(WebDriver driver) {
        super(driver);
    }

    public void clickOnSergeiIvanUserTableCheckbox() {
        sergeiIvanUserTableCheckbox.click();
    }

    public String getBrowserTitle() {
        return driver.getTitle();
    }

    public List<WebElement> getDropDowns() {
        userTable = driver.findElements(By.xpath(DROPDOWN_LIST));
        return userTable;
    }

    public List<WebElement> getUserNames() {
        userTable = driver.findElements(By.xpath(USERS_LIST));
        return userTable;
    }

    public List<WebElement> getDescriptionTexts() {
        userTable = driver.findElements(By.xpath(DESCRIPTION_TEXT_LIST));
        return userTable;
    }

    public List<WebElement> getCheckboxes() {
        userTable = driver.findElements(By.xpath(CHECKBOXES_LIST));
        return userTable;
    }

    public List<WebElement> getTableElements() {
        userTable = driver.findElements(By.xpath(TABLE_ELEMENTS));
        return userTable;
    }

    public List<WebElement> getDropDownValues() {
        List<WebElement> list = new ArrayList<>();
        list.add(adminCheckbox);
        list.add(userCheckbox);
        list.add(managerCheckbox);
        return null;
    }
}
