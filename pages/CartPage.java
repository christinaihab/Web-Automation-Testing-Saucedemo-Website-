package com.demo.pages;

import com.demo.drivers.WebdriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage {
    WebdriverFactory webdriverFactory;

    //locators
    private final By removeBackpackFromCart = By.id("remove-sauce-labs-backpack");
    private final By continueShoppingButton= By.id("continue-shopping");
    private final By checkoutButton= By.id("checkout");
    private final By menuButton= By.id("react-burger-menu-btn");
    private final By logoutButton= By.id("logout_sidebar_link");

    //Constructor
    public CartPage(WebdriverFactory webdriverFactory)
    {
        this.webdriverFactory = webdriverFactory;
    }

    //Actions
    public CartPage clickRemoveBackpackFromCart(){
        webdriverFactory.getElementActions().click(removeBackpackFromCart);
        return this;
    }
    public InventoryPage clickContinueShoppingButton(){
        webdriverFactory.getElementActions().click(continueShoppingButton);
        return new InventoryPage(webdriverFactory);
    }
    public CheckOutStepOne clickCheckoutButton(){
        webdriverFactory.getElementActions().click(checkoutButton);
        return new CheckOutStepOne(webdriverFactory);
    }
    public CartPage clickMenuButton(){
        webdriverFactory.getElementActions().click(menuButton);
        return this;
    }

    public LoginPage clickLogoutButton() {
        webdriverFactory.getElementActions().click(logoutButton);
        return new LoginPage(webdriverFactory);
    }

}
