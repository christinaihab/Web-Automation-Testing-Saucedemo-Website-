package tests;

import com.demo.pages.InventoryPage;
import com.demo.pages.LoginPage;
import com.demo.utils.logs.LogsManager;
import org.testng.Assert;
import org.testng.annotations.Test;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.Story;
import io.qameta.allure.SeverityLevel;

public class InventoryTc extends BaseTestClass{
    //Login, add 2 items to cart and go to cart
    @Test
    @Description("Test Case to verify the successful addition of multiple items (Bike Light, Backpack) to the shopping cart and proceeding to the cart page.")
    @Feature("Inventory Management")
    @Story("P1 - Add Multiple Items to Cart and View Cart")
    @Severity(SeverityLevel.CRITICAL)
    public void validAddMultipleItemsToCart(){
        LogsManager.info("Starting test: Validating adding multiple products to cart and proceeding to cart page.");
        //Log in
        new LoginPage(driver).navigateToLoginPage("https://www.saucedemo.com/")
                .enterUsername(jsonReader.getJsonData("validusername"))
                .enterPassword(jsonReader.getJsonData("validpassword"))
                .clickLogin();
        Assert.assertEquals(driver.getBrowserActions().getCurrentUrl(),jsonReader.getJsonData("inventory"),"Doesn't match");
        LogsManager.info("Login successful. Current URL is validated as inventory page.");
        //add bike and backpack to cart and go to cart page
        new InventoryPage(driver)
                .clickAddBackPackToCart()
                .clickAddBikeLightToCart()
                .clickCartIcon();
        Assert.assertEquals(driver.getBrowserActions().getCurrentUrl(),jsonReader.getJsonData("cart"),"Doesn't match");
        LogsManager.info("Two items added to cart and successfully navigated to the Cart page. Test Passed.");    }

    //Login, add item, remove it from cart and go to cart page
    @Test
    @Description("Test Case to verify adding an item (Backpack) to the cart, then successfully removing it before proceeding to the cart page.")
    @Feature("Inventory Management")
    @Story("P2 - Add and Remove Single Item")
    @Severity(SeverityLevel.NORMAL)
    public void validAddItemToCartAndRemoveIt(){
        LogsManager.info("Starting test: Validating adding a product to cart, removing it, and checking cart page.");
        //Log in
        new LoginPage(driver).navigateToLoginPage("https://www.saucedemo.com/")
                .enterUsername(jsonReader.getJsonData("validusername"))
                .enterPassword(jsonReader.getJsonData("validpassword"))
                .clickLogin();
        Assert.assertEquals(driver.getBrowserActions().getCurrentUrl(),jsonReader.getJsonData("inventory"),"Doesn't match");
        LogsManager.info("Login successful and verified on the inventory page.");

        //add backpack to cart and remove it and go to cart page
        new InventoryPage(driver)
                .clickAddBackPackToCart()
                .clickRemoveBackpackFromCart()
                .clickCartIcon();
        Assert.assertEquals(driver.getBrowserActions().getCurrentUrl(),jsonReader.getJsonData("cart"),"Doesn't match");
        LogsManager.info("Item added and immediately removed from cart, then navigated to the Cart page. Test Passed.");    }

    //Login, add item to cart, press on menu and logout
    @Test
    @Description("Test Case to verify that a user can successfully add an item (Backpack) to the cart and then log out via the side menu.")
    @Feature("User Authentication and Inventory")
    @Story("P3 - Add Item and Logout")
    @Severity(SeverityLevel.MINOR)
    public void addItemToCartAndLogout(){

        LogsManager.info("Starting test: Validating adding an item to cart and performing a logout.");
        //Log in
        new LoginPage(driver).navigateToLoginPage("https://www.saucedemo.com/")
                .enterUsername(jsonReader.getJsonData("validusername"))
                .enterPassword(jsonReader.getJsonData("validpassword"))
                .clickLogin();
        Assert.assertEquals(driver.getBrowserActions().getCurrentUrl(),jsonReader.getJsonData("inventory"),"Doesn't match");
        LogsManager.info("Login successful and confirmed on the inventory page.");

        //add backpack to cart , press menu and logout
        new InventoryPage(driver)
                .clickAddBackPackToCart()
                .clickMenuButton()
                .clickLogoutButton();

        Assert.assertEquals(driver.getBrowserActions().getCurrentUrl(),jsonReader.getJsonData("login"),"Doesn't match");
        LogsManager.info("Item added to cart, then successfully logged out. Current URL matches login page. Test Passed.");    }


}
