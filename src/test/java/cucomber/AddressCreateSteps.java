package cucomber;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.hotel.*;

import java.time.Duration;

public class AddressCreateSteps {
    private WebDriver driver;

    @Given("user open hotel mainPage")
    public void setUpMain() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://hotel-testlab.coderslab.pl/en/");
    }

    @When("User go to login and provide {} and {}")
    public void shouldRegisterNewUser(String email, String password) {
        MainPage mainPage = new MainPage(driver);
        mainPage.goToLoginPage();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginAs(email,password);
        HotelAccountPage hotelAccountPage = new HotelAccountPage(driver);
        hotelAccountPage.goToAddressForm();
    }
    @And("go to address fill fields {},{},{},{},{},{},{},{}")
    public void go_to_address_fill_fields(String firstname,String lastname,String company,String address1,String postcode,String city,String phone,String alias) {
        CreateAddress createAddress = new CreateAddress(driver);
        createAddress.createUserAddress(firstname,lastname,company,address1,postcode,city,phone,alias);
    }
    @Then("address is created")
    public void address_is_created() {
        AddressConfirmPage addressConfirmPage = new AddressConfirmPage(driver);
        Assert.assertEquals("Your addresses are listed below.",addressConfirmPage.getPageText());
    }
    @And("close")
    public void close() {
        driver.quit();
    }
}
