package tests;

import com.demo.pages.CartPage;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.demo.pages.InventoryPage;
import com.demo.pages.LoginPage;
import com.demo.utils.logs.LogsManager;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.Story;
import io.qameta.allure.SeverityLevel;

public class CartTc extends BaseTestClass {


    //Login, add item to cart, go to cart, continue to checkout
    @Test
    @Description("Test Case to verify the successful navigation from the Cart Page to the Checkout Information page after adding an item.")
    @Feature("Shopping Cart Flow")
    @Story("P1 - Proceed to Checkout")
    @Severity(SeverityLevel.CRITICAL)
    public void continueToCheckout(){
        LogsManager.info("Starting test: Validating successful transition from Cart to Checkout Step One.");
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
        LogsManager.info("Backpack added to cart and confirmed navigation to the cart page.");

        //Continue and press checkout button
        new CartPage(driver)
                .clickCheckoutButton();
        Assert.assertEquals(driver.getBrowserActions().getCurrentUrl(),jsonReader.getJsonData("checkoutStepOne"),"Doesn't match");
        LogsManager.info("Clicked Checkout button and successfully navigated to Checkout Step One page. Test PASSED.");

    }

    //Login, add item to cart, go to cart, remove item from cart then logout
    @Test
    @Description("Test Case to verify the 'Continue Shopping' functionality from the Cart Page after removing an item, redirecting to the Inventory page.")
    @Feature("Shopping Cart Flow")
    @Story("P2 - Continue Shopping")
    @Severity(SeverityLevel.NORMAL)
    public void continueShopping(){
        LogsManager.info("Starting test: Validating removal of item in cart and 'Continue Shopping' functionality.");

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
                .clickRemoveBackpackFromCart()
                .clickContinueShoppingButton();
        Assert.assertEquals(driver.getBrowserActions().getCurrentUrl(),jsonReader.getJsonData("inventory"),"Doesn't match");
        LogsManager.info("Item removed from cart, clicked 'Continue Shopping', and successfully returned to the Inventory page. Test PASSED.");
    }

    //Login, add item to cart, go to cart , remove it and press on menu and logout
    @Test
    @Description("Test Case to verify that a user can add an item, go to the cart, remove the item, and then successfully log out using the side menu.")
    @Feature("User Authentication and Cart")
    @Story("P3 - Remove Item and Logout")
    @Severity(SeverityLevel.MINOR)
    public void addItemToCartGoToCartRemoveItAndLogout(){

        LogsManager.info("Starting test: Validating item removal from cart followed by logout.");
        //Log in
        new LoginPage(driver).navigateToLoginPage("https://www.saucedemo.com/")
                .enterUsername(jsonReader.getJsonData("validusername"))
                .enterPassword(jsonReader.getJsonData("validpassword"))
                .clickLogin();
        Assert.assertEquals(driver.getBrowserActions().getCurrentUrl(),jsonReader.getJsonData("inventory"),"Doesn't match");
        LogsManager.info("Login successful.");

        //add backpack to cart , press menu and logout
        new InventoryPage(driver)
                .clickAddBackPackToCart()
                .clickCartIcon();
        Assert.assertEquals(driver.getBrowserActions().getCurrentUrl(),jsonReader.getJsonData("cart"),"Doesn't match");
        LogsManager.info("Item added and navigated to cart page.");

        new CartPage(driver)
                .clickRemoveBackpackFromCart()
                .clickMenuButton()
                .clickLogoutButton();
        Assert.assertEquals(driver.getBrowserActions().getCurrentUrl(),jsonReader.getJsonData("login"),"Doesn't match");
        LogsManager.info("Item removed from cart, followed by a successful logout from the side menu. Test Passed.");
    }
}