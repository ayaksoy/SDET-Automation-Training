package com.neotech.lesson12;

import com.neotech.utils.CommonMethods;
import com.neotech.utils.ConfigsReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class HW3 extends CommonMethods {
    public static void main(String[] args) {
        setUp();
        sendText(driver.findElement(By.id("txtUsername")), ConfigsReader.getProperty("username"));
        sendText(driver.findElement(By.id("txtPassword")), ConfigsReader.getProperty("password"));
        wait(2);
        click(driver.findElement(By.cssSelector("button[type='submit']")));
        wait(2);
        WebElement pim = driver.findElement(By.xpath("//span[normalize-space()='PIM']"));
        click(pim);
        wait(3);

        WebElement emp = driver.findElement(By.xpath("//span[normalize-space()='Employee List']"));
        click(emp);
        wait(3);
        click(driver.findElement(By.id("addEmployeeButton")));
        wait(3);
        WebElement name = driver.findElement(By.id("first-name-box"));
        sendText(name, "Mercedes");
        WebElement lastName = driver.findElement(By.id("last-name-box"));
        sendText(lastName, "Villavicencio");
//        sendText(driver.findElement(By.id("employeeId")), ("1234"));
        wait(2);
        click(driver.findElement(By.xpath("//button[i[text() = 'arrow_drop_down']]")));
        waitForClickability(driver.findElement(By.xpath("//span[text()='Sample Location']"))).click();
        wait(2);
        click(driver.findElement(By.xpath("//input[@id='employeePicture']")));
        wait(13);
        String filePath = "/Users/ahmet/Desktop/a.png";
        click(driver.findElement(By.cssSelector("img[data-tooltip='Change Profile Picture']")));


        sendText(driver.findElement(By.xpath("//input[@id='employeePicture']")), filePath);
        wait(10);

        click(driver.findElement(By.cssSelector("a[form-name='photoForm']")));
        wait(10);
        wait(10);

        tearDown();

    }
}
