package tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class CartTest extends BaseTest{

    @Test
    public void checkAddingProductToCartTest(){
        SoftAssert softAssert = new SoftAssert();
        loginPage.openPage(LOGIN_PAGE_URL);
        loginPage.login(USERNAME, PASSWORD);
        String productPrice = driver.findElement(By.xpath(PRICE_SAUCE_LABS_BOLT_T_SHIRT)).getText();
        productsPage.addProductToCart(ADD_SAUCE_LABS_BOLT_T_SHIRT);
        headerPage.clickCart();
        String productPriceInCart = driver.findElement(By.xpath(cartPage.PRICE)).getText();
        String productNameInCart = driver.findElement(By.className(cartPage.ITEM_NAME)).getText();
        softAssert.assertEquals(productPriceInCart, productPrice, "Product prices are not match.");
        softAssert.assertEquals(productNameInCart, SAUCE_LABS_BOLT_T_SHIRT, "Product names are not match.");
        softAssert.assertAll();
    }

    @Test
    public void addProductToCartTest(){
        loginPage.openPage(LOGIN_PAGE_URL);
        loginPage.login(USERNAME,PASSWORD);
        productsPage.addProduct(SAUCE_LABS_BOLT_T_SHIRT);
        headerPage.clickCart();
        Assert.assertEquals(cartPage.getProductPrice(SAUCE_LABS_BOLT_T_SHIRT), "15");
    }

    @Test
    public void checkQuantityTest(){
        loginPage.openPage(LOGIN_PAGE_URL);
        loginPage.login(USERNAME,PASSWORD);
        productsPage.addProduct(SAUCE_LABS_BOLT_T_SHIRT);
        cartPage.openPage(CART_PAGE_URL);
        Assert.assertEquals(cartPage.getProductQuantity(),2);
    }
}
