package com.demo.pages;
import com.demo.drivers.WebdriverFactory;
import com.demo.utils.actions.ElementActions;
import org.openqa.selenium.By;

public class LoginPage {

    WebdriverFactory webdriverFactory;

    //Locators
    private final By userName = By.id("user-name");
    private final By password = By.id("password");
    private final By loginButton = By.id("login-button");
    
    //Constructor
    public LoginPage(WebdriverFactory webdriverFactory) {
        this.webdriverFactory = webdriverFactory;
    }

    //Page Actions
    public LoginPage navigateToLoginPage(String url) {
        webdriverFactory.getBrowserActions().navigateTo(url);
        return this;
    }
    public LoginPage enterUsername(String username) {
        webdriverFactory.getElementActions().type(userName, username);
        return this;
    }
    public LoginPage enterPassword(String pwd) {
        webdriverFactory.getElementActions().type(password, pwd);
        return this;
    }
    public InventoryPage clickLogin() {
        webdriverFactory.getElementActions().click(loginButton);
        return new InventoryPage(webdriverFactory);
    }

}
