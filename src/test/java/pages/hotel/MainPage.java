package pages.hotel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage {

    private WebDriver driver;

    public MainPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(className = "user_login")
    private WebElement signInButton;
    @FindBy(id = "hotel_location")
    private WebElement hotelLocationInput;
    @FindBy(id = "hotel_cat_name")
    private WebElement hotelDropdown;
    @FindBy(className = "hotel_name")
    private WebElement hotelOption;
    @FindBy(id = "check_in_time")
    private WebElement checkInInput;
    @FindBy(id = "check_out_time")
    private WebElement checkOutInput;
    @FindBy(id = "search_room_submit")
    private WebElement searchButton;

    public void goToLoginPage() {
        signInButton.click();
    }

    public void searchHotel(String location, String checkIn, String checkOut) {
        hotelLocationInput.sendKeys(location);
        hotelDropdown.click();
        hotelOption.click();
        checkInInput.sendKeys(checkIn);
        checkOutInput.sendKeys(checkOut);
        searchButton.click();
    }
}
