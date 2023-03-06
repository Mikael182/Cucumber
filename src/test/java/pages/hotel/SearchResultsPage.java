package pages.hotel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class SearchResultsPage {

    private WebDriver driver;

    public SearchResultsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[@title='Proceed to checkout']")
    private WebElement proceedCheckoutButton;

    public int getRoomsNumber() {
        List<WebElement> rooms = driver.findElements(By.className("room_cont"));
        return rooms.size();
    }

    public String getCartLayerText() {
        WebElement cart = driver.findElement(By.id("layer_cart"));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOf(cart));

        return cart.getText();
    }

    public void addRoomToCart() {
        List<WebElement> rooms = driver.findElements(By.xpath("//span[contains(text(),'Book Now')]"));
        rooms.get(0).click();
    }

    public void goToCheckout() {
        proceedCheckoutButton.click();
    }
}
