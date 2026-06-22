package com.demo.pages;
import com.demo.drivers.WebdriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
public class InventoryPage {
    WebdriverFactory webdriverFactory;
    //locators
    private final By addBackPackToCart= By.id("add-to-cart-sauce-labs-backpack");
    private final By removeBackpackFromCart= By.id("remove-sauce-labs-backpack");
    private final By addBikeLightToCart= By.id("add-to-cart-sauce-labs-bike-light");
    private final By cartIcon = By.cssSelector(".shopping_cart_link");
    private final By menuButton = By.id("react-burger-menu-btn");
    private final By logoutButton= By.id("logout_sidebar_link");
    //Constructor
    public InventoryPage(WebdriverFactory webdriverFactory)
    {
        this.webdriverFactory = webdriverFactory;
    }
    //Page Actions
    public InventoryPage clickAddBackPackToCart(){
        webdriverFactory.getElementActions().click(addBackPackToCart);
    return this;
    }
    public InventoryPage clickRemoveBackpackFromCart(){
        webdriverFactory.getElementActions().click(removeBackpackFromCart);
        return this;
    }
    public InventoryPage clickAddBikeLightToCart(){
        webdriverFactory.getElementActions().click(addBikeLightToCart);
        return this;
    }
    public CartPage clickCartIcon(){
        webdriverFactory.getElementActions().click(cartIcon);
        return new CartPage(webdriverFactory);
    }
    public InventoryPage clickMenuButton(){
        webdriverFactory.getElementActions().click(menuButton);
        return this;
    }

    public LoginPage clickLogoutButton() {
        webdriverFactory.getElementActions().click(logoutButton);
        return new LoginPage(webdriverFactory);
    }


}
