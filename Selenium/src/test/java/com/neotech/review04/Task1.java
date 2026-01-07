package com.neotech.review04;

import com.neotech.utils.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class Task1 extends BaseClass {
    public static void main(String[] args) {
        setUp("https://the-internet.herokuapp.com/tables");
// Go to https://the-internet.herokuapp.com/tables
// I want you to print all the data from the tbody of the second table
// Create the path dynamically
// Don't print the last colum

        List<WebElement> rows = driver.findElements(By.cssSelector("#table2 tbody tr"));
        List<WebElement> cols = driver.findElements(By.cssSelector("#table2 tbody tr:nth-child(1) td"));


        for (int i = 1; i <= rows.size(); i++) {
            for (int j = 1; j < cols.size(); j++) {
                String path = "#table2 tbody tr:nth-child(" + i + ") td:nth-child(" + j + ")";
                WebElement data = driver.findElement(By.cssSelector(path));
                System.out.print(data.getText() + "    |    ");
            }
            System.out.println();
        }


        tearDown();
    }
}
