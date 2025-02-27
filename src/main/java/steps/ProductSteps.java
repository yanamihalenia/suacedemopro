package steps;

import org.openqa.selenium.WebDriver;
import pages.CartPage;
import pages.HeaderPage;
import pages.ProductsPage;


public class ProductSteps {
    private ProductsPage productsPage;
    private HeaderPage headerPage;

    public ProductSteps(WebDriver driver) {
        productsPage = new ProductsPage(driver);
        headerPage = new HeaderPage(driver);
    }

    public void addProductAndGoToCart(String productName){
        productsPage.addProduct(productName);
        headerPage.clickCart();
    }

    public void addCoupleProductsAndGoToCart(String... productNames){
        productsPage.addCoupleProducts(productNames);
        headerPage.clickCart();
    }
}
