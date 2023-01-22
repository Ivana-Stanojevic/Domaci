package domaci23.tests;

import domaci23.pages.Inventory;
import domaci23.pages.Login;
import domaci23.pages.Sidebar;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class Tests {
    WebDriver driver;
    WebDriverWait driverWait;
    Login logIn;
    Inventory inventory;
    Sidebar sidebar;

    @BeforeClass
    public void beforeClass() {
        System.setProperty("webdriver.chrome.driver", "F:\\IVANA KOMP\\chromedriver.exe");
        driver = new ChromeDriver();
        driverWait = new WebDriverWait(driver, Duration.ofSeconds(10));
        logIn = new Login(driver, driverWait);
        inventory = new Inventory(driver, driverWait);
        sidebar = new Sidebar(driver, driverWait);
    }

    @BeforeMethod
    public void beforeMethod() {
        driver.get(" https://www.saucedemo.com/");
    }

    @Test
    public void test1() {
        logIn.logIn("standard_user", "secret_sauce");

        inventory.cartAdd();
        inventory.getCartNumber();
        String expectedcartNumber = "1";
        String actualcartNumber = inventory.getCartNumber().getText();
        Assert.assertEquals(actualcartNumber, expectedcartNumber);

        inventory.cardRemove();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }


        //boolean actual = inventory.getCartNumber().isDisplayed();
        //Assert.assertFalse(actual);
        // nisam uspela ovo da resim
    }

    @Test
    public void test2() {
        logIn.logIn("standard_user", "secret_sauce");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        sidebar.logOutMethod();

        driver.get("https://www.saucedemo.com/inventory.html");

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        Assert.assertEquals(logIn.getMessage().getText(), "Epic sadface: You can only access '/inventory.html' when you are logged in.");

    }

    @Test
    public void testStandarUserWrongPass() {
        logIn.logIn("standard_user", "7777");
        Assert.assertEquals(logIn.getMessage().getText(), "Epic sadface: Username and password do not match any user in this service");
    }

    @Test
    public void testLocedOutUserCorectPass() {
        logIn.logIn("locked_out_user", "secret_sauce");
        Assert.assertEquals(logIn.getMessage().getText(), "Epic sadface: Sorry, this user has been locked out.");
    }


    @AfterClass
    private void afterClass() {
        driver.quit();
    }

}
