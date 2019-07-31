package BestPractices;

import BestPractices.Models.AccountData;
import BestPractices.Pages.CreateAnAccountPage;
import BestPractices.Pages.MyDataPage;
import BestPractices.Pages.RegPage;
import BestPractices.Pages.UserAccount;
import org.openqa.selenium.support.PageFactory;
import org.testng.ITestContext;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class DataVerifTest extends BaseTest {
    private CreateAnAccountPage createAnAccountPage;
    private RegPage regPage;
    private UserAccount userAccount;
    private MyDataPage myDataPage;

    @BeforeClass
    protected void beforeSuite(ITestContext testContext){
        dataPool = new DataPool<>("dataFile", testContext, AccountData.class);
        createAnAccountPage = PageFactory.initElements(driver, CreateAnAccountPage.class);
        regPage = PageFactory.initElements(driver, RegPage.class);
        userAccount = PageFactory.initElements(driver, UserAccount.class);
        myDataPage = PageFactory.initElements(driver, MyDataPage.class);

    }

    @DataProvider(name = "verificationData")
    public Object[] [] dataProviderUser(){
        return dataPool.getData();
    }
    @Test(dataProvider = "verificationData")
    void DataVerificationTesting(AccountData accountData){
        createAnAccountPage.acceptAnEmail(accountData.getEmail());
        createAnAccountPage.CreateAnAccount();
        regPage.CreateOfAccount(accountData);
        userAccount.personalInformationClick();
        SoftAssert softAssertion = new SoftAssert();
        softAssertion.assertTrue(myDataPage.verifyEmail(accountData));
        softAssertion.assertTrue(myDataPage.verifyOfFields(accountData));
        softAssertion.assertAll();


    }
}


