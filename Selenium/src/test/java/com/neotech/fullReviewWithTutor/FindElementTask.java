package com.neotech.fullReviewWithTutor;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FindElementTask {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();

        driver.findElement(By.id("logout-link"));
        driver.findElement(By.name("exit-btn"));
        driver.findElement(By.linkText("Güvenli Çıkış Yap"));
        driver.findElement(By.partialLinkText("Çıkış Yap"));
        driver.findElement(By.className("btn-danger"));
    }
}
