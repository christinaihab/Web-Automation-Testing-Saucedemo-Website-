package tests;

import com.demo.pages.CartPage;
import com.demo.pages.CheckOutStepOne;
import com.demo.pages.InventoryPage;
import com.demo.pages.LoginPage;
import com.demo.utils.logs.LogsManager;
import org.testng.Assert;
import org.testng.annotations.Test;
import io.qameta.allure.Description; // Import Allure annotations
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.Story;
import io.qameta.allure.SeverityLevel;

public class CheckoutOneTC extends BaseTestClass {

    //Login, add item to cart, go to cart, continue to checkout one, fill out all fields and go to checkout2
    @Test
    @Description("Test Case to verify successful completion of Checkout Step One (filling user information) and navigating to Checkout Step Two (Overview).")
    @Feature("Checkout Process")
    @Story("P1 - Complete Checkout Step One")
    @Severity(SeverityLevel.CRITICAL)
    public void continueToCheckoutTwo(){
        LogsManager.info("Starting test: Validating successful data entry and navigation from Checkout Step One to Step Two.");
        //Log in
        new LoginPage(driver).navigateToLoginPage("https://www.saucedemo.com/")
                .enterUsername(jsonReader.getJsonData("validusername"))
                .enterPassword(jsonReader.getJsonData("validpassword"))
                .clickLogin();
        Assert.assertEquals(driver.getBrowserActions().getCurrentUrl(),jsonReader.getJsonData("inventory"),"Doesn't match");
        LogsManager.info("Login successful and verified on the inventory page.");

        //add backpack to cart and go to cart page
        new InventoryPage(driver)
                .clickAddBackPackToCart()
                .clickCartIcon();
        Assert.assertEquals(driver.getBrowserActions().getCurrentUrl(),jsonReader.getJsonData("cart"),"Doesn't match");
        LogsManager.info("Item added to cart and confirmed navigation to the cart page.");

        //Continue and press checkout button
        new CartPage(driver)
                .clickCheckoutButton();
        Assert.assertEquals(driver.getBrowserActions().getCurrentUrl(),jsonReader.getJsonData("checkoutStepOne"),"Doesn't match");
        LogsManager.info("Navigated to Checkout Step One page.");

        //enter firstname, lastname and zip code press CONTINUE
        new CheckOutStepOne(driver)
                .enterFirstName(jsonReader.getJsonData("FirstName"))
                .enterLastName(jsonReader.getJsonData("LastName"))
                .enterZipCode(jsonReader.getJsonData("ZipCode"))
                .clickContinueButton();
        Assert.assertEquals(driver.getBrowserActions().getCurrentUrl(),jsonReader.getJsonData("checkoutStepTwo"),"Doesn't match");
        LogsManager.info("All fields filled in Checkout Step One and successfully navigated to Checkout Step Two. Test PASSED.");
    }


    //Login, add item to cart, go to cart, continue to checkout one, fill out all fields and click CANCEL
    @Test
    @Description("Test Case to verify the 'Cancel' functionality on the Checkout Step One page redirects the user back to the Cart page.")
    @Feature("Checkout Process")
    @Story("P2 - Cancel Checkout Step One")
    @Severity(SeverityLevel.NORMAL)
    public void cancelOrderAfterChechoutOne (){
        LogsManager.info("Starting test: Validating the Cancel button functionality on Checkout Step One.");
        //Log in
        new LoginPage(driver).navigateToLoginPage("https://www.saucedemo.com/")
                .enterUsername(jsonReader.getJsonData("validusername"))
                .enterPassword(jsonReader.getJsonData("validpassword"))
                .clickLogin();
        Assert.assertEquals(driver.getBrowserActions().getCurrentUrl(),jsonReader.getJsonData("inventory"),"Doesn't match");
        LogsManager.info("Login successful.");

        //add backpack to cart and go to cart page
        new InventoryPage(driver)
                .clickAddBackPackToCart()
                .clickCartIcon();
        Assert.assertEquals(driver.getBrowserActions().getCurrentUrl(),jsonReader.getJsonData("cart"),"Doesn't match");
        LogsManager.info("Item added to cart and navigated to cart page.");

        //Continue and press checkout button
        new CartPage(driver)
                .clickCheckoutButton();
        Assert.assertEquals(driver.getBrowserActions().getCurrentUrl(),jsonReader.getJsonData("checkoutStepOne"),"Doesn't match");
        LogsManager.info("Navigated to Checkout Step One page.");

        //enter firstname, lastname and zip code press CANCEL
        new CheckOutStepOne(driver)
                .enterFirstName(jsonReader.getJsonData("FirstName"))
                .enterLastName(jsonReader.getJsonData("LastName"))
                .enterZipCode(jsonReader.getJsonData("ZipCode"))
                .clickCancelButton();
        Assert.assertEquals(driver.getBrowserActions().getCurrentUrl(),jsonReader.getJsonData("cart"),"Doesn't match");
        LogsManager.info("Clicked Cancel button on Checkout Step One and successfully returned to the Cart page. Test PASSED.");
    }
}