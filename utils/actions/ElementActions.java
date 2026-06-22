package com.demo.utils.actions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ElementActions {


    private WebDriver driver;
    public WaitManager WaitBot;
    

    public ElementActions(WebDriver driver) {
        this.driver = driver;
        this.WaitBot = new WaitManager(driver);
    }

    //Clicking
    public void click(By locator) {
        WaitBot.fluentWait().until(d ->
                {
                    try {
                        WebElement element = d.findElement(locator);
                        scrollToElementJS(locator);
                        element.click();
                        return true;
                    } catch (Exception e) {
                        return false;
                    }
                }
        );
    }

    //Typing
    public void type(By locator, String text) {
        WaitBot.fluentWait().until(d ->
                {
                    try {
                        WebElement element = d.findElement(locator);
                        scrollToElementJS(locator);
                        element.clear();
                        element.sendKeys(text);
                        return true;
                    } catch (Exception e) {
                        return false;
                    }
                }
        );
    }


    //Getting text
    public String getText(By locator) {
        return WaitBot.fluentWait().until(d ->
                {
                    try {
                        WebElement element = d.findElement(locator);
                        scrollToElementJS(locator);
                        String msg = element.getText();
                        return !msg.isEmpty() ? msg : null;
                    } catch (Exception e) {
                        return null;
                    }
                }
        );
    }

    //count of elements
    public int getElementsCount(By locator) {
        return WaitBot.fluentWait().until(d ->
                {
                    try {
                        java.util.List<WebElement> elements = d.findElements(locator);
                        return elements.size() > 0 ? elements.size() : null;
                    } catch (Exception e) {
                        return null;
                    }
                }
        );
    }


    //find an element
    public WebElement findElement(By locator) {
        return driver.findElement(locator);
    }

    public List<WebElement> getElements(By locator) {
        return driver.findElements(locator);
    }

    //function to scroll to an element using js
    public void scrollToElementJS(By locator) {
        //WebElement element = driver.findElement(locator);
        ((org.openqa.selenium.JavascriptExecutor) driver)
                .executeScript(""" 
                        arguments[0].scrollIntoView({behaviour:"auto",block:"center",inline:"center"});""", findElement(locator));
    }
    
    
}
