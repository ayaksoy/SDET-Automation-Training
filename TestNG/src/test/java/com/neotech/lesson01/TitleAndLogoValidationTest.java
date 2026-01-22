package com.neotech.lesson01;

import com.neotech.utils.CommonMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TitleAndLogoValidationTest extends CommonMethods {

    @BeforeMethod
    public void openAndNavigate() {
        setUp();
    }

    @AfterMethod
    public void quitBrowser() {
        tearDown();
    }


    @Test
    public void titleValidation() {
        String expectedTitle = "OrangeHRM";
        String actualTitle = driver.getTitle();

        if (expectedTitle.equalsIgnoreCase(actualTitle))
            System.out.println("Test Passed");
        else throw new RuntimeException("Test Failed");
    }

    @Test
    public void logoValidation() {
        WebElement logo = driver.findElement(By.cssSelector("div.orangehrm-logo > img"));
        if (logo.isDisplayed())
            System.out.println("logo displayed");
        else System.out.println("logo isnt displayed");
    }

    @Test
    public void loginValidation() {
        driver.findElement(By.cssSelector("#txtUsername")).sendKeys("admin");
        driver.findElement(By.cssSelector("#txtPassword")).sendKeys("Neotech@123");
        driver.findElement(By.cssSelector("button[type='submit']")).click();
        WebElement userImg = driver.findElement(By.cssSelector("#menu-profile > img"));
        if (userImg.isDisplayed())
            System.out.println("img displayed");
        else System.out.println("img isnt displayed");
    }
}
