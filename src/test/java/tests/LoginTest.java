package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import waiters.Waiter;

public class LoginTest extends Preconditions {
    public static final String ERROR_USERNAME_TEXT_MESSAGE = "Epic sadface: Username is required";
    public static final String ERROR_PASSWORD_TEXT_MESSAGE = "Epic sadface: Password is required";
    public static final String ERROR_USERNAME_AND_PASSWORD_TEXT_MESSAGE = "Epic sadface: Username and password do not match any user in this service";

    @Test
    public void successLoginTest(){
        loginSteps.loginAndWaitForPageOpened(userWithCorrectData);
        Assert.assertEquals(driver.getCurrentUrl(), PRODUCTS_PAGE_URL);
    }

    @Test
    public void loginWithEmptyUsernameTest(){
        loginSteps.loginAndWaitForPageOpened(userWithEmptyUsername);
        Assert.assertEquals(loginPage.getErrorMessageText(), ERROR_USERNAME_TEXT_MESSAGE);
    }

    @Test
    public void loginWithEmptyPasswordTest(){
        loginSteps.loginAndWaitForPageOpened(userWithEmptyPassword);
        Assert.assertEquals(loginPage.getErrorMessageText(), ERROR_PASSWORD_TEXT_MESSAGE);
    }

    @Test
    public void loginWithIncorrectFieldsTest(){
        loginPage.openPage(LOGIN_PAGE_URL);
        loginPage.login(userWithIncorrectData);
        Assert.assertEquals(loginPage.getErrorMessageText(), ERROR_USERNAME_AND_PASSWORD_TEXT_MESSAGE);
    }

    @Test
    public void loginWithEmptyFieldsTest(){
        loginPage.openPage(LOGIN_PAGE_URL);
        loginPage.login(userWithEmptyUsernameAndPassword);
        Assert.assertEquals(loginPage.getErrorMessageText(), ERROR_USERNAME_TEXT_MESSAGE);
    }




//    @Test
//    public void loginWithoutPageFactory(){
//        driver.get("https://the-internet.herokuapp.com/add_remove_elements/");
//        WebElement addButton = driver.findElement(By.xpath("//button[contains(.,'Add')]"));
//        addButton.click();
//        WebElement deleteButton = driver.findElement(By.xpath("//button[contains(.,'Delete')]"));
//        deleteButton.click();
//
//        addButton.click();
//        deleteButton.click();
//    }
//
//    @Test
//    public void loginWithPageFactory(){
//        driver.get("https://the-internet.herokuapp.com/add_remove_elements/");
//        WebElement addButton = loginPageFactory.getAddButton();
//        addButton.click();
//        WebElement deleteButton = loginPageFactory.getDeleteButton();
//        deleteButton.click();
//
//        addButton.click();
//        deleteButton.click();
//    }
}
