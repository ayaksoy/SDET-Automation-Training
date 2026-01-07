package com.neotech.lesson11;

import com.neotech.utils.CommonMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ExplicitWaitTest extends CommonMethods {
    // https://neotech.vercel.app/waits
    public static void main(String[] args) {

        setUp("https://neotech.vercel.app/waits");

        waitForVisibility(By.id("button1"));

        // here we are sure that the element is visible in page
        WebElement button1 = driver.findElement(By.id("button1"));

        System.out.println("Button1 is displayed: " + button1.isDisplayed());

        // button1.click();
        click(button1);

        wait(3);

        tearDown();

    }

}
