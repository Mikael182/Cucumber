package cucomber;

import duckduckgo.SearchPage;
import duckduckgo.SearchResultPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class StepDefs {
    private WebDriver driver;

    @Given("open browser with duckduckgo")
    public void open_browser_with_duckduckgo() {
        // Write code here that turns the phrase above into concrete actions
        System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://duckduckgo.com/");
    }
    @When("a keyword {} is provided in search field")
    public void a_keyword_selenium_is_provided_in_search_field(String keyword) {
        // Write code here that turns the phrase above into concrete actions
        SearchPage searchPage = new SearchPage(driver);
        searchPage.searchKeyword(keyword);
    }
    @Then("the first record should contain {}")
    public void the_first_record_should_contain_selenium(String expectedText) {
        // Write code here that turns the phrase above into concrete actions
        SearchResultPage searchResultPage = new SearchResultPage(driver);
        String text = searchResultPage.getFirstRecordText();
        Assert.assertTrue(text.contains(expectedText));
    }
    @And("quit browser")
    public void quit_browser() {
        // Write code here that turns the phrase above into concrete actions
        driver.quit();
    }
}
