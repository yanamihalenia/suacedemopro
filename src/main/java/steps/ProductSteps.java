package steps;

import constants.IConstants;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import pages.HeaderPage;
import pages.ProductsPage;


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
}
