package com.neotech.lesson08;

import com.neotech.utils.BaseClass;
import com.neotech.utils.ConfigsReader;
import org.openqa.selenium.By;

public class Homework3 extends BaseClass {
    public static void main(String[] args) throws InterruptedException {

        setUp("https://hrm.neotechacademy.com/");

        driver.findElement(By.cssSelector("#txtUsername")).sendKeys(ConfigsReader.getProperty("username"));
        driver.findElement(By.cssSelector("#txtPassword")).sendKeys(ConfigsReader.getProperty("password"));
        driver.findElement(By.cssSelector("button[type='submit']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//span[normalize-space()='PIM']")).click();
        Thread.sleep(2000);
        driver.findElement(By.cssSelector("span[combinedmenutitle='PIM > Employee List']")).click();
        Thread.sleep(6000);
        driver.findElements(By.xpath("//table[@id='employeeListTable']/tbody/tr/td[3]"));
        Thread.sleep(15000);

        tearDown();

    }
}
