package TestCases;

import Pages.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import jxl.Sheet;
import jxl.Workbook;
import jxl.WorkbookSettings;
import jxl.read.biff.BiffException;
import jxl.read.biff.File;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.*;
import org.openqa.selenium.WebDriver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;


public abstract class BasicTest {

    WebDriver driver;


    MainPage mp;
    RegisterPage rp;
    LoggedUserPage lup;
    OpenNewAccountPage onap;
    FindTranPage ftp;


    @BeforeMethod
    public void before() throws Exception {


        FileInputStream fs = new FileInputStream("src\\main\\resources\\Input.xls");
        WorkbookSettings ws = new WorkbookSettings();
        ws.setEncoding("Cp1252");
        Workbook wb = Workbook.getWorkbook(fs, ws);
        Sheet sh = wb.getSheet("Config");

        String browser = sh.getCell(0, 1).getContents();


        switch (browser) {

            case "IE": {
                WebDriverManager.iedriver().setup();
                driver = new InternetExplorerDriver();
                driver.manage().window().maximize();

            }
            case "Firefox": {
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                driver.manage().window().maximize();
            }
            default: {
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                driver.manage().window().maximize();
            }


        }


        mp = new MainPage(driver);
        rp = new RegisterPage(driver);
        lup = new LoggedUserPage(driver);
        onap = new OpenNewAccountPage(driver);
        ftp = new FindTranPage(driver);
    }


    @AfterMethod
    public void after() {
        driver.close();
        driver.quit();
    }


    public String[][] getExcelData(String xlsName, String sheetName) {

        String[][] arrayExcelData = null;
        try {
            FileInputStream fs = new FileInputStream(xlsName);
            WorkbookSettings ws = new WorkbookSettings();
            ws.setEncoding("Cp1252");
            Workbook wb = Workbook.getWorkbook(fs, ws);
            Sheet sh = wb.getSheet(sheetName);

            int totalNoOfCols = sh.getColumns();
            int totalNoOfRows = sh.getRows();

            arrayExcelData = new String[totalNoOfRows - 1][totalNoOfCols];

            for (int i = 1; i < totalNoOfRows; i++) {

                for (int j = 0; j < totalNoOfCols; j++) {
                    arrayExcelData[i - 1][j] = sh.getCell(j, i).getContents();
                }

            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
            e.printStackTrace();
        } catch (BiffException e) {
            e.printStackTrace();
        }
        return arrayExcelData;


    }


    @DataProvider
    public Object[][] inputData() {
        Object[][] arrayObject = getExcelData(this.getClass().getClassLoader().getResource("Input.xls").getPath(), "Registry");
        return arrayObject;
    }


    @DataProvider
    public Object[][] inputAccount() {
        Object[][] arrayObject = getExcelData(this.getClass().getClassLoader().getResource("Input.xls").getPath(), "BankAccount");
        return arrayObject;
    }


    @DataProvider
    public Object[][] inputTran() {
        Object[][] arrayObject = getExcelData(this.getClass().getClassLoader().getResource("Input.xls").getPath(), "ExistingAccount");
        return arrayObject;
    }



}
