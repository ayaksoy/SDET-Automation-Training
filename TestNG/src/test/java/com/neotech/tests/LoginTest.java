package com.neotech.tests;

import com.neotech.pages.DashboardPageElements;
import com.neotech.pages.LoginPageElements;
import com.neotech.utils.CommonMethods;
import com.neotech.utils.ConfigsReader;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends CommonMethods {

    @Test
    public void validLogin() {

        LoginPageElements loginPage = new LoginPageElements();
        DashboardPageElements dashboard = new DashboardPageElements();

        // send username
        sendText(loginPage.username, ConfigsReader.getProperty("username"));

        // send password
        sendText(loginPage.password, ConfigsReader.getProperty("password"));

        // click on login button
        click(loginPage.loginButton);
        // Or use jsClick() or Actions.click()

        wait(5);

        // Verify the account name
        String expected = "Jacqueline White";
        String actual = dashboard.accountName.getText();

        // Assertion
        Assert.assertEquals(actual, expected, "The account does NOT match!!!");
    }

}
