package hotel;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.hotel.*;

import java.time.Duration;

public class SearchHotelTest {

    private WebDriver driver;
    private MainPage mainPage;
    private SearchResultsPage searchResultsPage;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://hotel-testlab.coderslab.pl/en/");

        mainPage = new MainPage(driver);
        mainPage.goToLoginPage();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginAs("test_user_pop@test.pl", "testuser");
        MyAccountPage myAccountPage = new MyAccountPage(driver);
        myAccountPage.goToMainPage();
    }

    @Test
    public void shouldSearchRoom() {
        mainPage.searchHotel("Warsaw", "01-01-2023", "10-01-2023");
        searchResultsPage = new SearchResultsPage(driver);

        Assert.assertTrue(searchResultsPage.getRoomsNumber() > 0);
    }

    @Test
    public void shouldAddRoomToCart() {
        mainPage.searchHotel("Warsaw", "01-01-2023", "10-01-2023");
        searchResultsPage = new SearchResultsPage(driver);
        searchResultsPage.addRoomToCart();
        String cartLayerText = searchResultsPage.getCartLayerText();

        Assert.assertTrue(cartLayerText.contains("Room successfully added to your cart"));
    }

    @Test
    public void shouldBookRoom() {
        mainPage.searchHotel("Warsaw", "01-01-2023", "10-01-2023");
        searchResultsPage = new SearchResultsPage(driver);
        searchResultsPage.addRoomToCart();
        searchResultsPage.goToCheckout();
        QuickOrderPage quickOrderPage = new QuickOrderPage(driver);
        quickOrderPage.acceptTermsOfService();
        quickOrderPage.choosePayByBankPayment();
        OrderSummaryPage orderSummaryPage = new OrderSummaryPage(driver);
        orderSummaryPage.confirmOrder();
        OrderConfirmationPage orderConfirmationPage = new OrderConfirmationPage(driver);

        Assert.assertEquals("Your order on MyBooking is complete.", orderConfirmationPage.getAlertMessage());
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
