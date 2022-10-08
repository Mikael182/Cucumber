package pages.store;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class OrderPage {

    private WebDriver driver;

    public OrderPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(name = "s")
    private WebElement searchCatalog;
    @FindBy(xpath = "//a[contains(text(), 'Hummingbird printed sweater')]")
    private WebElement findSweater;
    @FindBy(id = "group_1")
    private WebElement size;
    @FindBy(name = "qty")
    private WebElement quantity;
    @FindBy(xpath = "//div[@class='add']")
    private WebElement submitButton;
    @FindBy(xpath = "//a[contains(text(), 'Proceed to checkout')]")
    private WebElement proceedToCheckout;

    public void productSearch() {
        searchCatalog.clear();
        searchCatalog.sendKeys("Hummingbird Printed Sweater");
        searchCatalog.submit();
    }

    public void findSweaterInSearchResults() {
        findSweater.click();
    }

    public void placeOrder() {
        Select select = new Select(size);
        select.selectByVisibleText("M");
        quantity.clear();
        quantity.sendKeys("5");
        submitButton.click();
        proceedToCheckout.click();
    }
}
