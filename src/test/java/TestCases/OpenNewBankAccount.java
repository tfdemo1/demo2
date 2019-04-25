package TestCases;

import jxl.read.biff.BiffException;
import jxl.write.WriteException;
import org.testng.annotations.Test;

import java.io.IOException;

public class OpenNewBankAccount extends BasicTest {



    @Test(dataProvider = "inputAccount")
    public void openNewBankAccount(
         String www,
         String login,
         String password

    ) throws IOException, WriteException, BiffException {
mp.openWWW(www)
        .logIn(login,password)
        .clickOpenNewAccount()
        .setAccountType()
        .clickOpenAccountBtn()
        .saveAccountNumber(www,login,password);


    }




}
