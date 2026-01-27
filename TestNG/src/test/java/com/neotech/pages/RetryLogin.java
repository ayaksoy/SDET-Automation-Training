package com.neotech.pages;

import com.neotech.utils.CommonMethods;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RetryLogin extends CommonMethods {
    @FindBy(css = ".toast-message")
    public WebElement invalidCredentials;

    public RetryLogin() {
        PageFactory.initElements(driver, this);
    }
}
