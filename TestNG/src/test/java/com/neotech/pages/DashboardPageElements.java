package com.neotech.pages;

import com.neotech.utils.CommonMethods;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DashboardPageElements extends CommonMethods {

    @FindBy(id = "account-name")
    public WebElement accountName;

    public DashboardPageElements() {
        PageFactory.initElements(driver, this);
    }

}
