package pages.store;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NewAddressPage {
    private WebDriver driver;

    public NewAddressPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(name = "alias")
    private WebElement aliasField;
    @FindBy(name = "firstname")
    private WebElement firstnameField;
    @FindBy(name = "lastname")
    private WebElement lastnameField;
    @FindBy(name = "address1")
    private WebElement addressField;
    @FindBy(name = "city")
    private WebElement cityField;
    @FindBy(name = "postcode")
    private WebElement postcodeField;
    @FindBy(xpath = "//button[contains(text(), 'Save')]")
    private WebElement submitButton;

    public void newAddressData(String alias, String firstname, String lastname, String address, String city, String postcode) {
        aliasField.clear();
        aliasField.sendKeys(alias);

        firstnameField.clear();
        firstnameField.sendKeys(firstname);

        lastnameField.clear();
        lastnameField.sendKeys(lastname);

        addressField.clear();
        addressField.sendKeys(address);

        cityField.clear();
        cityField.sendKeys(city);

        postcodeField.clear();
        postcodeField.sendKeys(postcode);

        submitButton.click();
    }

    public String checkAddressCreation() {
        WebElement checkContainer = driver.findElement(By.xpath("//article[@data-alert='success']"));
        return checkContainer.getText();
    }
}
