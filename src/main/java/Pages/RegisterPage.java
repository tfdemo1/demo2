package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegisterPage extends PageHelper {

    public RegisterPage(WebDriver driver) {
        super(driver);
    }


    @FindBy(id = "customer.firstName")
    private WebElement firstName;

    @FindBy(id = "customer.lastName")
    private WebElement lastName;

    @FindBy(id = "customer.address.street")
    private WebElement add;

    @FindBy(id = "customer.address.city")
    private WebElement city;

    @FindBy(id = "customer.address.state")
    private WebElement state;

    @FindBy(id = "customer.address.zipCode")
    private WebElement zip;

    @FindBy(id = "customer.phoneNumber")
    private WebElement phone;

    @FindBy(id = "customer.ssn")
    private WebElement ssn;

    @FindBy(id = "customer.username")
    private WebElement userName;

    @FindBy(id = "customer.password")
    private WebElement pass1;

    @FindBy(id = "repeatedPassword")
    private WebElement pass2;

    @FindBy(xpath = "//input[@value='Register']")
    private WebElement regBtn;


    public RegisterPage fillRegistryForm(

            String fNameVal,
            String lNameVal,
            String addVal,
            String cityVal,
            String stateVal,
            String zipVal,
            String phoneVal,
            String ssnVal,
            String userVal,
            String pwd1Val1,
            String pwd2Val


    ) {

        waitUntilElementVisible(firstName);
        firstName.sendKeys(fNameVal);
        lastName.sendKeys(lNameVal);
        add.sendKeys(addVal);
        city.sendKeys(cityVal);
        state.sendKeys(stateVal);
        zip.sendKeys(zipVal);
        phone.sendKeys(phoneVal);
        ssn.sendKeys(ssnVal);
        userName.sendKeys(userVal);
        pass1.sendKeys(pwd1Val1);
        pass2.sendKeys(pwd2Val);

        return this;
    }


    public LoggedUserPage clickRegisterBtn() {

        regBtn.click();
        return new LoggedUserPage(driver);
    }


}
