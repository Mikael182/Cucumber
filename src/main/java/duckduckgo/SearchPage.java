package duckduckgo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchPage {
    private WebDriver driver;

    public SearchPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }
    @FindBy(name = "q")
    private WebElement searchInput;

    public void searchKeyword(String keyword) {
        searchInput.clear();
        searchInput.sendKeys(keyword);
        searchInput.submit();
    }
}
