package pages.store;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

public class ConfirmOrder {
    private WebDriver driver;

    public ConfirmOrder(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[contains(text(), 'Proceed to checkout')]")
    private WebElement proceedToCheckOut;
    @FindBy(name = "confirm-addresses")
    private WebElement confirmAddress;
    @FindBy(name = "confirmDeliveryOption")
    private WebElement confirmDelivery;
    @FindBy(id = "payment-option-1")
    private WebElement payWithCheck;
    @FindBy(id = "conditions_to_approve[terms-and-conditions]")
    private WebElement conditionsApprove;
    @FindBy(xpath = "//button[contains(text(), 'Order with an obligation to pay')]")
    private WebElement orderWithObligationToPay;

    public void confirmOrder() {
        proceedToCheckOut.click();
        confirmAddress.click();
        confirmDelivery.click();
        payWithCheck.click();
        conditionsApprove.click();
        orderWithObligationToPay.click();
    }

    public void screenShot() throws IOException {
        TakesScreenshot screenshot = (TakesScreenshot) driver;
//Saving the screenshot in desired location
        File source = screenshot.getScreenshotAs(OutputType.FILE);
//Path to the location to save screenshot
        FileUtils.copyFile(source, new File("report/Screen.png"));
        //System.out.println("Screenshot is captured");

    }
    public String getPageText() {
        WebElement pageText = driver.findElement(By.cssSelector("i.material-icons"));
        return pageText.getText();
    }
}