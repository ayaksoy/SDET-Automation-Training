package com.neotech.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public class BaseClass {

    public static WebDriver driver;

    @BeforeMethod(alwaysRun = true)
    public void setUp() {
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

//    @BeforeMethod(alwaysRun = true)
//    public static void setUp(String url) {
//        ConfigsReader.readProperties(Constants.CONFIGURATION_FILEPATH);
//        String browser = ConfigsReader.getProperty("browser");
//
//        driver = null;
//        switch (browser.toLowerCase()) {
//            case "chrome": {
//                driver = new ChromeDriver();
//                break;
//            }
//            case "firefox": {
//                driver = new FirefoxDriver();
//                break;
//            }
//            default:
//                break;
//        }
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
//        driver.manage().window().maximize();
//        driver.get(url);
//    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
