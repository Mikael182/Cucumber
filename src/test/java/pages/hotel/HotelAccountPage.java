package pages.hotel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HotelAccountPage {
    private WebDriver driver;

    public HotelAccountPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath = "//a[@title='Addresses']")
    private WebElement addressButton;
    @FindBy(xpath = "//a[@title='Add an address']")
    private WebElement newAddress;

    public void goToAddressForm(){
        addressButton.click();
        newAddress.click();
    }
}
