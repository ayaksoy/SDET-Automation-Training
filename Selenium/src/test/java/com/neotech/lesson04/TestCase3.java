package com.neotech.lesson04;

import com.neotech.utils.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class TestCase3 extends BaseClass {
    public static void main(String[] args) throws InterruptedException {
        setUp("https://www.amazon.com/");
        Thread.sleep(4000);

        List<WebElement> list = driver.findElements(By.tagName("a"));
        int count = 0;
        for (WebElement i : list)
        {
            if(i!= null && !i.getText().trim().isEmpty())
                System.out.println(count++ +") "+ i.getText());
        }
        System.out.println("Number of the links that have some text in it = "+count);

        tearDown();
    }
}
