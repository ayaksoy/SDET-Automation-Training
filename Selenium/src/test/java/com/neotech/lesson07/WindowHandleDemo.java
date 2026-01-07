package com.neotech.lesson07;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;

import com.neotech.utils.BaseClass;

public class WindowHandleDemo extends BaseClass {

	// https://accounts.google.com/signup
	public static void main(String[] args) throws InterruptedException {

		setUp();

		System.out.println("Title ---> " + driver.getTitle());

		System.out.println("Window Handle ---> " + driver.getWindowHandle());

		Thread.sleep(3000);

		driver.findElement(By.linkText("Help")).click();

		Set<String> allWindowHandles = driver.getWindowHandles();
		System.out.println(allWindowHandles);

		Iterator<String> it = allWindowHandles.iterator();

		String window1 = it.next();
		String window2 = it.next();

		System.out.println("Window 1: " + window1);
		System.out.println("Window 2: " + window2);

		Thread.sleep(3000);

		// Just because we have a second window does not mean that the focus is on it.
		// We have to switch into the new window

		driver.switchTo().window(window2);
		Thread.sleep(3000);

		String title2 = driver.getTitle();
		System.out.println("Title 2 : " + title2);

		// how do i close the second window?
		driver.close();
		Thread.sleep(3000);

		tearDown();

	}

}
