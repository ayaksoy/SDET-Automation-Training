package com.neotech.lesson11;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Homework1 extends CommonMethods {
    public static void main(String[] args) {
        setUp("https://neotech.vercel.app/iframe");
        // if we try to send text to age box directly, it will throw
        // NoSuchElementException
        // Why?
        // Because the focus is in main page but the age box is in an iframe(another
        // page).

        // How do we deal with this?
        // We need to switch into the frame:
        // 1. using index number


//        driver.switchTo().frame(0);
        switchToFrame(0);

        // locate age box
        WebElement ageBox = driver.findElement(By.id("age"));

//        ageBox.sendKeys("30");
        sendText(ageBox, "30");

//        Thread.sleep(3000);
        wait(3);
        // Can i click any button or link outside the frame? NO
        // We have to move focus back to the main content

        driver.switchTo().defaultContent();

        // 2. Switch into the frame using WebElement
        WebElement frame1 = driver.findElement(By.id("age-frame"));

//        driver.switchTo().frame(frame1);
        switchToFrame(frame1);

//        ageBox.clear();
//        ageBox.sendKeys("40");
        sendText(ageBox, "40");
        wait(3);

        tearDown();
    }
}
