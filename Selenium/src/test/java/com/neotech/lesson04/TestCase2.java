package com.neotech.lesson04;

import com.neotech.utils.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class TestCase2 extends BaseClass {
    public static void main(String[] args) throws InterruptedException {

        setUp("http://secure.smartbearsoftware.com/samples/testcomplete11/WebOrders/login.aspx");

        WebElement userName = driver.findElement(By.cssSelector("#ctl00_MainContent_username"));
        userName.sendKeys("Tester");
        userName.clear();
        userName.sendKeys("Tester");
        driver.findElement(By.xpath("//input[@id = 'ctl00_MainContent_login_button']")).click();
        Thread.sleep(4000);
        boolean isDisplayed = driver.findElement(By.cssSelector("span#ctl00_MainContent_status")).isDisplayed();
        if(isDisplayed)
            System.out.println("status is displayed");
        else
            System.out.println("status isnt displayed");
        Thread.sleep(4000);




        tearDown();



    }
}
