package com.neotech.lesson07;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.neotech.utils.BaseClass;

public class NextedFrames extends BaseClass {

	// https://neotech.vercel.app/iframe/nested
	public static void main(String[] args) {
		setUp();

		// at this point I am in the main page (default content)

		// switch into the parent frame
		driver.switchTo().frame("parent-frame");

		// at this point I am in parent frame

		// switch into the child frame
		driver.switchTo().frame(driver.findElement(By.id("child-frame")));

		// now the focus is in child frame
		WebElement p = driver.findElement(By.tagName("p"));
		String text = p.getText();

		System.out.println("The text inside the child frame is: " + text);

		// switch back to the main page (default content)
		driver.switchTo().defaultContent();

		tearDown();

	}

}
