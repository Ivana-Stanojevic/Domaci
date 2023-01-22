package domaci20;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
public class Main {
    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.drive", "F:\\IVANA KOMP\\chromedriver.exe");

        WebDriver webDriver=new ChromeDriver();
        webDriver.get("https://demoqa.com/text-box");
        webDriver.manage().window().maximize();


        WebElement inputFullName= webDriver.findElement(By.id("userName"));
        inputFullName.sendKeys("Pera Peric");

        WebElement inputEmail =webDriver.findElement(By.id("userEmail"));
        inputEmail.sendKeys("pera.peric@gmail.com");

        WebElement inputCurrentAddress= webDriver.findElement(By.id("currentAddress"));
        inputCurrentAddress.sendKeys("Futoska 111");

        WebElement inputPermanentAddress= webDriver.findElement(By.id("permanentAddress"));
        inputPermanentAddress.sendKeys("Futoska 100");

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        WebElement submitButton = webDriver.findElement(By.id("submit"));
        submitButton.click();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        WebElement actualName= webDriver.findElement(By.id("name"));
        WebElement actualEmail= webDriver.findElement(By.id("email"));

        String name= actualName.getText();
        String email= actualEmail.getText();

        name=name.substring(5);
        email=email.substring(6);

        if (name.equals("Pera Peric")) {
            System.out.println("Ime je tacno");

        } else {
            System.out.println("Ime nije tacno");
        }

        if (email.equals("pera.peric@gmail.com")) {
            System.out.println("Email je tacan");
        } else {
            System.out.println("Email nije tacan");
        }


        webDriver.quit();
    }
}
