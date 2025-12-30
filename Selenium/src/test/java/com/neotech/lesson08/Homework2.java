package com.neotech.lesson08;

import com.neotech.utils.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;

public class Homework2 extends BaseClass {
    public static void main(String[] args) {
//        Same as Homework1 -> Use FluentWait

        setUp("https://the-internet.herokuapp.com/");

        Wait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofSeconds(1))
                .ignoring(NoSuchElementException.class);

        driver.findElement(By.linkText("Dynamic Controls")).click();
        driver.findElement(By.xpath("//form[@id = 'input-example']//button[text() = 'Enable']")).click();

        WebElement inputField = fluentWait.until(ExpectedConditions
                .elementToBeClickable(By.xpath("//form[@id='input-example']//input")));

        inputField.sendKeys("Hello");

        if (inputField.getAttribute("value").equals("Hello"))
            System.out.println("Test passed");
        else
            System.out.println("Test failed");


        tearDown();
    }
}
