package steps;

import org.openqa.selenium.WebDriver;
import pages.ProductsPage;

public class ProductSteps {
    private ProductsPage productsPage;

    public ProductSteps(WebDriver driver) {
        productsPage = new ProductsPage(driver);
    }
}
