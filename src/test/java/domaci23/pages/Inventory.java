package domaci23.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Inventory extends BasePage{

    @FindBy(id="add-to-cart-sauce-labs-backpack")
    private WebElement addToCart;

    @FindBy(xpath="//*[@id=\"shopping_cart_container\"]/a/span")
    private WebElement cartNumber;

    public WebElement getCartNumber() {
        return cartNumber;
    }


    @FindBy (id = "remove-sauce-labs-backpack")
    private WebElement removeBackpack;



    public Inventory(WebDriver driver, WebDriverWait driverWait) {
        super(driver, driverWait);
    }

    public void cartAdd() {
        addToCart.click();
    }

    public void cardRemove() {
        removeBackpack.click();
    }
}
