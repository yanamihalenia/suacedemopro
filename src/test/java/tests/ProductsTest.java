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
        loginSteps.loginAndWaitForPageOpened(userWithCorrectData);
        productSteps.filterProductsFromAToZ(FILTER_FROM_A_TO_Z);
        productSteps.filterProductsFromZToA(FILTER_FROM_Z_TO_A);
        productSteps.filterProductsFromLowToHigh(FILTER_FROM_LOW_TO_HIGH_PRICE);
        productSteps.filterProductsFromHighToLow(FILTER_FROM_HIGH_TO_LOW_PRICE);
    }
}
