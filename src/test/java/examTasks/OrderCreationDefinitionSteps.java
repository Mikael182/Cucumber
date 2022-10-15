package examTasks;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.store.ConfirmOrder;
import pages.store.LoginPage;
import pages.store.OrderPage;

import java.io.IOException;
import java.time.Duration;

public class OrderCreationDefinitionSteps {
    private WebDriver driver;

    @Given("Main page is open")
    public void main_page_is_open() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://mystore-testlab.coderslab.pl.");
    }
    @When("user is loged in his account with {} and {}")
    public void user_is_loged_in_his_account(String email,String password) {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginAs(email,password);

    }
    @Then("user will create new order")
    public void user_will_create_new_order() {
        OrderPage orderPage = new OrderPage(driver);
        orderPage.productSearch();
        orderPage.findSweaterInSearchResults();
        orderPage.placeOrder();
        ConfirmOrder confirmOrder = new ConfirmOrder(driver);
        confirmOrder.confirmOrder();

    }
    @And("check if order is created and take screenshot")
    public void check_if_order_is_created_and_take_screenshot() throws IOException {
        ConfirmOrder confirmOrder = new ConfirmOrder(driver);
        confirmOrder.screenShot();
        Assert.assertEquals("\uE876YOUR ORDER IS CONFIRMED",confirmOrder.getPageText());
    }
    @Then("test is finished")
    public void test_is_finished() {
        driver.quit();
    }
}
