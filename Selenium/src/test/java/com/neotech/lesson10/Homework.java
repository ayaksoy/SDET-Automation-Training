package com.neotech.lesson10;

import com.neotech.utils.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Homework extends BaseClass {
    public static void main(String[] args) throws InterruptedException {
//        Homework: American Airlines Flight Search
//
//        Open chrome browser
//        Go to https://www.aa.com/homePage.do
//        Enter From and To
//        Select departure as November 14 of 2026
//        Select arrival as November 22 of 2026
//        Click on search
//        Close browser
        setUp("https://www.aa.com/homePage.do");
        driver.findElement(By.id("reservationFlightSearchForm.originAirport")).clear();
        driver.findElement(By.id("reservationFlightSearchForm.originAirport")).sendKeys("BHM");

        driver.findElement(By.id("reservationFlightSearchForm.destinationAirport")).clear();
        driver.findElement(By.id("reservationFlightSearchForm.destinationAirport")).sendKeys("ADK");
        driver.findElement(By.xpath(
                "//div[contains(@class, 'js-date-picker-wrapper')]/label[contains(text(), 'Depart')]/following-sibling::button"
        )).click();

        while (true) {
            WebElement title = driver.findElement(By.xpath("//div[contains(@class, 'ui-datepicker-group-first')]//div[@class='ui-datepicker-title']"));
            if (title.getText().contains("November 2026"))
                break;
            driver.findElement(By.xpath("//a[contains(@class, 'ui-datepicker-next')]")).click();
        }
        driver.findElement(By.xpath("//div[contains(@class, 'ui-datepicker-group-first')]//tbody/tr/td[normalize-space() = '14']")).click();
        driver.findElement(By.xpath(
                "//div[contains(@class, 'js-date-picker-wrapper')]/label[contains(text(), 'Return')]/following-sibling::button"
        )).click();

        while (true) {
            WebElement title = driver.findElement(By.xpath("//div[contains(@class, 'ui-datepicker-group-first')]//div[@class='ui-datepicker-title']"));
            if (title.getText().contains("November 2026"))
                break;
            driver.findElement(By.xpath("//a[contains(@class, 'ui-datepicker-next')]")).click();
        }
        driver.findElement(By.xpath("//div[contains(@class, 'ui-datepicker-group-first')]//tbody/tr/td[normalize-space() = '22']")).click();

        driver.findElement(By.id("flightSearchForm.button.reSubmit")).click();

        Thread.sleep(5000);


        tearDown();
    }
}
