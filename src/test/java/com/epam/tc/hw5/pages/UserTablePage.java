package com.epam.tc.hw5.pages;

import java.util.ArrayList;
import java.util.List;

import com.epam.tc.hw5.driver.DriverManager;
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
    @FindBy(xpath = "//option[contains(., 'Admin')]")
    private List<WebElement> dropDownList;
    @FindBy(xpath = "//tbody//a")
    private List<WebElement> usersList;
    @FindBy(xpath = "//tbody//span")
    private List<WebElement> descriptionTestsList;
    @FindBy(xpath = "//tbody//input")
    private List<WebElement> checkboxesList;
    @FindBy(xpath = "//td[contains(text(),'1' )]/following-sibling::td/select/option")
    private List<WebElement> optionsDropDown;

    public UserTablePage() {

    }

    public List<WebElement> getDropDownList() {
        return dropDownList;
    }

    public List<WebElement> getUsersList() {
        return usersList;
    }

    public List<WebElement> getDescriptionTestsList() {
        return descriptionTestsList;
    }

    public List<WebElement> getCheckboxesList() {
        return checkboxesList;
    }

    public List<WebElement> getOptionsDropDown() {
        return optionsDropDown;
    }

    public WebElement getVipUserTableLogRow() {
        return vipUserTableLogRow;
    }

    public void clickOnSergeiIvanUserTableCheckbox() {
        sergeiIvanUserTableCheckbox.click();
    }

    public String getBrowserTitle() {
        return DriverManager.getDriver().getTitle();
    }

    public List<WebElement> getDropDownValues() {
        List<WebElement> list = new ArrayList<>();
        list.add(adminCheckbox);
        list.add(userCheckbox);
        list.add(managerCheckbox);
        return list;
    }
}
