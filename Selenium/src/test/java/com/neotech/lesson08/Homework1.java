package com.neotech.lesson08;

import com.neotech.utils.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Homework1 extends BaseClass {
    public static void main(String[] args) throws InterruptedException {
    /*
Homework 1: Use WebDriverWait
        Verify element is enabled
        Open chrome browser
        Go to "https://the-internet.herokuapp.com/"
        Click on the "Dynamic Controls" link
        Click on enable button
        Enter "Hello" and verify text is entered successfully
        Close the browser
     */

        setUp("https://the-internet.herokuapp.com/");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.findElement(By.linkText("Dynamic Controls")).click();
        driver.findElement(By.xpath("//form[@id = 'input-example']//button[text() = 'Enable']")).click();
        WebElement inputField = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//form[@id='input-example']//input")));

        inputField.sendKeys("Hello");

        if (inputField.getAttribute("value").equals("Hello"))
            System.out.println("Test passed");
        else
            System.out.println("Test failed");


        tearDown();


    }

}
