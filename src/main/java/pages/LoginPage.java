package pages;

import entity.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {

    public static final By USERNAME_INPUT = By.xpath("//*[@data-test='username']");
    public static final By PASSWORD_INPUT = By.xpath("//*[@data-test='password']");
    public static final By LOGIN_BUTTON = By.id("login-button");
    public static final By LOGIN_ERROR_MESSAGE = By.xpath("//*[@data-test='error']");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public ProductsPage login(User user){
        driver.findElement(USERNAME_INPUT).sendKeys(user.getUsername());
        driver.findElement(PASSWORD_INPUT).sendKeys(user.getPassword());
        driver.findElement(LOGIN_BUTTON).click();
        return new ProductsPage(driver);
    }

    public String getErrorMessageText(){
        return driver.findElement(LOGIN_ERROR_MESSAGE).getText();
    }
}
