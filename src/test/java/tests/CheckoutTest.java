package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class CheckoutTest extends Preconditions{

    @Test(description = "Test case 2: Make an order")
    public void makeAnOrderTest(){
        SoftAssert softAssert = new SoftAssert();
        loginPage.openPage(LOGIN_PAGE_URL);
        loginPage.login(userWithCorrectData);
        productsPage.addProduct(SAUCE_LABS_ONE_SIE);
        headerPage.clickCart();
        cartPage.clickCheckout();
        checkoutYourInfoPage.fillYourInfoForm(FIRST_NAME, LAST_NAME, POSTAL_CODE);
        checkoutYourInfoPage.clickContinue();
        checkoutOverviewPage.clickFinish();
        softAssert.assertTrue(checkoutCompletePage.isCompleteHeaderDisplayed());
        softAssert.assertTrue(checkoutCompletePage.isCompleteTextDisplayed());
        softAssert.assertAll();
    }

    @Test(description = "Test case 3: Check Total price of items")
    public void checkTotalItemPriceTest(){
        loginPage.openPage(LOGIN_PAGE_URL);
        loginPage.login(userWithCorrectData);
        productsPage.addCoupleProducts(SAUCE_LABS_ONE_SIE, SAUCE_LABS_BOLT_T_SHIRT);
        cartPage.openPage(CHECKOUT_OVERVIEW_URL);
        double priceOneSie = checkoutOverviewPage.getProductPrice(SAUCE_LABS_ONE_SIE);
        double priceBoltTShirt = checkoutOverviewPage.getProductPrice(SAUCE_LABS_BOLT_T_SHIRT);
        double sumOfProductsPrice = priceOneSie + priceBoltTShirt;
        double itemTotalPrice = checkoutOverviewPage.getItemTotalPrice();
        Assert.assertEquals(itemTotalPrice, sumOfProductsPrice);
    }

    @Test(description = "Test case 4: Check Total price with tax")
    public void checkTotalPriceTest(){
        loginPage.openPage(LOGIN_PAGE_URL);
        loginPage.login(userWithCorrectData);
        productsPage.addProduct(ALL_THE_THINGS_T_SHIRT_RED);
        cartPage.openPage(CHECKOUT_OVERVIEW_URL);
        double itemTotalPrice = checkoutOverviewPage.getItemTotalPrice();
        double taxPrice = checkoutOverviewPage.getTaxPrice();
        double sumItemPriceAndTax = itemTotalPrice + taxPrice;
        double totalOrderPrice = checkoutOverviewPage.getTotalOrderPrice();
        Assert.assertEquals(totalOrderPrice, sumItemPriceAndTax);
    }

    @Test(description = "Test case 5: 'Cancel' button links user to Products page")
    public void cancelButtonLinksToProductsTest(){
        loginPage.openPage(LOGIN_PAGE_URL);
        loginPage.login(userWithCorrectData);
        productsPage.addProduct(ALL_THE_THINGS_T_SHIRT_RED);
        cartPage.openPage(CHECKOUT_OVERVIEW_URL);
        checkoutOverviewPage.clickCancel();
        String currentUrl = productsPage.getUrl();
        Assert.assertEquals(currentUrl, PRODUCTS_PAGE_URL);
    }
}
