package pages.hotel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class QuickOrderPage {

    private WebDriver driver;

    public QuickOrderPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "cgv")
    private WebElement termsOfServiceCheckbox;
    @FindBy(xpath = "//a[@title='Pay by bank wire']")
    private WebElement bankPaymentButton;

    public void acceptTermsOfService() {
        termsOfServiceCheckbox.click();
    }

    public void choosePayByBankPayment() {
        bankPaymentButton.click();
    }

}
