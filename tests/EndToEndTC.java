package tests;

import com.demo.pages.*;
import com.demo.utils.logs.LogsManager;
import org.testng.Assert;
import org.testng.annotations.Test;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.Story;
import io.qameta.allure.SeverityLevel;

public class EndToEndTC extends BaseTestClass{
    //Login, add item to cart, go to cart, continue to checkout one, fill out all fields and go to checkout2
    // Click FINISH Then BACK HOME
    @Test
    @Description("Test Case to verify the full End-to-End purchase process, including login, adding an item, checkout, completing the order, and navigating back to the inventory page.")
    @Feature("End-to-End Flow")
    @Story("P0 - Full Purchase and Navigation")
    @Severity(SeverityLevel.BLOCKER)
    public void continueToCheckoutTwoThenClickFinish() {
        LogsManager.info("Starting the full end-to-end purchase scenario.");
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
        LogsManager.info("User details entered successfully, navigated to Checkout Step Two (Overview).");

        new CheckOutStepTwo(driver)
                .clickFinishButton();
        Assert.assertEquals(driver.getBrowserActions().getCurrentUrl(), jsonReader.getJsonData("checkoutComplete"), "Doesn't match");
        LogsManager.info("Clicked 'Finish' and successfully navigated to the Checkout Complete page.");


        new CheckOutComplete(driver)
                .clickBackHome();
        Assert.assertEquals(driver.getBrowserActions().getCurrentUrl(), jsonReader.getJsonData("inventory"), "Doesn't match");
        LogsManager.info("Clicked 'Back Home' and successfully returned to the Inventory page. End To End scenario PASSED.");

    }
}