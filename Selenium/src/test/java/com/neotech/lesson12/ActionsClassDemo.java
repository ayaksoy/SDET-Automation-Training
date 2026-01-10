package com.neotech.lesson12;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.neotech.utils.CommonMethods;

public class ActionsClassDemo extends CommonMethods {
	// https://www.amazon.com/
	public static void main(String[] args) {

		setUp();

		Actions action = new Actions(driver);

		WebElement signIn = driver.findElement(By.id("nav-link-accountList"));

		// no action will be done unless .perform() is called!
		action.moveToElement(signIn).perform();

		wait(5);

		WebElement newCustomerDiv = driver.findElement(By.id("nav-flyout-ya-newCust"));
		if (newCustomerDiv.getText().contains("Start")) {
			System.out.println("Menu is displayed");
		} else {
			System.out.println("Menu is hidden");
		}

		// how can i right click?
		action.contextClick();

		wait(3);

		WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));

		action.moveToElement(searchBox).click().sendKeys("book").doubleClick().perform();

		// or we can call all these methods individually
//		action.moveToElement(searchBox).perform();
		// wait(3);
//		action.click().perform();
		// wait(3);
//		action.sendKeys("book").perform();
		// wait(3);
//		action.doubleClick().perform();

		wait(3);

		tearDown();

	}

}
