package BestPractices;

import BestPractices.Models.AccountData;
import BestPractices.Pages.CreateAnAccountPage;
import BestPractices.Pages.MyDataPage;
import BestPractices.Pages.RegPage;
import BestPractices.Pages.UserAccount;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataVerifTest extends BaseTest {
    private CreateAnAccountPage createAnAccountPage;
    private RegPage regPage;
    private UserAccount userAccount;
    private MyDataPage myDataPage;

    @DataProvider(name = "verificationData")
    public Object[] [] dataProviderUser(){
        return dataPool.getData();
    }
    @Test(dataProvider = "verificationData")
    void DataVerificationTesting(AccountData accountData){
        createAnAccountPage = PageFactory.initElements(driver,CreateAnAccountPage.class);
        regPage = PageFactory.initElements(driver,RegPage.class);
        userAccount = PageFactory.initElements(driver,UserAccount.class);
        myDataPage = PageFactory.initElements(driver,MyDataPage.class);
        createAnAccountPage.logIn(accountData);
        regPage.registationOfAccount(accountData);
        userAccount.personalInformationClick();


    }
}


