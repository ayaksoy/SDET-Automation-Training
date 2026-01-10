package com.neotech.lesson12;

import com.neotech.utils.CommonMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class Homework1 extends CommonMethods {
    public static void main(String[] args) {
        /*
        Homework 1:
Open chrome browser
Go to https://demo.guru99.com/test/drag_drop.html
Drag the following blocks in different ways
Drag BANK to DEBIT SIDE
Drag SALES to CREDIT SIDE
Drag 5000 to DEBIT SIDE
Drag 5000 to CREDIT SIDE
Close the browser
         */
        setUp("https://demo.guru99.com/test/drag_drop.html");
        Actions actions = new Actions(driver);

        WebElement sales = driver.findElement(By.id("credit1"));
        WebElement bank = driver.findElement(By.id("credit2"));
        WebElement fiveThousand = driver.findElement(By.id("fourth"));
        WebElement debitAccount = driver.findElement(By.id("bank"));
        WebElement debitAmount = driver.findElement(By.id("amt7"));
        WebElement creditAccount = driver.findElement(By.id("loan"));
        WebElement creditAmount = driver.findElement(By.id("amt8"));

        actions.dragAndDrop(bank, debitAccount).perform();
        actions.dragAndDrop(sales, creditAccount).perform();
        actions.dragAndDrop(fiveThousand, debitAmount).perform();
        actions.dragAndDrop(fiveThousand, creditAmount).perform();
        wait(5);


        tearDown();
    }
}
