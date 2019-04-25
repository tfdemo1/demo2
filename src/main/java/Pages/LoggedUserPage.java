package Pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;


public class LoggedUserPage extends PageHelper {


    public LoggedUserPage(WebDriver driver) {
        super(driver);
    }


    @FindBy(xpath = "//p[@class='smallText']")
    private WebElement loggedUser;


    @FindBy(xpath = "//a[contains(@href,'/parabank/openaccount.htm')]")
    private WebElement openNewAccount;


    @FindBy(xpath = "//a[contains(text(),'Find Transactions')] ")
    private WebElement findTran;


    public void assertLoggedUser(String firstName, String lastName) {
        waitUntilElementVisible(loggedUser);

        Assert.assertEquals(loggedUser.getText(), "Welcome " + firstName + " " + lastName);

    }


    public OpenNewAccountPage clickOpenNewAccount() {
        waitUntilElementClickable(openNewAccount);
        openNewAccount.click();
        return new OpenNewAccountPage(driver);
    }


public FindTranPage clickFindTrans(){

        findTran.click();
        return new FindTranPage(driver);
}



}
