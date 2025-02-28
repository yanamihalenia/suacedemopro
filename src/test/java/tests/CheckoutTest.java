package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class CheckoutTest extends Preconditions{

    SoftAssert softAssert = new SoftAssert();

    @Test(description = "Test case 2: Make an order")
    public void makeAnOrderTest(){
        loginSteps.loginAndWaitForPageOpened(userWithCorrectData);
        productSteps.addProductsAndGoToCart(SAUCE_LABS_ONE_SIE);
        cartSteps.placeAnOrder(FIRST_NAME, LAST_NAME, POSTAL_CODE);
        softAssert.assertTrue(checkoutCompletePage.isCompleteHeaderDisplayed());
        softAssert.assertTrue(checkoutCompletePage.isCompleteTextDisplayed());
        softAssert.assertAll();
    }

    @Test(description = "Test case 3: Check Total price of items")
    public void checkTotalItemPriceTest(){
        loginSteps.loginAndWaitForPageOpened(userWithCorrectData);
        productSteps.addProductsAndGoToOverview(SAUCE_LABS_ONE_SIE,SAUCE_LABS_BOLT_T_SHIRT);
        double priceOneSie = checkoutOverviewPage.getProductPrice(SAUCE_LABS_ONE_SIE);
        double priceBoltTShirt = checkoutOverviewPage.getProductPrice(SAUCE_LABS_BOLT_T_SHIRT);
        double sumOfProductsPrice = priceOneSie + priceBoltTShirt;
        double itemTotalPrice = checkoutOverviewPage.getItemTotalPrice();
        Assert.assertEquals(itemTotalPrice, sumOfProductsPrice);
    }

    @Test(description = "Test case 4: Check Total price with tax")
    public void checkTotalPriceTest(){
        loginSteps.loginAndWaitForPageOpened(userWithCorrectData);
        productSteps.addProductsAndGoToOverview(ALL_THE_THINGS_T_SHIRT_RED);
        double itemTotalPrice = checkoutOverviewPage.getItemTotalPrice();
        double taxPrice = checkoutOverviewPage.getTaxPrice();
        double sumItemPriceAndTax = itemTotalPrice + taxPrice;
        double totalOrderPrice = checkoutOverviewPage.getTotalOrderPrice();
        Assert.assertEquals(totalOrderPrice, sumItemPriceAndTax);
    }

    @Test(description = "Test case 5: 'Cancel' button links user to Products page")
    public void cancelButtonLinksToProductsTest(){
        loginSteps.loginAndWaitForPageOpened(userWithCorrectData);
        productSteps.addProductsAndGoToOverview(ALL_THE_THINGS_T_SHIRT_RED);
        checkoutOverviewPage.clickCancel();
        String currentUrl = productsPage.getUrl();
        Assert.assertEquals(currentUrl, PRODUCTS_PAGE_URL);
    }
}
