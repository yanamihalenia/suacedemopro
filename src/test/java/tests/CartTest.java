package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class CartTest extends BaseTest{

    @Test
    public void checkAddingProductToCartTest(){
        SoftAssert softAssert = new SoftAssert();
        loginPage.openPage(LOGIN_PAGE_URL);
        loginPage.login(USERNAME, PASSWORD);
        String productPrice = productsPage.getProductPrice(SAUCE_LABS_BOLT_T_SHIRT);
        productsPage.addProduct(SAUCE_LABS_BOLT_T_SHIRT);
        headerPage.clickCart();
        String productPriceInCart = cartPage.getProductPrice(SAUCE_LABS_BOLT_T_SHIRT);
        String productNameInCart = cartPage.getProductName(SAUCE_LABS_BOLT_T_SHIRT);
        softAssert.assertEquals(productPriceInCart, productPrice, "Product prices are not match.");
        softAssert.assertEquals(productNameInCart, SAUCE_LABS_BOLT_T_SHIRT, "Product names are not match.");
        softAssert.assertAll();
    }

    @Test
    public void addProductToCartTest(){
        loginPage.openPage(LOGIN_PAGE_URL);
        loginPage.login(USERNAME,PASSWORD);
        productsPage.addProduct(SAUCE_LABS_BACKPACK);
        headerPage.clickCart();
        Assert.assertEquals(cartPage.getProductPrice(SAUCE_LABS_BOLT_T_SHIRT), "15");
    }

    @Test
    public void checkQuantityTest(){
        loginPage.openPage(LOGIN_PAGE_URL);
        loginPage.login(USERNAME,PASSWORD);
        productsPage.addProduct(SAUCE_LABS_BACKPACK);
        cartPage.openPage(CART_PAGE_URL);
        Assert.assertEquals(cartPage.getProductQuantity(),2);
    }
}
