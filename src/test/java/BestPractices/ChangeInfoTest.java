//package BestPractices;
//
//import BestPractices.Models.AccountData;
//import BestPractices.Pages.*;
//import org.openqa.selenium.support.PageFactory;
//import org.testng.ITestContext;
//import org.testng.annotations.BeforeSuite;
//import org.testng.annotations.DataProvider;
//import org.testng.annotations.Test;
//
//public class ChangeInfoTest extends BaseTest {
//    private CreateAnAccountPage createAnAccountPage;
//    private RegPage regPage;
//    private UserAccount userAccount;
//    private MyDataPage myDataPage;
//
//    @BeforeSuite
//    protected void beforeSuite( ITestContext testContext ) {
//        dataPool = new DataPool("dataFile", testContext, AccountData.class);
//
//    }
//
//    @DataProvider(name = "personalInformation")
//    public Object[][] dataProviderNewUser() {
//        return dataPool.getData();
//    }
//
//    @Test(dataProvider = "personalInformation")
//    public void editUserDataTest(AccountData accountData, AccountData accountData2) {
//
//        createAnAccountPage = PageFactory.initElements(driver, CreateAnAccountPage.class);
//        regPage = PageFactory.initElements(driver, RegPage.class);
//        userAccount = PageFactory.initElements(driver, UserAccount.class);
//        myDataPage = PageFactory.initElements(driver, MyDataPage.class);
//
//        createAnAccountPage.CreateAnAccount();
//        createAnAccountPage.(accountData.getEmail());
//        createAnAccountPage.CreateAnAccount();
//
//        regPage.c(accountData);
//        regPage.register();
//
//        userAccount.personalInformationClick();
//        myDataPage.changeInformation(accountData, accountData2);
//        myDataPage.saveUpdates();
//

//
//    }
//}
