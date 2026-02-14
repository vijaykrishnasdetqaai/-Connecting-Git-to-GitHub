package com.automation.orangehrm.tests;

import com.automation.orangehrm.base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PageTitleTest extends BaseTest {

    @Test(description = "Verify the login page title")
    public void testLoginPageTitle() {
        String expectedTitle = "OrangeHRM";
        String actualTitle = getDriver().getTitle();
        Assert.assertEquals(actualTitle, expectedTitle, "Login page title should match");
    }
}
