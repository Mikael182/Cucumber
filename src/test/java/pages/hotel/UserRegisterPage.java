package pages.hotel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UserRegisterPage {

    private WebDriver driver;

    public UserRegisterPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "customer_firstname")
    private WebElement firstnameInput;
    @FindBy(id = "customer_lastname")
    private WebElement lastnameInput;
    @FindBy(id = "passwd")
    private WebElement passwordInput;
    @FindBy(id = "submitAccount")
    private WebElement submitButton;

    public void registerNewUser(String firstName, String lastName, String password) {
        firstnameInput.sendKeys(firstName);
        lastnameInput.sendKeys(lastName);
        passwordInput.sendKeys(password);
        submitButton.click();
    }
}
