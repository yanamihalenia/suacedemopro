package tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class CartTest extends Preconditions{

    SoftAssert softAssert = new SoftAssert();

    @DataProvider(name = "products")
    public Object[][] productsAndPrices(){
        return new Object[][]{
                {SAUCE_LABS_BACKPACK, "$29.99"},
                {SAUCE_LABS_BOLT_T_SHIRT, "$15.99"},
                {SAUCE_LABS_BIKE_LIGHT, "$9.99"},
                {SAUCE_LABS_FLEECE_JACKET, "$49.99"},
                {SAUCE_LABS_ONE_SIE, "$7.99"},
                {ALL_THE_THINGS_T_SHIRT_RED, "$15.99"},
        };
    }

    @Test(dataProvider = "products")
    public void checkProductPriceInCartTest(String productName, String price){
        loginSteps.loginAndWaitForPageOpened(userWithCorrectData);
        productSteps.addProductsAndGoToCart(productName);
        Assert.assertEquals(cartPage.getProductPrice(productName), price);
    }

    @Test
    public void checkAddingProductToCartTest(){
        loginSteps.loginAndWaitForPageOpened(userWithCorrectData);
        String productPrice = productsPage.getProductPrice(SAUCE_LABS_BOLT_T_SHIRT);
        productSteps.addProductsAndGoToCart(SAUCE_LABS_BOLT_T_SHIRT);
        String productPriceInCart = cartPage.getProductPrice(SAUCE_LABS_BOLT_T_SHIRT);
        String productNameInCart = cartPage.getProductName(SAUCE_LABS_BOLT_T_SHIRT);
        softAssert.assertEquals(productPriceInCart, productPrice, "Product prices are not match.");
        softAssert.assertEquals(productNameInCart, SAUCE_LABS_BOLT_T_SHIRT, "Product names are not match.");
        softAssert.assertAll();
    }

    @Test
    public void addProductToCartTest(){
        loginSteps.loginAndWaitForPageOpened(userWithCorrectData);
        productSteps.addProductsAndGoToCart(SAUCE_LABS_BACKPACK);
        Assert.assertEquals(cartPage.getProductPrice(SAUCE_LABS_BACKPACK), "$29.99");
    }

    @Test
    public void checkQuantityTest(){
        loginSteps.loginAndWaitForPageOpened(userWithCorrectData);
        productSteps.addProductsAndGoToCart(SAUCE_LABS_BACKPACK);
        Assert.assertEquals(cartPage.getProductQuantity(),2);
    }

    @Test
    public void removeItemFromCartTest() {
        loginSteps.loginAndWaitForPageOpened(userWithCorrectData);
        productSteps.addProductsAndGoToCart(SAUCE_LABS_BACKPACK);
        cartPage.removeProductFromCart(SAUCE_LABS_BACKPACK);
        Assert.assertFalse(cartPage.isProductDisplayed(SAUCE_LABS_BACKPACK));
    }
}
