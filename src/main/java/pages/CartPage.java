package pages;

import org.openqa.selenium.WebDriver;

public class CartPage extends HeaderPage{
    public String PRICE = "//*[contains(@class,'inventory_item_price')]";
    public String ITEM_NAME = "inventory_item_name";

    public CartPage(WebDriver driver) {
        super(driver);
    }
}
