package com.neotech.lesson11;

import com.neotech.utils.CommonMethods;
import com.neotech.utils.ConfigsReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginTest extends CommonMethods {
    // https://hrm.neotechacademy.com
    public static void main(String[] args) {

        setUp("https://hrm.neotechacademy.com");

        // send user name
        WebElement username = driver.findElement(By.id("txtUsername"));
        // username.clear();
        // username.sendKeys(ConfigsReader.getProperty("username"));
        sendText(username, ConfigsReader.getProperty("username"));

        // send password
        WebElement password = driver.findElement(By.id("txtPassword"));
        sendText(password, ConfigsReader.getProperty("password"));

        wait(3);

        // click on the login button
        WebElement loginButton = driver.findElement(By.xpath("//button"));
        loginButton.click();

        wait(3);

        // lets verify that we are able to login successfully
        WebElement smallLogo = driver.findElement(By.id("ohrm-small-logo"));

        if (smallLogo.isDisplayed()) {
            System.out.println("Test passed!");
        } else {
            System.out.println("Test failed!!!");
        }

        wait(3);

        tearDown();

    }

}
