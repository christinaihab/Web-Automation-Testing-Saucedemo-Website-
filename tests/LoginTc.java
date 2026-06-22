package tests;
import com.demo.pages.LoginPage;
import com.demo.utils.logs.LogsManager;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTc extends BaseTestClass {
    //Valid Login Test Case
    @Test
    @Description("Valid Login Test Case.")
    @Feature("Login")
    @Severity(SeverityLevel.CRITICAL)
    public void validloginTc() {
        String expectedUrl="https://www.saucedemo.com/inventory.html";
        LogsManager.info("Starting the valid Login Testcase.");
        new LoginPage(driver).navigateToLoginPage("https://www.saucedemo.com/")
                .enterUsername(jsonReader.getJsonData("validusername"))
                .enterPassword(jsonReader.getJsonData("validpassword"))
                .clickLogin();
        Assert.assertEquals(driver.getBrowserActions().getCurrentUrl(),jsonReader.getJsonData(
                "inventory"),"Doesn't match");
        LogsManager.info("Login Test Case Passed.");
    }
    @Test
    @Description("Invalid Login Test Case.")
    @Feature("Login")
    @Severity(SeverityLevel.CRITICAL)
    public void invalidloginTc() {
        LogsManager.info("Starting the invalid Login Testcase.");
        new LoginPage(driver).navigateToLoginPage("https://www.saucedemo.com/")
                .enterUsername(jsonReader.getJsonData("invalidusername"))
                .enterPassword(jsonReader.getJsonData("invalidpassword"))
                .clickLogin();
        Assert.assertNotEquals(driver.getBrowserActions().getCurrentUrl(),jsonReader.getJsonData(
                "inventory"),"They match so test case failed.");
        LogsManager.info("Login with invalid username and password Failed.");
    }


}
