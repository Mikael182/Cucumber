package pages.hotel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    private WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "email")
    private WebElement loginEmailInput;
    @FindBy(id = "passwd")
    private WebElement passwordInput;
    @FindBy(id = "SubmitLogin")
    private WebElement loginButton;
    @FindBy(id = "email_create")
    private WebElement registrationEmailInput;
    @FindBy(name = "SubmitCreate")
    private WebElement createAccountButton;


    public void goToRegisterPage() {
        registrationEmailInput.sendKeys("TEST-" + System.currentTimeMillis() + "@test.io");
        createAccountButton.click();
    }

    /*
    public void goToRegisterPage(String email) {
        registrationEmailInput.sendKeys(email);
        createAccountButton.click();
    }
     */

    public void loginAs(String email, String password) {
        loginEmailInput.sendKeys(email);
        passwordInput.sendKeys(password);
        loginButton.click();
    }
}
