package com.neotech.demo2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class LoginTest {
    WebDriver driver;
    @BeforeMethod()
    public void setUp(){
        driver = new FirefoxDriver();
        driver.get("https://hrm.neotechacademy.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }
    @AfterMethod
    public void tearDown(){
        if(driver!=null)
            driver.quit();
    }


    @Test(priority = 2)
    public void  isUsernameDisplayed(){
        WebElement userName = driver.findElement(By.id("txtUsername"));

        if(userName.isDisplayed())
            System.out.println("username field is displayed");
    }

    @Test(priority = 1)
    public void wrongLogin(){
        driver.findElement(By.id("txtUsername")).sendKeys("asd123");
        driver.findElement(By.id("txtPassword")).sendKeys("asd123");
        driver.findElement(By.cssSelector("button[type='submit']")).click();
        System.out.println("submitted");
        WebElement error = driver.findElement(By.xpath("//div[@class = 'toast-message' and normalize-space() = 'Please solve the problem to proceed.']"));

        if(error.isDisplayed())
            System.out.println("error is displayed");

    }

}
