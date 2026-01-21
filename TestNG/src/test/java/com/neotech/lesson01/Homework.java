package com.neotech.lesson01;

import com.neotech.utils.CommonMethods;
import org.openqa.selenium.By;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Homework extends CommonMethods {
    /*Homework 1: HRMS Application Negative Login:

    1. Open chrome browser
    2. Go to "https://hrm.neotechacademy.com/"
    3. Enter valid username
    4. Leave password field empty
    5. Verify error message with text "Password cannot be empty" is displayed.
     */
    @BeforeMethod
    public void openBrowser() {
        setUp("https://hrm.neotechacademy.com/");
    }

    @AfterMethod
    public void closeBrowser() {
        tearDown();
    }

    @Test
    public void emptyPassword() {
        driver.findElement(By.cssSelector("#txtUsername")).sendKeys("admin");
        driver.findElement(By.cssSelector("button[type='submit']")).click();

        String passError = driver.findElement(By.cssSelector("#txtPassword-error")).getText();
        if (passError.equalsIgnoreCase("Password cannot be empty"))
            System.out.println("Error massage displayed");
        else System.out.println("Error message didnt display");
    }

}
