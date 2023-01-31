package com.epam.tc.hw5.steps.bdd;

import com.epam.tc.hw5.driver.DriverManager;
import com.epam.tc.hw5.pages.DifferentElementsPage;
import com.epam.tc.hw5.pages.HeaderMenuPage;
import com.epam.tc.hw5.pages.MainPage;
import com.epam.tc.hw5.pages.UserTablePage;
import org.openqa.selenium.WebDriver;

public abstract class AbstractStep {
    protected HeaderMenuPage headerMenuPage;
    protected MainPage mainPage;
    protected DifferentElementsPage differentElementsPage;
    protected UserTablePage userTablePage;


    public AbstractStep() {
        headerMenuPage = new HeaderMenuPage();
        mainPage = new MainPage();
        differentElementsPage = new DifferentElementsPage();
        userTablePage = new UserTablePage();
    }
}
