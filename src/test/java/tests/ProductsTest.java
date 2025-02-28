package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.List;

public class ProductsTest extends Preconditions {

    SoftAssert softAssert = new SoftAssert();

    @Test
    public void isAddToCartButtonDisplayedTest(){
        loginSteps.loginAndWaitForPageOpened(userWithCorrectData);
        Assert.assertTrue(productsPage.isAddToCartButtonDisplayed(SAUCE_LABS_BACKPACK));
    }

    @Test
    public void isRemoveButtonDisplayedTest(){
        loginSteps.loginAndWaitForPageOpened(userWithCorrectData);
        productsPage.addProduct(SAUCE_LABS_BACKPACK);
        Assert.assertTrue(productsPage.isRemoveButtonDisplayed(SAUCE_LABS_BACKPACK));
    }

    @Test(description = "Test case 1: Check filter on products page")
    public void checkFilterTest(){
        List<String> listOfItemsFromPage;
        List<String> sortedItemList;
        List<Double> listOfPricesFromPage;
        List<Double> sortedPriceList;
        loginSteps.loginAndWaitForPageOpened(userWithCorrectData);

        productsPage.selectOptionInFilter(FILTER_FROM_A_TO_Z);
        listOfItemsFromPage = productsPage.getListOfItems();
        sortedItemList = productsPage.sortProductsFromAtoZ(listOfItemsFromPage);
        softAssert.assertEquals(listOfItemsFromPage, sortedItemList);

        productsPage.selectOptionInFilter(FILTER_FROM_Z_TO_A);
        listOfItemsFromPage = productsPage.getListOfItems();
        sortedItemList = productsPage.sortProductsFromZtoA(listOfItemsFromPage);
        softAssert.assertEquals(listOfItemsFromPage, sortedItemList);

        productsPage.selectOptionInFilter(FILTER_FROM_LOW_TO_HIGH_PRICE);
        listOfPricesFromPage = productsPage.getListOfPrices();
        sortedPriceList = productsPage.sortProductsFromLowToHighPrice(listOfPricesFromPage);
        softAssert.assertEquals(listOfPricesFromPage, sortedPriceList);

        productsPage.selectOptionInFilter(FILTER_FROM_HIGH_TO_LOW_PRICE);
        listOfPricesFromPage = productsPage.getListOfPrices();
        sortedPriceList = productsPage.sortProductsFromHighToLowPrice(listOfPricesFromPage);
        softAssert.assertEquals(listOfPricesFromPage, sortedPriceList);
        softAssert.assertAll();
    }
}
