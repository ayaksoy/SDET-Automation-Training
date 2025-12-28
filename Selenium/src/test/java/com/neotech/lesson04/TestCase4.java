package com.neotech.lesson04;

import com.neotech.utils.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class TestCase4 extends BaseClass {
    public static void main(String[] args) {
        setUp("https://demoqa.com/radio-button");
        List<WebElement> radioBtns = driver.findElements(By.cssSelector("label[class = 'custom-control-label']"));
        System.out.println(radioBtns.size());






        tearDown();
    }
}
