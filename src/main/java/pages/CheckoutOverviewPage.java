package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutOverviewPage extends HeaderPage{

    private static final By CANCEL_BUTTON = By.id("cancel");
    private static final By FINISH_BUTTON = By.id("finish");
    private static final String PRODUCT_ITEM = "//*[text()='%s']/ancestor::*[@class=\"cart_item\"]";
    private static final String PRODUCT_PRICE = PRODUCT_ITEM + "//*[@class=\"inventory_item_price\"]";
    private static final String ITEM_TOTAL_PRICE = "//*[@class=\"summary_subtotal_label\"]";
    private static final String TAX_PRICE = "//*[@class=\"summary_tax_label\"]";
    private static final String TOTAL_PRICE = "//*[@class=\"summary_total_label\"]";

    public CheckoutOverviewPage(WebDriver driver) {
        super(driver);
    }

    public void clickCancel(){
        driver.findElement(CANCEL_BUTTON).click();
    }

    public void clickFinish(){
        driver.findElement(FINISH_BUTTON).click();
    }

    public double getItemTotalPrice(){
        return Double.parseDouble(driver.findElement(By.xpath(ITEM_TOTAL_PRICE))
                .getText().replaceAll("Item total: \\$",""));
    }

    public double getTaxPrice(){
        return Double.parseDouble(driver.findElement(By.xpath(TAX_PRICE))
                .getText().replaceAll("Tax: \\$",""));
    }

    public double getTotalOrderPrice(){
        return Double.parseDouble(driver.findElement(By.xpath(TOTAL_PRICE))
                .getText().replaceAll("Total: \\$",""));
    }

    public double getProductPrice(String productName){
        return Double.parseDouble(driver.findElement(By.xpath(String.format(PRODUCT_PRICE, productName)))
                .getText().replaceAll("\\$",""));
    }
}
