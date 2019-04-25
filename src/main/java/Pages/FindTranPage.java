package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class FindTranPage extends PageHelper {
    public FindTranPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "accountId")
    private WebElement account;

    @FindBy(id = "criteria.onDate")
    private WebElement onDate;

    @FindBy(xpath = "//button[@type='submit']")
    List<WebElement> FTelements;
    private WebElement FindTranBtn;


    @FindBy(xpath = "//a[@class='ng-binding']")
    private WebElement fundsTranRec;


    @FindBy(xpath = "//h1[@class='title']")
    private WebElement tranDetTitle;


    public FindTranPage selectAccount(String accountVal) {

        account.click();
        Select accList = new Select(account);
        accList.selectByVisibleText(accountVal);
        return this;
    }


    public FindTranPage setFindDate() {

        DateFormat dateFormat = new SimpleDateFormat("MM-dd-yyyy");
        Date date = new Date();

        System.out.println(dateFormat.format(date));
        onDate.sendKeys(dateFormat.format(date));


        return this;
    }


    public FindTranPage clickFindTranBtn() {
        FindTranBtn = FTelements.get(1);
        FindTranBtn.click();
        return this;
    }

    public FindTranPage clickFundsTranRec() {
        fundsTranRec.click();
        return this;
    }


    public void AssertTranDetails() {

        Assert.assertEquals(tranDetTitle.getText(), "Transaction Details");

    }


}
