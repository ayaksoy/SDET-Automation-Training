package com.neotech.lesson12;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import java.util.List;

public class Homework2 extends CommonMethods {
    public static void main(String[] args) {
        /*
        Homework 2:
Go to https://hrm.neotechacademy.com/
Log in using our custom methods
Go to PIM menu
Add an employee
Go to Employee List
Get the list of the employees (Using tables - tr and td)
Loop to search for the employee you added
When you find the employee - click on it.
Take a screenshot
         */
        setUp("https://hrm.neotechacademy.com/");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        sendText(driver.findElement(By.cssSelector("#txtUsername")), "admin");
        sendText(driver.findElement(By.cssSelector("#txtPassword")), "Neotech@123");
        click(driver.findElement(By.cssSelector("button[type='submit']")));

        click(driver.findElement(By.cssSelector("#menu_pim_viewPimModule")));
        waitForClickability(driver.findElement(By.cssSelector("#menu_pim_addEmployee"))).click();
        WebElement name = waitForVisibility(driver.findElement(By.cssSelector("#first-name-box")));
        wait(2);
        name.sendKeys("John");
        sendText(driver.findElement(By.cssSelector("#middle-name-box")), "Doe");
        sendText(driver.findElement(By.cssSelector("#last-name-box")), "aaa");
        click(driver.findElement(By.xpath("//button[i[text() = 'arrow_drop_down']]")));
        waitForClickability(driver.findElement(By.xpath("//span[text()='Sample Location']"))).click();
        click(driver.findElement(By.cssSelector("#modal-save-button")));

        wait(10);
        waitForClickability(driver.findElement(By.cssSelector("#menu_pim_viewEmployeeList"))).click();
        waitForVisibility(driver.findElement(By.cssSelector("#employeeListTable")));

        List<WebElement> customers = driver.findElements(By.cssSelector("#employeeListTable tbody > tr"));
        for (WebElement customer : customers) {
            if (customer.findElement(By.cssSelector("td:nth-child(3)")).getText().equalsIgnoreCase("John Doe aaa")) {
                WebElement element = customer.findElement(By.cssSelector("td:nth-child(1)"));
                js.executeScript("arguments[0].click();", element);
            }
        }
        waitForVisibility(driver.findElement(By.id("pimPersonalDetailsForm")));
        takeScreenshot("JohnDoeDoeDetails.png");
        wait(14);

        tearDown();
    }
}
