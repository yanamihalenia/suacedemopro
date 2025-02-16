package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {
    public static final String ERROR_USERNAME_TEXT_MESSAGE = "Epic sadface: Username is required";
    public static final String ERROR_PASSWORD_TEXT_MESSAGE = "Epic sadface: Password is required";
    public static final String ERROR_USERNAME_AND_PASSWORD_TEXT_MESSAGE = "Epic sadface: Username and password do not match any user in this service";

    @Test
    //команда для запуска: mvn -Dtest=LoginTest -Dusername=standard_user -Dpassword=secret_sauce test
    public void successLoginTest(){
        loginPage.openPage(LOGIN_PAGE_URL);
        loginPage.login(
                System.getProperty("username"),
                System.getProperty("password"));
    }

    @Test
    public void loginWithEmptyUsernameTest(){
        loginPage.openPage(LOGIN_PAGE_URL);
        loginPage.login("", PASSWORD);
        Assert.assertEquals(loginPage.getErrorMessageText(), ERROR_USERNAME_TEXT_MESSAGE);
    }

    @Test
    public void loginWithEmptyPasswordTest(){
        loginPage.openPage(LOGIN_PAGE_URL);
        loginPage.login(USERNAME, "");
        Assert.assertEquals(loginPage.getErrorMessageText(), ERROR_PASSWORD_TEXT_MESSAGE);
    }

    @Test
    public void loginWithIncorrectFieldsTest(){
        loginPage.openPage(LOGIN_PAGE_URL);
        loginPage.login("dfsfdss", "877hejfs");
        Assert.assertEquals(loginPage.getErrorMessageText(), ERROR_USERNAME_AND_PASSWORD_TEXT_MESSAGE);
    }

    @Test
    public void loginWithEmptyFieldsTest(){
        loginPage.openPage(LOGIN_PAGE_URL);
        loginPage.login("", "");
        Assert.assertEquals(loginPage.getErrorMessageText(), ERROR_USERNAME_TEXT_MESSAGE);
    }
}
