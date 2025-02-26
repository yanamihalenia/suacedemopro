package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import waiters.Waiter;

public class CheckoutCompletePage extends HeaderPage{

    private static final By BACK_HOME_BUTTON = By.id("back-home");
    private static final String COMPLETE_HEADER = "//*[@class=\"complete-header\"]";
    private static final String COMPLETE_MESSAGE = "//*[@class=\"complete-text\"]";

    public CheckoutCompletePage(WebDriver driver) {
        super(driver);
    }

    public void clickBackHome(){
        driver.findElement(BACK_HOME_BUTTON).click();
    }

    public boolean isCompleteHeaderDisplayed(){
        Waiter wait = new Waiter();
        wait.waitForPageOpened(driver, BACK_HOME_BUTTON);
        return driver.findElement(By.xpath(COMPLETE_HEADER)).isDisplayed();
    }

    public boolean isCompleteTextDisplayed(){
        return driver.findElement(By.xpath(COMPLETE_MESSAGE)).isDisplayed();
    }
}
