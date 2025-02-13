package tests;

import constants.IConstants;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class ProductsTest extends BaseTest {

    @Test
    public void isAddToCartButtonDisplayedTest(){
        loginPage.openPage(IConstants.LOGIN_PAGE_URL);
        loginPage.login(USERNAME,PASSWORD);
        Assert.assertTrue(productsPage.isAddToCartButtonDisplayed(SAUCE_LABS_BACKPACK));
    }

    @Test
    public void isRemoveButtonDisplayedTest(){
        loginPage.openPage(IConstants.LOGIN_PAGE_URL);
        loginPage.login(USERNAME,PASSWORD);
        productsPage.addProduct(SAUCE_LABS_BACKPACK);
        Assert.assertTrue(productsPage.isRemoveButtonDisplayed(SAUCE_LABS_BACKPACK));
    }

    @Test(description = "Test case 1: Check filter on products page")
    public void checkFilterTest(){
        List<String> listOfItems;
        List<Double> listOfPrices;
        loginPage.openPage(IConstants.LOGIN_PAGE_URL);
        loginPage.login(USERNAME,PASSWORD);
        productsPage.selectOptionInFilter(FILTER_FROM_A_TO_Z);
        listOfItems = productsPage.getListOfItems();
        productsPage.checkFiltrationFromAtoZ(listOfItems);
        productsPage.selectOptionInFilter(FILTER_FROM_Z_TO_A);
        listOfItems = productsPage.getListOfItems();
        productsPage.checkFiltrationFromZtoA(listOfItems);
        productsPage.selectOptionInFilter(FILTER_FROM_LOW_TO_HIGH_PRICE);
        listOfPrices = productsPage.getListOfPrices();
        productsPage.checkFiltrationFromLowToHigh(listOfPrices);
        productsPage.selectOptionInFilter(FILTER_FROM_HIGH_TO_LOW_PRICE);
        listOfPrices = productsPage.getListOfPrices();
        productsPage.checkFiltrationFromHighToLow(listOfPrices);
    }
}
