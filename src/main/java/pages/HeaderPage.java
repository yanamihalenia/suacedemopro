package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HeaderPage extends BasePage {
    public static final By CART_BUTTON = By.className("shopping_cart_link");

    public HeaderPage(WebDriver driver) {
        super(driver);
    }

    public void clickCart(){
        driver.findElement(CART_BUTTON).click();
    }
}
