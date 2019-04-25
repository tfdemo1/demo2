package Pages;

import jxl.Sheet;
import jxl.Workbook;
import jxl.WorkbookSettings;
import jxl.read.biff.BiffException;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WriteException;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.ss.usermodel.Row;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;


public class OpenNewAccountPage extends PageHelper {
    public OpenNewAccountPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "type")
    private WebElement accType;

    @FindBy(xpath = "//input[@value='Open New Account']")
    private WebElement openBtn;

    @FindBy(id = "newAccountId")
    private WebElement accId;


    public OpenNewAccountPage setAccountType() {
        waitUntilElementVisible(accType);
        accType.sendKeys("SAVINGS");
        return this;

    }

    public OpenNewAccountPage clickOpenAccountBtn() {
        waitUntilElementClickable(openBtn);
        openBtn.click();
        return this;
    }


    public OpenNewAccountPage saveAccountNumber(String www,String login, String pass) throws IOException, BiffException, WriteException {

        FileInputStream fs = new FileInputStream("src\\main\\resources\\Input.xls");
        HSSFWorkbook workbook = null;
        workbook = new HSSFWorkbook(fs);

        HSSFSheet sheet = workbook.getSheetAt(3);

        HSSFCell cell = null;

        int freeRow = sheet.getLastRowNum() + 1;
        System.out.println(freeRow);

        String[] values = {accId.getText(),www,login,pass};

        for(int i=0;i<4;i++){

            HSSFRow sheetrow = sheet.getRow(freeRow);
            if (sheetrow == null) {
                sheetrow = sheet.createRow(freeRow);
            }

            //Check if cell is empty
            cell = sheetrow.getCell(i);
            if (cell == null) {
                cell = sheetrow.createCell(i);
            }
            //Update the value of cell in col 1
            cell.setCellValue(values[i]);

        }

/*
        //Check first empty row
        HSSFRow sheetrow = sheet.getRow(freeRow);
        if (sheetrow == null) {
            sheetrow = sheet.createRow(freeRow);
        }

        //Check if cell is empty
        cell = sheetrow.getCell(0);
        if (cell == null) {
            cell = sheetrow.createCell(0);
        }
        //Update the value of cell in col 1
        cell.setCellValue(accId.getText());

*/



        //Save to file
        FileOutputStream outFile = new FileOutputStream(new File("src\\main\\resources\\Input.xls"));
        workbook.write(outFile);
        outFile.close();


        return this;
    }


}
