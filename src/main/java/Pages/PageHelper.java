package Pages;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class PageHelper {

    protected WebDriver driver;



    // ----- constructor
    public PageHelper(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 15), this);

    }





    //-----------------fluent wait


    public void waitUntilElementInvisible(WebElement element) {
        FluentWait fluentWait = new FluentWait<>(driver)
                .withTimeout(30, TimeUnit.SECONDS)
                .pollingEvery(1, TimeUnit.MILLISECONDS)
                .ignoring(NoSuchElementException.class)
                .ignoring(StaleElementReferenceException.class);
        fluentWait.until(ExpectedConditions.invisibilityOf(element));

    }


    public void waitUntilElementClickable(WebElement element) {
        FluentWait fluentWait = new FluentWait<>(driver)
                .withTimeout(30, TimeUnit.SECONDS)
                .pollingEvery(1, TimeUnit.MILLISECONDS)
                .ignoring(NoSuchElementException.class)
                .ignoring(StaleElementReferenceException.class);

        fluentWait.until(ExpectedConditions.elementToBeClickable(element));

    }

    public void waitUntilElementVisible(WebElement element) {
        FluentWait fluentWait = new FluentWait<>(driver)
                .withTimeout(30, TimeUnit.SECONDS)
                .pollingEvery(1, TimeUnit.MILLISECONDS)
                .ignoring(NoSuchElementException.class)
                .ignoring(StaleElementReferenceException.class);
        fluentWait.until(ExpectedConditions.visibilityOf(element));
    }


    public void waitForElementLocatedBy(By locator) {
        new WebDriverWait(driver, 30)
                .until(ExpectedConditions.presenceOfElementLocated(locator));
    }


}
