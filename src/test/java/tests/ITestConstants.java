package tests;

import org.openqa.selenium.By;

public interface ITestConstants {
    String USERNAME = "standard_user";
    String PASSWORD = "secret_sauce";
    String SAUCE_LABS_BACKPACK = "Sauce Labs Backpack";
    String SAUCE_LABS_BIKE_LIGHT = "Sauce Labs Bike Light";
    String SAUCE_LABS_BOLT_T_SHIRT = "Sauce Labs Bolt T-Shirt";
    String SAUCE_LABS_FLEECE_JACKET = "Sauce Labs Fleece Jacket";
    String SAUCE_LABS_ONE_SIE = "Sauce Labs Onesie";
    String ALL_THE_THINGS_T_SHIRT_RED = "Test.allTheThings() T-Shirt (Red)";
    String ADD_TO_CART = "add-to-cart";
    String ADD_SAUCE_LABS_BACKPACK = ADD_TO_CART + "-sauce-labs-backpack";
    String ADD_SAUCE_LABS_BIKE_LIGHT = ADD_TO_CART + "-sauce-labs-bike-light";
    String ADD_SAUCE_LABS_BOLT_T_SHIRT = ADD_TO_CART + "-sauce-labs-bolt-t-shirt";
    String ADD_SAUCE_LABS_FLEECE_JACKET = ADD_TO_CART + "-sauce-labs-fleece-jacket";
    String ADD_SAUCE_LABS_ONE_SIE = ADD_TO_CART + "-sauce-labs-onesie";
    String ADD_ALL_THE_THINGS_T_SHIRT_RED = ADD_TO_CART + "-test.allthethings()-t-shirt-(red)";
    String PRICE = "//*[contains(@class,'inventory_item_price')]";
}
