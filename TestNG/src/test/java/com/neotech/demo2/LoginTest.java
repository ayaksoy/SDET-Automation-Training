package com.neotech.demo2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class LoginTest {
    WebDriver driver;

    @BeforeClass
    public void start(){
        System.out.println("Test started");
    }

    @BeforeMethod()
    public void setUp(){
        driver = new FirefoxDriver();
        driver.get("https://hrm.neotechacademy.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.findElement(By.id("txtUsername")).sendKeys("admin");
        driver.findElement(By.id("txtPassword")).sendKeys("Neotech@123");
        WebElement loginBtn =  driver.findElement(By.cssSelector("button[type='submit']"));
        loginBtn.click();
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

    @Test(priority = 3)
    public void logOut(){
        driver.findElement(By.id("user-dropdown")).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Logout linki tıklanabilir olana kadar bekle ve sonra tıkla
        WebElement logoutBtn = wait.until(ExpectedConditions.elementToBeClickable(By.id("logoutLink")));
        logoutBtn.click();

        WebElement loginBtn =  driver.findElement(By.cssSelector("button[type='submit']"));

        if(loginBtn.isDisplayed())
            System.out.println("Test Passed");
    }

}
