package com.neotech;

import com.neotech.utils.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class Mecy extends BaseClass {
    public static void main(String[] args) throws InterruptedException {

        setUp("https://www.aa.com/homePage.do");

        WebElement from = driver.findElement(By.id("reservationFlightSearchForm.originAirport"));
        from.clear();
        from.sendKeys("PAR");
        from.click();

        WebElement to = driver.findElement(By.id("reservationFlightSearchForm.destinationAirport"));
        to.sendKeys("DXB");
        to.click();

        driver.findElement(By.cssSelector("button.ui-datepicker-trigger")).click();

        //WebELement to =driver,
        //table[@class='ui-datepicker-calendar']/tbody/tr[3]/td[4]
        List<WebElement> leftCalendar = driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']/tbody/tr/td"));

        //January 14 2026
        for (WebElement el : leftCalendar) {
            if (el.getText().equals("14")) {
                el.click();
                break;

            }

        }
        //table[@class='ui-datepicker-calendar']/tbody/tr[4]/td[5]
        driver.findElement(By.xpath("//div[label[@for='aa-returningFrom']]/button")).click();
        List<WebElement> rightCalendar = driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']/tbody/tr/td"));

        for (WebElement el : rightCalendar) {
            if (el.getText().equals("22")) {
                el.click();
                break;
            }
        }
        driver.findElement(By.id("flightSearchForm.button.reSubmit")).click();
        Thread.sleep(30000);


        tearDown();


    }
}
