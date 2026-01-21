package com.neotech.lesson13;

import com.neotech.utils.ConfigsReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Homework2 extends CommonMethods {
    public static void main(String[] args) {
        setUp("https://hrm.neotechacademy.com/");
        sendText(driver.findElement(By.id("txtUsername")), ConfigsReader.getProperty("username"));
        sendText(driver.findElement(By.id("txtPassword")), ConfigsReader.getProperty("password"));
        click(driver.findElement(By.cssSelector("button[type='submit']")));
        click(driver.findElement(By.xpath("//span[normalize-space()='PIM']")));
        click(driver.findElement(By.xpath("//span[normalize-space()='Add Employee']")));
        WebElement name = driver.findElement(By.id("first-name-box"));
        sendText(name, "Lorem");
        WebElement lastName = driver.findElement(By.id("last-name-box"));
        sendText(lastName, "Ipsum");
        click(driver.findElement(By.xpath("//button[i[text() = 'arrow_drop_down']]")));
        waitForClickability(driver.findElement(By.xpath("//span[text()='Sample Location']"))).click();
        wait(2);
        click(driver.findElement(By.id("modal-save-button")));
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        waitForVisibility(driver.findElement(By.cssSelector("img.circle.profile-photo"))).click();
        String filePath = System.getProperty("user.dir") + "/screenshots/JohnDoeDoeDetails.png";
        driver.findElement(By.xpath("//input[@id='employeePicture']")).sendKeys(filePath);
        click(driver.findElement(By.xpath("//a[text()='Save']")));

        tearDown();

    }
}
