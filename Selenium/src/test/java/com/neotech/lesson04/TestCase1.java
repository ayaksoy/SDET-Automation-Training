package com.neotech.lesson04;

import com.neotech.utils.BaseClass;
import org.openqa.selenium.By;

public class TestCase1 extends BaseClass {
    public static void main(String[] args) throws InterruptedException {
        setUp("http://secure.smartbearsoftware.com/samples/testcomplete11/WebOrders/login.aspx");

        driver.findElement(By.cssSelector("input#ctl00_MainContent_username")).sendKeys("Tester");
        driver.findElement(By.cssSelector("#ctl00_MainContent_password")).sendKeys("test");
        driver.findElement(By.xpath("//input[@id='ctl00_MainContent_login_button']")).click();
        boolean webOrdersIsDisplayed =  driver.findElement(By.xpath("//h1[text()='Web Orders']")).isDisplayed();
        boolean userNameIsDisplayed =  driver.findElement(By.xpath("//div[@class='login_info']")).isDisplayed();

        if(webOrdersIsDisplayed)
            System.out.println("Test passes, Web order is displayed");
        else
            System.out.println("Test failed, Web order is not displayed");

        if(userNameIsDisplayed)
            System.out.println("Test passes, UserName is displayed");
        else
            System.out.println("Test failed, UserName is not displayed");


        Thread.sleep(2000);


        tearDown();
    }
}
