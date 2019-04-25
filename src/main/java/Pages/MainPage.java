package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPage extends PageHelper {


    @FindBy(xpath = "//a[contains(@href,'register.htm')]")
    private WebElement registerPage;

    @FindBy(xpath = "//input[@name='username']")
    private WebElement login;

    @FindBy(xpath = "//input[@name='password']")
    private WebElement password;

    @FindBy(xpath = "//input[@value='Log In']")
    private WebElement logBtn;


    public MainPage(WebDriver driver) {
        super(driver);
    }


    public MainPage openWWW(String www) {


        driver.get(www);
        return this;
    }


    public RegisterPage clickRegisterPage() throws InterruptedException {
        waitUntilElementVisible(registerPage);
        registerPage.click();
        return new RegisterPage(driver);
    }


    public LoggedUserPage logIn(String logVal, String pwdVal) {
        waitUntilElementVisible(login);
        login.clear();
        login.sendKeys(logVal);
        password.clear();
        password.sendKeys(pwdVal);
        logBtn.click();

        return new LoggedUserPage(driver);
    }


}
