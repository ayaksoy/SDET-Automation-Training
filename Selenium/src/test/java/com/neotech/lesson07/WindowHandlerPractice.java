package com.neotech.lesson07;

import java.util.Set;

import org.openqa.selenium.By;

import com.neotech.utils.BaseClass;

public class WindowHandlerPractice extends BaseClass {
	// https://demoqa.com/browser-windows
	public static void main(String[] args) throws InterruptedException {
		setUp();

		System.out.println("Title --> " + driver.getTitle());

		String mainWindowHandle = driver.getWindowHandle();

		// click on the first tab button
		driver.findElement(By.id("tabButton")).click();
		Thread.sleep(2000);

		// click on the first window button
		driver.findElement(By.id("windowButton")).click();
		Thread.sleep(2000);

		// click on the second window button
		driver.findElement(By.id("messageWindowButton")).click();
		Thread.sleep(2000);

		// we have four windows open at that moment
		// and the focus is in: main page
		// we never switched to any window

		Set<String> allWindowHandles = driver.getWindowHandles();
		System.out.println("Number of active windows: " + allWindowHandles.size());

		// i want to switch into each window, then close it
		for (String handle : allWindowHandles) {

			// i want to exclude main window
			if (handle != mainWindowHandle) {
				driver.switchTo().window(handle);
				Thread.sleep(2000);

				driver.close();
			}
		}

		tearDown();

	}

}
