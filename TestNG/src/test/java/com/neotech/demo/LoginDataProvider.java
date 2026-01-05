package com.neotech.demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoginDataProvider{
    @DataProvider(name = "invalidLoginData")
    public static Object[][] getData(){
        return new Object[][] {
                {"Admin", "wrong123", "Invalid Credentials"},
                {"", "password", "Username cannot be empty"},
                {"Admin", "", "Password cannot be empty"}
        };
    }

}
