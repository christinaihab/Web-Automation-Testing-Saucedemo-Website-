package tests;

import com.demo.pages.*;
import com.demo.utils.logs.LogsManager;
import org.testng.Assert;
import org.testng.annotations.Test;
import io.qameta.allure.Description; // Import Allure annotations
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.Story;
import io.qameta.allure.SeverityLevel;

public class CheckoutTwoTC extends BaseTestClass {

    //Login, add item to cart, go to cart, continue to checkout one, fill out all fields and go to checkout2
    // Click FINISH
    @Test
    @Description("Test Case to verify the end-to-end checkout flow: from adding an item to completing the order on Checkout Step Two by clicking 'Finish'.")
    @Feature("Checkout Process")
    @Story("P1 - Complete Order via Finish Button")
    @Severity(SeverityLevel.BLOCKER) // Highest severity as it tests final purchase step
    public void continueToCheckoutTwoThenClickFinish() {
        LogsManager.info("Starting test: Validating order completion flow through Checkout Step Two 'Finish' button.");
        //Log in
        new LoginPage(driver).navigateToLoginPage("https://www.saucedemo.com/")
                .enterUsername(jsonReader.getJsonData("validusername"))
                .enterPassword(jsonReader.getJsonData("validpassword"))
                .clickLogin();
        Assert.assertEquals(driver.getBrowserActions().getCurrentUrl(), jsonReader.getJsonData("inventory"), "Doesn't match");
        LogsManager.info("Login successful and verified on the inventory page.");

        //add backpack to cart and go to cart page
        new InventoryPage(driver)
                .clickAddBackPackToCart()
                .clickCartIcon();
        Assert.assertEquals(driver.getBrowserActions().getCurrentUrl(), jsonReader.getJsonData("cart"), "Doesn't match");
        LogsManager.info("Item added to cart and navigated to cart page.");

        //Continue and press checkout button
        new CartPage(driver)
                .clickCheckoutButton();
        Assert.assertEquals(driver.getBrowserActions().getCurrentUrl(), jsonReader.getJsonData("checkoutStepOne"), "Doesn't match");
        LogsManager.info("Navigated to Checkout Step One page.");


        //enter firstname, lastname and zip code press CONTINUE
        new CheckOutStepOne(driver)
                .enterFirstName(jsonReader.getJsonData("FirstName"))
                .enterLastName(jsonReader.getJsonData("LastName"))
                .enterZipCode(jsonReader.getJsonData("ZipCode"))
                .clickContinueButton();
        Assert.assertEquals(driver.getBrowserActions().getCurrentUrl(), jsonReader.getJsonData("checkoutStepTwo"), "Doesn't match");
        LogsManager.info("Successfully moved to Checkout Step Two (Overview).");

        new CheckOutStepTwo(driver)
                .clickFinishButton();
        Assert.assertEquals(driver.getBrowserActions().getCurrentUrl(), jsonReader.getJsonData("checkoutComplete"), "Doesn't match");
        LogsManager.info("Clicked 'Finish' and successfully navigated to the Checkout Complete page. Order submission PASSED.");

    }
    //Login, add item to cart, go to cart, continue to checkout one, fill out all fields and go to checkout2
    // Click CANCEL
    @Test
    @Description("Test Case to verify that the 'Cancel' button on the Checkout Step Two (Overview) page redirects the user back to the Inventory page.")
    @Feature("Checkout Process")
    @Story("P2 - Cancel Order from Overview")
    @Severity(SeverityLevel.NORMAL)
    public void continueToCheckoutTwoThenClickCancel() {
        LogsManager.info("Starting test: Validating the Cancel button functionality on Checkout Step Two.");
        //Log in
        new LoginPage(driver).navigateToLoginPage("https://www.saucedemo.com/")
                .enterUsername(jsonReader.getJsonData("validusername"))
                .enterPassword(jsonReader.getJsonData("validpassword"))
                .clickLogin();
        Assert.assertEquals(driver.getBrowserActions().getCurrentUrl(), jsonReader.getJsonData("inventory"), "Doesn't match");
        LogsManager.info("Login successful and verified on the inventory page.");

        //add backpack to cart and go to cart page
        new InventoryPage(driver)
                .clickAddBackPackToCart()
                .clickCartIcon();
        Assert.assertEquals(driver.getBrowserActions().getCurrentUrl(), jsonReader.getJsonData("cart"), "Doesn't match");
        LogsManager.info("Item added to cart and navigated to cart page.");

        //Continue and press checkout button
        new CartPage(driver)
                .clickCheckoutButton();
        Assert.assertEquals(driver.getBrowserActions().getCurrentUrl(), jsonReader.getJsonData("checkoutStepOne"), "Doesn't match");
        LogsManager.info("Navigated to Checkout Step One page.");


        //enter firstname, lastname and zip code press CONTINUE
        new CheckOutStepOne(driver)
                .enterFirstName(jsonReader.getJsonData("FirstName"))
                .enterLastName(jsonReader.getJsonData("LastName"))
                .enterZipCode(jsonReader.getJsonData("ZipCode"))
                .clickContinueButton();
        Assert.assertEquals(driver.getBrowserActions().getCurrentUrl(), jsonReader.getJsonData("checkoutStepTwo"), "Doesn't match");
        LogsManager.info("Successfully moved to Checkout Step Two (Overview).");

        new CheckOutStepTwo(driver)
                .clickCancelButton();
        Assert.assertEquals(driver.getBrowserActions().getCurrentUrl(), jsonReader.getJsonData("inventory"), "Doesn't match");
        LogsManager.info("Clicked 'Cancel' on Checkout Step Two and successfully returned to the Inventory page. Test PASSED.");

    }


}