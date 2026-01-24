package com.neotech.lesson03;

import com.neotech.utils.CommonMethods;
import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderDemo extends CommonMethods {

    @Test(dataProvider = "userData")
    public void loginFunctionality(String userName, String password) {
        sendText(driver.findElement(By.id("txtUsername")), userName);
        sendText(driver.findElement(By.id("txtPassword")), password);
        click(driver.findElement(By.cssSelector("button")));
    }


    @DataProvider(name = "userData")
    public Object[][] getData() {
        return new Object[][]{
                {"Admin", "Neotech@123"},
                {"asd123", "asd112"},
                {"112356", "follow"}
        };
    }
}
