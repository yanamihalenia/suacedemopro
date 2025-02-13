package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

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
//    public void addProduct(String... productNames){
//        for (String productName : productNames) {
//            driver.findElement(By.xpath((String.format(ADD_PRODUCT_TO_CART_BUTTON, productNames)))).click();
//        }
//    }

    public void addProduct(String productName){
            driver.findElement(By.xpath((String.format(ADD_PRODUCT_TO_CART_BUTTON, productName)))).click();
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

    public void checkFiltrationFromAtoZ(List<String> listOfItems){
        List<String> listOfItemsFromPage = listOfItems.stream().map(String::toLowerCase).collect(Collectors.toList());
        List<String> sortedList = listOfItemsFromPage.stream().sorted().collect(Collectors.toList());
        Assert.assertEquals(listOfItemsFromPage, sortedList);
    }

    public void checkFiltrationFromZtoA(List<String> listOfItems){
        List<String> listOfItemsFromPage = listOfItems.stream().map(String::toLowerCase).collect(Collectors.toList());
        List<String> sortedList = listOfItemsFromPage.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
        Assert.assertEquals(listOfItemsFromPage, sortedList);
    }

    public void checkFiltrationFromLowToHigh(List<Double> listOfPrices){
        List<Double> sortedList = listOfPrices.stream().sorted().collect(Collectors.toList());
        Assert.assertEquals(listOfPrices, sortedList);
    }

    public void checkFiltrationFromHighToLow(List<Double> listOfPrices){
        List<Double> sortedList = listOfPrices.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
        Assert.assertEquals(listOfPrices, sortedList);
    }

    public void selectOptionInFilter(String sortOption){
        WebElement selectElement = driver.findElement(By.xpath(FILTER_LOCATOR));
        Select dropdown = new Select(selectElement);
        dropdown.selectByValue(sortOption);
    }
}
