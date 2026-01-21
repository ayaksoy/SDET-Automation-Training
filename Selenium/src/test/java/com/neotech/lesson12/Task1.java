package com.neotech.lesson12;

import com.neotech.utils.ConfigsReader;
import org.openqa.selenium.By;

public class Task1 extends CommonMethods {

    // https://hrm.neotechacademy.com/
    public static void main(String[] args) {

        setUp();

        sendText(driver.findElement(By.id("txtUsername")), ConfigsReader.getProperty("username"));
        // sendText(driver.findElement(By.id("txtPassword")),
        // ConfigsReader.getProperty("password"));
        click(driver.findElement(By.xpath("//button[@type='submit']")));

        wait(2);

        takeScreenshot("HRM_blank-password-error.png");

        tearDown();

    }

}
