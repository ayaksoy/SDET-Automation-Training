package com.neotech.lesson03;

import com.neotech.utils.CommonMethods;
import com.neotech.utils.ConfigsReader;
import com.neotech.utils.ExcelUtility;
import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Homework1 extends CommonMethods {
    @DataProvider(name = "loginDetails")
    public Object[][] loginData() {
        return new Object[][]{
                {"Halil", "Tekin", "halo9999", "halo@9999"},
                {"John", "Doe", "doe9999", "doe@9999"},
                {"Lorem", "Ipsum", "lorem9999", "lorem@9999"}
        };
    }

    @Test(dataProvider = "excelData", groups = "regression")
    public void loginAndAddDetails(String firstName, String lastName, String userName, String password) {
        sendText(driver.findElement(By.id("txtUsername")), ConfigsReader.getProperty("username"));
        sendText(driver.findElement(By.id("txtPassword")), ConfigsReader.getProperty("password"));
        click(driver.findElement(By.cssSelector("button[type='submit']")));
        click(driver.findElement(By.xpath("//span[normalize-space()='PIM']")));
        click(driver.findElement(By.xpath("//span[normalize-space()='Add Employee']")));

        sendText(driver.findElement(By.id("first-name-box")), firstName);
        sendText(driver.findElement(By.id("last-name-box")), lastName);
        wait(2);
        click(driver.findElement(By.xpath("//button[i[text() = 'arrow_drop_down']]")));
        waitForClickability(driver.findElement(By.xpath("//span[text()='Sample Location']"))).click();
        click(driver.findElement(By.cssSelector("div.custom-control.custom-switch")));
        wait(2);
        sendText(driver.findElement(By.id("username")), userName);
        sendText(driver.findElement(By.id("password")), password);
        sendText(driver.findElement(By.id("confirmPassword")), password);
        wait(2);
        click(driver.findElement(By.id("modal-save-button")));
        waitForVisibility(driver.findElement(By.cssSelector("div#personal_details_tab")));
        takeScreenshot(firstName + lastName + ".png");
    }

    @DataProvider(name = "excelData")
    public Object[][] getExcelData() {
        String filePath = System.getProperty("user.dir") + "/testdata/Excel.xlsx";
        String sheetName = "Employee";

        return ExcelUtility.excelIntoArray(filePath, sheetName);
    }
}
