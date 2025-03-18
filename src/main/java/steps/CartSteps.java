package steps;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import pages.CartPage;
import pages.CheckoutCompletePage;


public class CartSteps {
    private CartPage cartPage;

    public CartSteps(WebDriver driver){
        cartPage = new CartPage(driver);
    }

    @Step("Place the order by filling all info in the cart")
    public void placeAnOrder(String firstName, String lastName, String zipCode){
        cartPage
                .clickCheckout()
                .fillYourInfoForm(firstName, lastName, zipCode)
                .clickContinue()
                .clickFinish();
    }
}
