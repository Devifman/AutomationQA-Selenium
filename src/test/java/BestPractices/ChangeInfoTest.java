package BestPractices;

import BestPractices.Models.AccountData;
import BestPractices.Pages.CreateAnAccountPage;
import BestPractices.Pages.MyDataPage;
import BestPractices.Pages.RegPage;
import BestPractices.Pages.UserAccount;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ChangeInfoTest extends BaseTest{

    private CreateAnAccountPage createAnAccountPage;
    private RegPage regPage;
    private UserAccount userAccount;
    private MyDataPage myDataPage;

    @BeforeClass
    protected void beforeSuite(ITestContext testContext){
        dataPool = new DataPool("dataFile",testContext, AccountData.class);
        dataPool.fillAnotherDataPool("secondDataFile",testContext,AccountData.class);
        createAnAccountPage = PageFactory.initElements(driver,CreateAnAccountPage.class);
        userAccount = PageFactory.initElements(driver,UserAccount.class);
        regPage = PageFactory.initElements(driver,RegPage.class);
        myDataPage = PageFactory.initElements(driver,MyDataPage.class);

    }
    @DataProvider(name = "changeInfo")
    public Object[][] dataProviderNewUser() {
        return dataPool.getData();
    }

    @Test(dataProvider = "changeInfo")
    public void ChangeDataOfUserTest(AccountData accountData, AccountData accountData2){
        createAnAccountPage.acceptAnEmail(accountData.getEmail());
        createAnAccountPage.CreateAnAccount();
        regPage.CreateOfAccount(accountData);
        userAccount.personalInformationClick();
        myDataPage.changeInformationOfUser(accountData,accountData2);
        myDataPage.saveNewData();

        Assert.assertEquals("Your personal information has been successfully updated.",myDataPage.getSuccessUpdate());
    }

}