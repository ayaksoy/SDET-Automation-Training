package com.neotech.lesson09;

import com.neotech.utils.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

public class Homework1 extends BaseClass {
    public static void main(String[] args) throws InterruptedException {
        /*
        ==================  Lesson 09 HW 1 =======================
TC: Update Customer Information

1) Open chrome browser
2) Go to "http://secure.smartbearsoftware.com/samples/testcomplete11/WebOrders/login.aspx"
3) Login to the application
4) Verify customer "Susan McLaren" is present in the table
5) Click on customer details
6) Update customers last name and credit card info
7) Verify updated customers name and credit card number is displayed in table
8) Close browser
         */

        //login
        setUp("http://secure.smartbearsoftware.com/samples/testcomplete11/WebOrders/login.aspx");
        driver.findElement(By.cssSelector("#ctl00_MainContent_username")).sendKeys("Tester");
        Thread.sleep(2000);
        driver.findElement(By.cssSelector("#ctl00_MainContent_password")).sendKeys("test");
        Thread.sleep(2000);
        driver.findElement(By.cssSelector("#ctl00_MainContent_login_button")).click();
        WebElement mercyTd = driver.findElement(By.xpath("//tr/td[2][contains(text(), 'Susan McLaren')]"));

        System.out.println(mercyTd.getText());
        Thread.sleep(2000);
        WebElement row;
        try {
            row = driver.findElement(By.xpath("//table[@id='ctl00_MainContent_orderGrid']/tbody/tr[td[2][contains(text(), 'Susan McLaren')]]"));
            System.out.println("Susan McLaren is present");
        } catch (NoSuchElementException e) {
            System.out.println("Susan McLaren isnt present test ended");
            throw e;
        }

        row.findElement(By.cssSelector("input[alt = 'Edit']")).click();
        Thread.sleep(2000);
        driver.findElement(By.cssSelector("#ctl00_MainContent_fmwOrder_txtName")).clear();
        Thread.sleep(2000);
        driver.findElement(By.cssSelector("#ctl00_MainContent_fmwOrder_txtName")).sendKeys("Susan Ferrari");
        driver.findElement(By.cssSelector("#ctl00_MainContent_fmwOrder_TextBox6")).clear();
        Thread.sleep(2000);
        driver.findElement(By.cssSelector("#ctl00_MainContent_fmwOrder_TextBox6")).sendKeys("111111111111");
        driver.findElement(By.cssSelector("#ctl00_MainContent_fmwOrder_UpdateButton")).click();
//        {
//            try {
//                row = driver.findElement(By.xpath("//table[@id='ctl00_MainContent_orderGrid']/tbody/tr[td[2][contains(text(), 'Susan Ferrari')]]"));
//                System.out.println("Susan Ferrari is pr123123123esent");
//            } catch (NoSuchElementException e) {
//                System.out.println("Susan Ferrari isnt present test ended");
//                throw e;
//            }
//        }
        row = driver.findElement(By.xpath("//table[@id='ctl00_MainContent_orderGrid']/tbody/tr[td[2][contains(text(), 'Susan Ferrari')]]"));

        String cardNumber = row.findElement(By.xpath("td[11]")).getText();
        String name = row.findElement(By.xpath("td[2]")).getText();
        Thread.sleep(2000);


        if (cardNumber.equals("111111111111") && name.equals("Susan Ferrari")) {
            System.out.println("card number and name changed test passed");
        } else {
            System.out.println("card number or name didnt changed test failed");
        }


        Thread.sleep(15000);


        tearDown();
    }
}
