package com.neotech.utils;

import org.openqa.selenium.WebElement;

import java.util.List;

public class CommonMethods {
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
}
