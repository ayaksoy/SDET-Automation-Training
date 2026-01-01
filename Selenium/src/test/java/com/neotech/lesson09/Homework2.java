package com.neotech.lesson09;

import com.neotech.utils.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class Homework2 extends BaseClass {
    public static void main(String[] args) throws InterruptedException {
        /*TC: Delete Orders

1) Open chrome browser
2) Go to "http://secure.smartbearsoftware.com/samples/testcomplete11/WebOrders/login.aspx"
3) Login to the application
4) Click on the checkbox of all orders with product FamilyAlbum
5) Delete Selected orders
6) Verify the orders have been deleted
7) Quit the browser
         */

        //login
        setUp("http://secure.smartbearsoftware.com/samples/testcomplete11/WebOrders/login.aspx");
        driver.findElement(By.cssSelector("#ctl00_MainContent_username")).sendKeys("Tester");
        driver.findElement(By.cssSelector("#ctl00_MainContent_password")).sendKeys("test");
        driver.findElement(By.cssSelector("#ctl00_MainContent_login_button")).click();

        List<WebElement> familyAlbums = driver.findElements(By.xpath(
                "//table[@id = 'ctl00_MainContent_orderGrid']/tbody/tr[td[3][text() = 'FamilyAlbum']]"));
        for (WebElement i : familyAlbums)
            i.findElement(By.xpath("td[1]")).click();
        driver.findElement(By.id("ctl00_MainContent_btnDelete")).click();
        familyAlbums = driver.findElements(By.xpath(
                "//table[@id = 'ctl00_MainContent_orderGrid']/tbody/tr[td[3][text() = 'FamilyAlbum']]"));
        if (familyAlbums.isEmpty())
            System.out.println("there is no familyAlbum product test passes");

        tearDown();
    }
}
