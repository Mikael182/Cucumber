package hotel;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.hotel.LoginPage;
import pages.hotel.MainPage;
import pages.hotel.MyAccountPage;
import pages.hotel.UserRegisterPage;

import java.time.Duration;

public class SignupTest {

    private static WebDriver driver;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://hotel-testlab.coderslab.pl/en/");
    }

    @Test
    public void shouldRegisterNewUser() {
        MainPage mainPage = new MainPage(driver);
        mainPage.goToLoginPage();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.goToRegisterPage();

        UserRegisterPage userRegisterPage = new UserRegisterPage(driver);
        userRegisterPage.registerNewUser("Jan", "Kowalski", "Pass123");

        MyAccountPage myAccountPage = new MyAccountPage(driver);
        Assert.assertTrue(myAccountPage.getPageText().contains("Your account has been created"));
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
