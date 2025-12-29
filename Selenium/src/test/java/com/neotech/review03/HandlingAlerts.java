package com.neotech.review03;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.neotech.utils.BaseClass;

public class HandlingAlerts extends BaseClass {

	
	public static void main(String[] args) throws InterruptedException {

		setUp("https://neotech.vercel.app/sis-login");
		
		Thread.sleep(5000);
		
		
		//this is where all the test steps go
		
		//Click on Show Alert button
		driver.findElement(By.id("btnAlert")).click();
		Thread.sleep(2000);
		
		Alert alert = driver.switchTo().alert();
		System.out.println("The text of the alert is: " + alert.getText());
		
		alert.accept();
		Thread.sleep(2000);
		
		
		//Click on Show Delayed Alert
		driver.findElement(By.id("btnDelayedAlert")).click();
		
		
		
		//this will throw NoAlertPresentException --- no such alert.  In fact, we know there is such alert, but the code is not waiting for it to show, 
		
//how do we deal with this????
	//(1) we can use Thread.sleep() to wait for a fixed amount of time. (This line will always stop the code for that amount of time) 
	//	Thread.sleep(10000);
	//	alert = driver.switchTo().alert();
		
		
	//(2) we can use waits to Synchronize the code with the page. That means I can add an expected condition saying that, I am waiting for an alert
			
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.alertIsPresent());
		
		//now I can switch to the alert
		alert = driver.switchTo().alert();
		
		Thread.sleep(2000);
		
		
		alert.accept();
		
		Thread.sleep(2000);
		
		tearDown();
	}

}
