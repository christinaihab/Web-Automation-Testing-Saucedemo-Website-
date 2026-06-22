package com.demo.pages;

import com.demo.drivers.WebdriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckOutComplete {

    WebdriverFactory webdriverFactory;

    //locators
    private final By backHomeButton= By.id("back-to-products");

    //Constructor
    public CheckOutComplete(WebdriverFactory webdriverFactory) {
        this.webdriverFactory = webdriverFactory;
    }

    //Actions
    public InventoryPage clickBackHome(){
        webdriverFactory.getElementActions().click(backHomeButton);
        return new InventoryPage(webdriverFactory);
    }
}
