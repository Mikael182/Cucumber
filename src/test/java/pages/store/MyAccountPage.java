package pages.store;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyAccountPage {
    private WebDriver driver;

    public MyAccountPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }
    @FindBy(id = "addresses-link")
    private WebElement addressButton;
    @FindBy(xpath = "//a[@data-link-action='add-address']")
    private WebElement newAddressButton;

    public void addNewAddress(){
        addressButton.click();
        newAddressButton.click();
    }
}
