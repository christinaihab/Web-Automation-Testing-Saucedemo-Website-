package com.demo.pages;

import com.demo.drivers.WebdriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckOutStepOne {
    WebdriverFactory webdriverFactory;


    // Locators
        private final By inputFirstName = By.id("first-name");
        private final By inputLastName = By.id("last-name");
        private final By inputZipCode = By.id("postal-code");
        private final By continueButton = By.id("continue");
        private final By cancelButton = By.id("cancel");

        // Constructor to initialize the WebDriver
        public CheckOutStepOne(WebdriverFactory webdriverFactory) {
            this.webdriverFactory = webdriverFactory;
        }

        //Action
        public CheckOutStepOne enterFirstName(String firstName) {
            webdriverFactory.getElementActions().type(inputFirstName, firstName);
            return this;
        }
        public CheckOutStepOne enterLastName(String lastName) {
            webdriverFactory.getElementActions().type(inputLastName, lastName);
            return this;
        }
        public CheckOutStepOne enterZipCode(String zipCode) {
            webdriverFactory.getElementActions().type(inputZipCode, zipCode);
            return this;
        }
        public CheckOutStepTwo clickContinueButton() {
            webdriverFactory.getElementActions().click(continueButton);
            return new CheckOutStepTwo(webdriverFactory);
        }
        public CartPage clickCancelButton() {
            webdriverFactory.getElementActions().click(cancelButton);
            return new CartPage(webdriverFactory);
        }
    }

