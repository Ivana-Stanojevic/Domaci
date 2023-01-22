package domaci22;

import com.github.javafaker.Faker;
import org.checkerframework.checker.units.qual.A;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/*Testirati na stranici https://vue-demo.daniel-avellaneda.com login stranicu.
Test 1: Verifikovati da se u url-u stranice javlja ruta "/login". Verifikovati da atribut type u polju za unos email ima vrednost
 "email" i za password da ima atribut type "password.
Test 2: Koristeci Faker uneti nasumicno generisan email i password i verifikovati da se pojavljuje poruka "User does not exist".
Test 3: Verifikovati da kad se unese admin@admin.com (sto je dobar email) i pogresan password (generisan faker-om), da se pojavljuje poruka
"Wro "Wrong password"
Koristiti TestNG i dodajte before i after class metode.
Domaci se kači na github.
*/
public class LandingTest {
    private WebDriver driver;
    private Faker faker;

    @BeforeClass
    public void beforeClass() {
        System.setProperty("webdriver.chrome.driver", "F:\\IVANA KOMP\\chromedriver.exe");
        driver = new ChromeDriver();
    }

    @BeforeMethod
    public void beforeMethod() {
        driver.get("https://vue-demo.daniel-avellaneda.com");
    }

    @Test
    public void test1() {
        WebElement login = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/header/div/div[3]/a[3]/span"));
        login.click();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        String actualLogin = driver.getCurrentUrl();
        String expectedLogin = "https://vue-demo.daniel-avellaneda.com/login";
        Assert.assertEquals(actualLogin, expectedLogin);

        WebElement emailType = driver.findElement(By.id("email"));
        String actualEmailType = emailType.getAttribute("type");
        String expectedEmailType = "email";
        Assert.assertEquals(actualEmailType, expectedEmailType);

        WebElement passwordType = driver.findElement(By.id("password"));
        String actualPasswordType = passwordType.getAttribute("type");
        String expectedPasswordType = "password";
        Assert.assertEquals(actualPasswordType, expectedPasswordType);

    }

    @Test
    public void test2() {
        WebElement login = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/header/div/div[3]/a[3]/span"));
        login.click();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        faker = new Faker();
        WebElement email = driver.findElement(By.id("email"));
        email.sendKeys(faker.internet().emailAddress());

        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys(faker.internet().password());

        WebElement loginButton = driver.findElement(By.xpath("//*[@id=\"app\"]/div/main/div/div[2]/div/div/div[3]/span/form/div/div[3]/button/span"));
        loginButton.click();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        WebElement message = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div/div[4]/div/div/div/div/div[1]/ul/li"));
        String actualMessage = message.getText();
        String expectedMessage = "User does not exists";
        Assert.assertEquals(actualMessage, expectedMessage);

    }

    @Test
    public void test3() {
        faker = new Faker();

        WebElement logIn = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/header/div/div[3]/a[3]/span"));
        logIn.click();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        WebElement email = driver.findElement(By.id("email"));
        email.sendKeys("admin@admin.com");

        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys(faker.internet().password());


        WebElement login = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div/div[3]/span/form/div/div[3]/button/span"));
        login.click();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        WebElement message = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div/div[4]/div/div/div/div/div[1]/ul/li"));
        Assert.assertEquals(message.getText(), "Wrong password");
    }

    @AfterClass
    private void afterClass() {
        driver.quit();
    }


}
