package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPageFactory extends BasePage {

    @FindBy(xpath = "//*[@data-test='username']")
    WebElement usernameInput;
    @FindBy(xpath = "//*[@data-test='password']")
    WebElement passwordInput;
    @FindBy(id = "login-button")
    WebElement loginButton;
    @FindBy(xpath = "//*[@data-test='error']")
    WebElement loginErrorMessage;


//    @FindBy(xpath = "//button[contains(.,'Add')]")
//    WebElement addButton;
//    @FindBy(xpath = "//button[contains(.,'Delete')]")
//    WebElement deleteButton;
//
//    public WebElement getAddButton() {
//        return addButton;
//    }
//
//    public WebElement getDeleteButton() {
//        return deleteButton;
//    }

    public LoginPageFactory(WebDriver driver) {
        super(driver);
    }

    public void login(String userName, String password){
        usernameInput.sendKeys(userName);
        passwordInput.sendKeys(password);
        loginButton.click();
    }

    public String getErrorMessageText(){
        return loginErrorMessage.getText();
    }
}
