package domaci23.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Sidebar extends BasePage{

    @FindBy(id="react-burger-menu-btn")
    private WebElement siderbarMenuButton;

    @FindBy(id="logout_sidebar_link")
    private WebElement logOut;

    public Sidebar(WebDriver driver, WebDriverWait driverWait) {
        super(driver, driverWait);
    }

    public void logOutMethod() {
        siderbarMenuButton.click();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        logOut.click();
    }
}
