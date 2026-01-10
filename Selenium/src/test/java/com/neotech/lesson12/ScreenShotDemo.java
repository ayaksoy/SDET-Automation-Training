package com.neotech.lesson12;

import org.openqa.selenium.By;

import com.neotech.utils.CommonMethods;
import com.neotech.utils.ConfigsReader;

public class ScreenShotDemo extends CommonMethods {

	// https://hrm.neotechacademy.com/
	public static void main(String[] args) {

		setUp();

		sendText(driver.findElement(By.id("txtUsername")), ConfigsReader.getProperty("username"));
		sendText(driver.findElement(By.id("txtPassword")), ConfigsReader.getProperty("password"));
		click(driver.findElement(By.xpath("//button[@type='submit']")));

		wait(5);

		takeScreenshot("HRM_dashboard.png");

		tearDown();

	}

}
