package pages.hotel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AddressConfirmPage {


    private WebDriver driver;

    public AddressConfirmPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String getPageText() {
        WebElement pageText = driver.findElement(By.xpath("//strong[contains(text(), 'Your addresses are listed below.')]"));
        return pageText.getText();
    }
}
