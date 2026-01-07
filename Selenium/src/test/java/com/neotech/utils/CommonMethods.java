package com.neotech.utils;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CommonMethods extends BaseClass {

	/*
	 * This method clears the text of a web element and sends the text parameter to it
	 * 
	 * @param element
	 * @param text
	 */
	public static void sendText(WebElement element, String text) {
		element.clear();
		element.sendKeys(text);
	}

	/*
	 * This method pauses the execution for a certain amount of time
	 * 
	 * @param seconds
	 */
	public static void wait(int seconds) {
		try {
			Thread.sleep(seconds * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	/*
	 * This method selects a value from the radio button list or checkbox list
	 * 
	 * @param elementList
	 * @param selectValue
	 */
	public static void clickRadioOrCheckbox(List<WebElement> elementList, String selectValue) {
		for (WebElement el : elementList) {
			String elementValue = el.getAttribute("value").trim();

			if (elementValue.equals(selectValue) && el.isEnabled()) {
				el.click();
				break;
			}
		}
	}

	/*
	 * This method select an option from a select element using visible text
	 * 
	 * @param element
	 * @param visibleText
	 */
	public static void selectDropdown(WebElement element, String visibleText) {
		try {
			Select sl = new Select(element);
			sl.selectByVisibleText(visibleText);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/*
	 * This method select an option from a select element using index value
	 * 
	 * @param element
	 * @param index
	 */
	public static void selectDropdown(WebElement element, int index) {
		try {
			Select sl = new Select(element);
			sl.selectByIndex(index);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/*
	 * This method accepts an alert
	 */
	public static void acceptAlert() {
		try {
			Alert alert = driver.switchTo().alert();
			alert.accept();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/*
	 * This method dismisses an alert
	 */
	public static void dismissAlert() {
		try {
			Alert alert = driver.switchTo().alert();
			alert.dismiss();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/*
	 * This method returns the text of the alert
	 */
	public static String getAlertText() {
		try {
			Alert alert = driver.switchTo().alert();
			return alert.getText();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	/*
	 * This method sends the provided text into the alert
	 * 
	 * @param text
	 */
	public static void sendAlertText(String text) {
		try {
			Alert alert = driver.switchTo().alert();
			alert.sendKeys(text);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/*
	 * This method switches to the frame using its name or id.
	 * 
	 * @param nameOrId
	 */
	public static void switchToFrame(String nameOrId) {
		try {
			driver.switchTo().frame(nameOrId);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/*
	 * This method switches to the frame using its index value
	 * 
	 * @param index
	 */
	public static void switchToFrame(int index) {
		try {
			driver.switchTo().frame(index);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/*
	 * This method switches to the frame using web element object.
	 * 
	 * @param element
	 */
	public static void switchToFrame(WebElement element) {
		try {
			driver.switchTo().frame(element);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/*
	 * This method returns a wait object with default wait time
	 */
	public static WebDriverWait getWaitObject() {
		return new WebDriverWait(driver, Duration.ofSeconds(Constants.EXPLICIT_WAIT_TIME));
	}

	/*
	 * This method returns a wait object with the provided wait time
	 */
	public static WebDriverWait getWaitObject(int secondsToWait) {
		return new WebDriverWait(driver, Duration.ofSeconds(secondsToWait));
	}

	/*
	 * this method waits for the visibility of an element represented by its locator
	 * 
	 * @param locator
	 */
	public static void waitForVisibility(By locator) {
		WebDriverWait wait = getWaitObject();
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}

	/*
	 * this method waits for the visibility of an element represented by its web element
	 * 
	 * @param element
	 */
	public static void waitForVisibility(WebElement element) {
		WebDriverWait wait = getWaitObject();
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	/*
	 * This method waits for the clickability of a web element 
	 * 
	 * @param element
	 */
	public static void waitForClickability(WebElement element) {
		WebDriverWait wait = getWaitObject();
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	/*
	 * This method waits for the clickability of a web element using its locator
	 * 
	 * @param element
	 */
	public static void waitForClickability(By locator) {
		WebDriverWait wait = getWaitObject();
		wait.until(ExpectedConditions.elementToBeClickable(locator));
	}

	/*
	 * This method clicks on an element
	 * 
	 * @param element
	 */
	public static void click(WebElement element) {
		waitForClickability(element);
		element.click();
	}

}
