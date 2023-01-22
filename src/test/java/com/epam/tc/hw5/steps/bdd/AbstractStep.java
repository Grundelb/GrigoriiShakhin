package com.epam.tc.hw5.steps.bdd;

import com.epam.tc.hw5.common.TestContext;
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
        WebDriver driver = TestContext.getInstance().get("driver", WebDriver.class);
        headerMenuPage = new HeaderMenuPage(driver);
        mainPage = new MainPage(driver);
        differentElementsPage = new DifferentElementsPage(driver);
        userTablePage = new UserTablePage(driver);
    }
}
