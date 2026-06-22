package com.demo.pages;

import com.demo.drivers.WebdriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckOutStepTwo {
    WebdriverFactory webdriverFactory;

    //locators
    private final By finishButton= By.id("finish");
    private final By cancelButton= By.id("cancel");

    //Constructor
    public CheckOutStepTwo(WebdriverFactory webdriverFactory) {
        this.webdriverFactory = webdriverFactory;
    }

    //actions
    public InventoryPage clickFinishButton(){
        webdriverFactory.getElementActions().click(finishButton);
        return new InventoryPage(webdriverFactory);
    }

    public CheckOutComplete clickCancelButton(){
        webdriverFactory.getElementActions().click(cancelButton);
        return new CheckOutComplete(webdriverFactory);
    }
}
