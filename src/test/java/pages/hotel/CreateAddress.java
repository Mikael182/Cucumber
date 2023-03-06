package pages.hotel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateAddress {
    private WebDriver driver;

    public CreateAddress(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(name = "firstname")
    private WebElement firstName;
    @FindBy(name = "lastname")
    private WebElement lastName;
    @FindBy(name = "company")
    private WebElement company1;
    @FindBy(name = "address1")
    private WebElement address;
    @FindBy(name = "postcode")
    private WebElement postCode;
    @FindBy(name = "city")
    private WebElement cityName;
    @FindBy(name = "phone")
    private WebElement landLine;
    @FindBy(name = "alias")
    private WebElement reference;
    @FindBy(name = "submitAddress")
    private WebElement save;

    public void createUserAddress(String firstname, String lastname, String company, String address1, String postcode, String city, String phone, String alias) {
        firstName.clear();
        firstName.sendKeys(firstname);
        lastName.clear();
        lastName.sendKeys(lastname);
        company1.sendKeys(company);
        address.sendKeys(address1);
        postCode.sendKeys(postcode);
        cityName.sendKeys(city);
        landLine.sendKeys(phone);
        reference.sendKeys(alias);
        save.click();
    }
}