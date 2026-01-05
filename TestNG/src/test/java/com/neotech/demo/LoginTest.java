package com.neotech.demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class LoginTest extends BaseTest{

    @Test(priority = 1,groups = "smoke", dataProvider = "invalidLoginData", dataProviderClass = LoginDataProvider.class)
    public void login(String username, String password, String expectedError) {
        driver.findElement(By.cssSelector("#txtUsername")).sendKeys(username);
        driver.findElement(By.cssSelector("#txtPassword")).sendKeys(password);
        driver.findElement(By.cssSelector("button[type='submit']")).click();

        String actualError = "";

        if (expectedError.equals("Invalid Credentials")) {
            actualError = driver.findElement(By.cssSelector(".toast-message")).getText();
        } else {
            actualError = driver.findElement(By.xpath("//span[contains(text(),'empty')]")).getText();
        }

        Assert.assertEquals(actualError, expectedError, "Hata mesajı uyuşmadı!");
    }


    @Test(priority = 3,dependsOnMethods = {"login"},enabled = false)
    public void validateHomePage(){
        String accountName = driver.findElement(By.cssSelector("#account-name")).getText();
        Assert.assertEquals(accountName, "Jacqueline White", "account name isnt like expected");
    }


    @Test(priority = 4,groups = "regression")
    public void validateDashboardDetailsHardAssert(){
        Assert.assertEquals(driver.getTitle(), "OrangeHRM", "title is not OrangeHRM");
    }


    @Test(priority = 5,groups = {"smoke","regression"})
    public void validateDashboardDetailsSoftAssert(){
        driver.findElement(By.cssSelector("#txtUsername")).sendKeys("admin");
        driver.findElement(By.cssSelector("#txtPassword")).sendKeys("Neotech@123");
        driver.findElement(By.cssSelector("button[type='submit']")).click();
        WebElement pimButton =  driver.findElement(By.cssSelector("#menu_pim_viewPimModule"));
        String accountName = driver.findElement(By.cssSelector("#account-name")).getText();
        String currentURL = driver.getCurrentUrl();

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(accountName, "Jacqueline White");
        softAssert.assertTrue(pimButton.isDisplayed());
        softAssert.assertTrue(currentURL.contains("dashboard"));

        softAssert.assertAll();
    }


}

