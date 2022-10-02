package pages.hotel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyAccountPage {

    private WebDriver driver;

    public MyAccountPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "#center_column a[title='Home']")
    private WebElement homeButton;

    public void goToMainPage() {
        homeButton.click();
    }

    public String getPageText() {
        WebElement pageText = driver.findElement(By.cssSelector("#my-account #center_column"));
        return pageText.getText();
    }
}
