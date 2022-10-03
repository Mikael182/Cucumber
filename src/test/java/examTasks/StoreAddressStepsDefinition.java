package examTasks;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.store.LoginPage;
import pages.store.MyAccountPage;
import pages.store.NewAddressPage;

import java.time.Duration;

public class StoreAddressStepsDefinition {

    private WebDriver driver;

    @Given("user open store mainPage")
    public void user_open_store_main_page() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://mystore-testlab.coderslab.pl.");
    }
    @When("User go to loginPage and provide {} and {}")
    public void user_go_to_login_page_and_provide_michal01_com_pl_and_michal01(String email,String password) {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginAs(email,password);

        MyAccountPage myAccountPage = new MyAccountPage(driver);
        myAccountPage.addNewAddress();
    }
    @And("go to address tab fill fields {}, {}, {}, {}, {}, {}")
    public void newAddressDataProvide(String alias,String firstname,String lastname,String address,String city,String postcode) {
        NewAddressPage newAddressPage = new NewAddressPage(driver);
        newAddressPage.newAddressData(alias,firstname,lastname,address,city,postcode);
    }
    @Then("check if address is created")
    public void check_if_address_is_created() {
        NewAddressPage newAddressPage = new NewAddressPage(driver);
        Assert.assertEquals("Address successfully added!",newAddressPage.checkAddressCreation());
    }
    @And("end test")
    public void end_test() {
        driver.quit();
    }

}
