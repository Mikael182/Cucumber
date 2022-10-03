package pages.store;

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

    @FindBy(name = "email")
    private WebElement loginInput;
    @FindBy(name = "password")
    private WebElement passwordInput;
    @FindBy(xpath = "//a[@title='Log in to your customer account']")
    private WebElement signInButton;
    @FindBy(id = "//a[@class='account']")
    private WebElement userName;
    @FindBy(id = "submit-login")
    private WebElement submit;

    public void loginAs(String email, String password) {
        signInButton.click();

        loginInput.clear();
        loginInput.sendKeys(email);

        passwordInput.clear();
        passwordInput.sendKeys(password);

        submit.click();
    }

    public String getLoggedUsername() {
        return userName.getText();
    }
}
