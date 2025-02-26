package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
//import org.testng.Assert;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ProductsPage extends HeaderPage {
    private static final String PRODUCT_ITEM = "//*[text()='%s']/ancestor::*[@class=\"inventory_item\"]";
    private static final String ADD_PRODUCT_TO_CART_BUTTON = PRODUCT_ITEM + "//button[contains(text(),'Add')]";
    private static final String REMOVE_PRODUCT_FROM_CART_BUTTON = PRODUCT_ITEM + "//button[contains(text(),'Remove')]";
    private static final String PRODUCT_PRICE = PRODUCT_ITEM + "//*[@class=\"inventory_item_price\"]";
    private static final String FILTER_LOCATOR = "//*[@class=\"product_sort_container\"]";
    private static final String PRODUCT_NAME = PRODUCT_ITEM + "//*[@class=\"inventory_item_name \"]";

    public ProductsPage(WebDriver driver) {
        super(driver);
    }
//  For adding a couple items:
    public ProductsPage addCoupleProducts(String... productNames){
        for (String productName : productNames) {
            driver.findElement(By.xpath((String.format(ADD_PRODUCT_TO_CART_BUTTON, productName)))).click();
        }
        return this;
    }

    public ProductsPage addProduct(String productName){
            driver.findElement(By.xpath((String.format(ADD_PRODUCT_TO_CART_BUTTON, productName)))).click();
            return this;
    }

    public boolean isAddToCartButtonDisplayed(String productName){
        return driver.findElement(By.xpath(String.format(ADD_PRODUCT_TO_CART_BUTTON, productName))).isDisplayed();
    }

    public boolean isRemoveButtonDisplayed(String productName){
        return driver.findElement(By.xpath(String.format(REMOVE_PRODUCT_FROM_CART_BUTTON, productName))).isDisplayed();
    }

    public String getProductPrice(String productName){
        return driver.findElement(By.xpath(String.format(PRODUCT_PRICE, productName))).getText();
    }

    public List<String> getListOfItems(){
        return driver.findElements(By.xpath(PRODUCT_NAME)).stream()
                .map(webElement -> webElement.getText()
                .trim()).collect(Collectors.toList());
    }

    public List<Double> getListOfPrices(){
        return driver.findElements(By.xpath(PRODUCT_PRICE)).stream()
                .map(webElement -> Double.parseDouble(webElement.getText().replaceAll("\\$", "")
                        .trim())).collect(Collectors.toList());
    }

    public List<String> checkFiltrationFromAtoZ(List<String> listOfItems){
        Collections.sort(listOfItems);
        return listOfItems;
    }

    public List<String> checkFiltrationFromZtoA(List<String> listOfItems){
        Collections.sort(listOfItems, Collections.reverseOrder());
        return listOfItems;
    }

    public List<Double> checkFiltrationFromLowToHigh(List<Double> listOfPrices){
        Collections.sort(listOfPrices);
        return listOfPrices;
    }

    public List<Double> checkFiltrationFromHighToLow(List<Double> listOfPrices){
        Collections.sort(listOfPrices, Collections.reverseOrder());
        return listOfPrices;
    }

    public void selectOptionInFilter(String sortOption){
        WebElement selectElement = driver.findElement(By.xpath(FILTER_LOCATOR));
        Select dropdown = new Select(selectElement);
        dropdown.selectByValue(sortOption);
    }

    public String getUrl(){
        return driver.getCurrentUrl();
    }
}
