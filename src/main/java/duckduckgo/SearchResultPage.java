package duckduckgo;

import io.cucumber.java.en.Then;
import net.jodah.failsafe.internal.util.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class SearchResultPage {
    private WebDriver driver;

    public SearchResultPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public String getFirstRecordText() {
        WebElement result = driver.findElement(By.id("r1-0"));
        return result.getText();
    }
}
