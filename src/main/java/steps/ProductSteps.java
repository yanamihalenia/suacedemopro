package steps;

import constants.IConstants;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;
import pages.HeaderPage;
import pages.ProductsPage;

import java.util.List;


public class ProductSteps implements IConstants {
    private ProductsPage productsPage;
    private HeaderPage headerPage;

    public ProductSteps(WebDriver driver) {
        productsPage = new ProductsPage(driver);
        headerPage = new HeaderPage(driver);
    }

    @Step("Add one and more products and open cart")
    public void addProductsAndGoToCart(String... productNames){
        productsPage.addCoupleProducts(productNames);
        headerPage.clickCart();
    }

    @Step("Add one and more products and open overview")
    public void addProductsAndGoToOverview(String... productNames){
        productsPage.addCoupleProducts(productNames);
        headerPage.openPage(CHECKOUT_OVERVIEW_URL);
    }

    @Step("Filter products by option A-Z")
    public void filterProductsFromAToZ(String option){
        productsPage.selectOptionInFilter(option);
        List<String> listOfItemsFromPage = productsPage.getListOfItems();
        List<String> sortedItemList = productsPage.sortProductsFromAtoZ(listOfItemsFromPage);
        Assert.assertEquals(listOfItemsFromPage, sortedItemList);
    }

    @Step("Filter products by option Z-A")
    public void filterProductsFromZToA(String option){
        productsPage.selectOptionInFilter(option);
        List<String> listOfItemsFromPage = productsPage.getListOfItems();
        List<String> sortedItemList = productsPage.sortProductsFromZtoA(listOfItemsFromPage);
        Assert.assertEquals(listOfItemsFromPage, sortedItemList);
    }

    @Step("Filter products by option low-high")
    public void filterProductsFromLowToHigh(String option){
        productsPage.selectOptionInFilter(option);
        List<Double> listOfPricesFromPage = productsPage.getListOfPrices();
        List<Double> sortedPriceList = productsPage.sortProductsFromLowToHighPrice(listOfPricesFromPage);
        Assert.assertEquals(listOfPricesFromPage, sortedPriceList);
    }

    @Step("Filter products by option high-low")
    public void filterProductsFromHighToLow(String option){
        productsPage.selectOptionInFilter(option);
        List<Double> listOfPricesFromPage = productsPage.getListOfPrices();
        List<Double> sortedPriceList = productsPage.sortProductsFromHighToLowPrice(listOfPricesFromPage);
        Assert.assertEquals(listOfPricesFromPage, sortedPriceList);
    }
}
