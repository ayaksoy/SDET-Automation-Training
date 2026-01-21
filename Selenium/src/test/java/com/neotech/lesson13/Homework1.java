package com.neotech.lesson13;

import org.openqa.selenium.By;
import org.testng.Assert;

public class Homework1 extends CommonMethods {
    public static void main(String[] args) {
        /*
        Homework 1: File Upload
Upload a file:
http://webdriveruniversity.com/File-Upload/index.html
         */

        setUp("http://webdriveruniversity.com/File-Upload/index.html");
        String filePath = System.getProperty("user.dir") + "/screenshots/JohnDoeDoeDetails.png";
        driver.findElement(By.id("myFile")).sendKeys(filePath);
        driver.findElement(By.id("submit-button")).click();
        String alertText = getAlertText();
        Assert.assertEquals(alertText, "Your file has now been uploaded!");
        acceptAlert();
        tearDown();
    }
}
