package com.automation.orangehrm.tests;

import com.automation.orangehrm.base.BaseTest;
import com.automation.orangehrm.pages.DashboardPage;
import com.automation.orangehrm.pages.LoginPage;
import com.automation.orangehrm.utils.ConfigReader;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @Test(description = "Verify successful login with valid credentials")
    public void testSuccessfulLogin() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(ConfigReader.getProperty("username"), ConfigReader.getProperty("password"));

        DashboardPage dashboardPage = new DashboardPage(driver);
        Assert.assertTrue(dashboardPage.isDashboardDisplayed(), "Dashboard should be displayed after login");
        Assert.assertEquals(dashboardPage.getHeaderText(), "Dashboard", "Header text should be 'Dashboard'");
    }
}
