package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutYourInfoPage extends HeaderPage{

    private static final By FIRST_NAME_FIELD = By.id("first-name");
    private static final By LAST_NAME_FIELD = By.id("last-name");
    private static final By ZIP_CODE_FIELD = By.id("postal-code");
    private static final By CANCEL_BUTTON = By.id("cancel");
    private static final By CONTINUE_BUTTON = By.id("continue");

    public CheckoutYourInfoPage(WebDriver driver) {
        super(driver);
    }

    public void fillYourInfoForm(String firstName, String lastName, String postalCode){
        driver.findElement(FIRST_NAME_FIELD).sendKeys(firstName);
        driver.findElement(LAST_NAME_FIELD).sendKeys(lastName);
        driver.findElement(ZIP_CODE_FIELD).sendKeys(postalCode);
    }

    public void clickContinue(){
        driver.findElement(CONTINUE_BUTTON).click();
    }

    public void clickCancel(){
        driver.findElement(CANCEL_BUTTON).click();
    }
}
