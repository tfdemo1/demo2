package TestCases;

import org.testng.annotations.Test;

public class CreateUser extends BasicTest {


    @Test(dataProvider = "inputData")
    public void openPage(

            String www,
            String firstName,
            String lastName,
            String address,
            String city,
            String state,
            String zip,
            String phone,
            String ssn,
            String username,
            String pwd1,
            String pwd2


    ) throws InterruptedException {
        mp.openWWW(www)
                .clickRegisterPage()
                .fillRegistryForm(firstName,lastName,address,city,state,zip,phone,ssn,username,pwd1,pwd2 )
                .clickRegisterBtn()
                .assertLoggedUser(firstName,lastName);


    }
}
