package BestPractices;

import BestPractices.Models.AccountData;
import BestPractices.Pages.*;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;

public class ChangeInfoTest extends BaseTest {
    private CreateAnAccountPage createAnAccountPage;
    private RegPage regPage;
    private AddressesPage addressesPage;
    private UserAccount userAccount;

    @DataProvider (name = "userInfo")
    public Object[][] dataProviderNewUser(){
return dataPool.getData();
    }

    @Test(dataProvider = "userInfo")
    public void changeUserDataTest(AccountData accountData) throws IOException{
        createAnAccountPage = PageFactory.initElements(driver,CreateAnAccountPage.class);
        regPage = PageFactory.initElements(driver,RegPage.class);
        addressesPage = PageFactory.initElements(driver,AddressesPage.class);
        userAccount = PageFactory.initElements(driver,UserAccount.class);
        createAnAccountPage.logIn(accountData);
        regPage.registationOfAccount(accountData);
        userAccount.personalInformationClick();
        //Assert.assertTrue(MyDataPage.changeInformation(accountData));



    }
}
