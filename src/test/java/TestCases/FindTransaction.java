package TestCases;


import org.testng.annotations.Test;


public class FindTransaction extends BasicTest {

    @Test(dataProvider = "inputTran")
    public void findTran(
            String account,
            String www,
            String login,
            String password

    ) {
        mp.openWWW(www)
                .logIn(login, password)
                .clickFindTrans()
                .selectAccount(account)
                .setFindDate()
                .clickFindTranBtn()
                .clickFundsTranRec()
                .AssertTranDetails();

    }


}
