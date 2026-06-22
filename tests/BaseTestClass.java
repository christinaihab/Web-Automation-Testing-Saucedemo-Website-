package tests;

import com.demo.drivers.WebdriverFactory;
import com.demo.utils.dataReader.PropertyReader;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import com.demo.utils.dataReader.JsonReader;

public class BaseTestClass {

        protected WebdriverFactory driver;
        protected JsonReader jsonReader;


    @BeforeMethod
        public void setUp() {
            PropertyReader.loadProperties();

            driver = new WebdriverFactory();
            jsonReader = new JsonReader("login-data");// Initialize jsonReader
        }

        @AfterMethod
        public void tearDown() {
            WebdriverFactory.quitDriver();

    }
}
