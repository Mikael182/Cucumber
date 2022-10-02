package cucomber;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.hotel.LoginPage;
import pages.hotel.MainPage;
import pages.hotel.MyAccountPage;
import pages.hotel.UserRegisterPage;

import java.time.Duration;

public class HotelStepDefinition {
    private WebDriver driver;

    @Given("user open hotel main page")
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://hotel-testlab.coderslab.pl/en/");
    }

    @When("User go to login page")
    public void shouldRegisterNewUser() {
        MainPage mainPage = new MainPage(driver);
        mainPage.goToLoginPage();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.goToRegisterPage();
    }

    @And("populate form with {},{},{} and use register button")
    public void populate_form_with_first_name_last_name_pass_word_and_use_register_button(String firstname, String lastname, String password) {
        UserRegisterPage userRegisterPage = new UserRegisterPage(driver);
        userRegisterPage.registerNewUser(firstname, lastname, password);
    }

    @Then("account is created")
    public void account_is_created() {
        MyAccountPage myAccountPage = new MyAccountPage(driver);
        Assert.assertTrue(myAccountPage.getPageText().contains("Your account has been created"));
    }

    @And("close browser")
    public void close_browser() {
        // Write code here that turns the phrase above into concrete actions
        driver.quit();
    }
}
