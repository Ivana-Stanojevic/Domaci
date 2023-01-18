package domaci21;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

/*Automatizovati navodjenje na sajtu https://automationexercise.com. Otici na pocetnu stranu, kliknuti na "Signup / Login",
 unesite u polja za "New User Signup!" pomocu faker-a - ime i email. Kliknuti dugme Signup.
Pored neophodnih polja na Signup ekranu uneti i date of birth, cekirati Title i "Receive special offers from our partners!".
 Country staviti na "Canada".
Docekace vas ekran Account created, kliknuti "Continue". Vratice vas na pocetnu stranicu.
Za kraj kliknuti Delete Account, opet kliknuti Continue.

Waitere po potrebi dodavati.
*/
public class Main {
    public static void main(String[] args) {
        System.setProperty("webdriver.chromedrive", "F:\\IVANA KOMP\\chromedriver.exe");


        WebDriver webDriver = new ChromeDriver();
        webDriver.get("https://automationexercise.com");
        //webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        webDriver.manage().window().maximize();
        JavascriptExecutor javascript = (JavascriptExecutor) webDriver;

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        WebElement signupLogin = webDriver.findElement(By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[4]/a"));
        signupLogin.click();

        Faker faker = new Faker();

        WebElement name = webDriver.findElement(By.name("name"));
        WebElement email = webDriver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div[3]/div/form/input[3]"));

        name.sendKeys(faker.name().firstName());
        email.sendKeys(faker.internet().emailAddress());

        WebElement singUpButton = webDriver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div[3]/div/form/button"));
        singUpButton.click();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        WebElement mrs = webDriver.findElement(By.id("id_gender2"));
        mrs.click();


        javascript.executeScript("document.getElementById(\"password\").focus();");

        WebElement password = webDriver.findElement(By.id("password"));
        password.sendKeys(faker.internet().password());


        //  javascript.executeScript("document.getElementById(\"days\".focus();");
        javascript.executeScript("document.getElementById(\"days\").focus();");
        WebElement selectDay = webDriver.findElement(By.id("days"));
        Select day = new Select(selectDay);
        day.selectByVisibleText("3");

        WebElement selectMonth = webDriver.findElement(By.id("months"));
        Select month = new Select(selectMonth);
        month.selectByVisibleText("April");


        WebElement selectYear = webDriver.findElement(By.id("years"));
        Select year = new Select(selectYear);
        year.selectByVisibleText("2005");
        javascript.executeScript("document.getElementById(\"optin\").focus();");
        WebElement checkBox = webDriver.findElement(By.id("optin"));
        checkBox.submit();

        WebElement firstName = webDriver.findElement(By.id("first_name"));
        firstName.sendKeys(faker.name().firstName());

        WebElement lastName = webDriver.findElement(By.id("last_name"));
        lastName.sendKeys(faker.name().lastName());

        WebElement addressCompany = webDriver.findElement(By.xpath("//*[@id=\"address1\"]"));
        addressCompany.sendKeys(faker.address().streetAddress());
        javascript.executeScript("document.getElementById(\"contry\").focus();");
        WebElement contryName = webDriver.findElement(By.id("contry"));
        Select contry = new Select(contryName);
        contry.selectByVisibleText("Canada");

        WebElement stateName = webDriver.findElement(By.id("state"));
        stateName.sendKeys(faker.address().state());

        WebElement cityName = webDriver.findElement(By.id("city"));
        cityName.sendKeys(faker.address().city());
        javascript.executeScript("document.getElementById(\"zipcode\").focus();");
        WebElement zipCode = webDriver.findElement(By.id("zipcode"));
        zipCode.sendKeys(faker.address().zipCode());


        WebElement MobileNumber = webDriver.findElement(By.id("mobile_number"));
        MobileNumber.sendKeys(faker.phoneNumber().cellPhone());

        WebElement createAccount = webDriver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div/div[1]/form/button"));
        createAccount.click();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        WebElement continueButton = webDriver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div/div/a"));
        continueButton.click();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        WebElement deleteAccount = webDriver.findElement(By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[5]/a"));
        deleteAccount.click();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        WebElement continueButton2 = webDriver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div/div/a"));
        continueButton2.click();

        webDriver.quit();
    }
}
