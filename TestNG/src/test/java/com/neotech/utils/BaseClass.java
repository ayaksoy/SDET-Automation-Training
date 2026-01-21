package com.neotech.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class BaseClass {

    public static WebDriver driver;

    public static void setUp() {
        ConfigsReader.readProperties(Constants.CONFIGURATION_FILEPATH);
        String browser = ConfigsReader.getProperty("browser");

        driver = null;
        switch (browser.toLowerCase()) {
            case "chrome": {
                driver = new ChromeDriver();
                break;
            }
            case "firefox": {
                driver = new FirefoxDriver();
                break;
            }
            default:
                break;
        }

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
        String url = ConfigsReader.getProperty("url");
        driver.get(url);
    }

    public static void setUp(String url) {
        ConfigsReader.readProperties(Constants.CONFIGURATION_FILEPATH);
        String browser = ConfigsReader.getProperty("browser");

        driver = null;
        switch (browser.toLowerCase()) {
            case "chrome": {
                driver = new ChromeDriver();
                break;
            }
            case "firefox": {
                driver = new FirefoxDriver();
                break;
            }
            default:
                break;
        }
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
        driver.get(url);
    }

    public static void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
