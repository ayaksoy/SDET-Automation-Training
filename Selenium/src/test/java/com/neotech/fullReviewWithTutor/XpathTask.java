package com.neotech.fullReviewWithTutor;

import com.neotech.utils.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class XpathTask extends BaseClass {
    public static void main(String[] args) {
        setUp();

        WebElement button = driver.findElement(By.xpath("//button[@type='submit']"));

        WebElement button2 = driver.findElement(By.xpath("//button[text()='Giriş Yap']"));

        WebElement button3 = driver.findElement(By.xpath("//button[contains(text(),'Giriş')]"));

        // task3

        WebElement button4 = driver.findElement(By.xpath("//button[contains() = 'Giriş']"));

        WebElement button5 = driver.findElement(By.xpath("//div[@class='login-form']//input"));

        WebElement button6 = driver.findElement(By.cssSelector("#u_0_5_login"));

        tearDown();
    }
}
