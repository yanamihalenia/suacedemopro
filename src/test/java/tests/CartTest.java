package tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CartTest extends BaseTest{

    @Test
    public void checkAddingProductToCartTest(){
        String productPrice;
        String productNameInCart;
        String productPriceInCart;
        loginPage.openPage(LOGIN_PAGE_URL);
        loginPage.login(USERNAME, PASSWORD);
        productPrice = driver.findElement(By.xpath("(//*[contains(@class,'inventory_item_price')])[3]")).getText();
        productsPage.addProductToCart(ADD_SAUCE_LABS_BOLT_T_SHIRT);
        headerPage.clickCart();
        productPriceInCart = driver.findElement(By.xpath("//*[contains(@class,'inventory_item_price')]")).getText();
        productNameInCart = driver.findElement(By.className("inventory_item_name")).getText();
        Assert.assertEquals(productPriceInCart, productPrice);
        Assert.assertEquals(productNameInCart, SAUCE_LABS_BOLT_T_SHIRT);
    }
}
