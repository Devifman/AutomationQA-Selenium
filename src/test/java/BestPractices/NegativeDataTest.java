package BestPractices;

import BestPractices.Models.AccountData;
import BestPractices.Pages.CreateAnAccountPage;
import BestPractices.Pages.RegPage;
import org.openqa.selenium.support.PageFactory;
import org.testng.ITestContext;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class NegativeDataTest extends BaseTest {
    private CreateAnAccountPage createAnAccountPage;
    private RegPage regPage;

    @BeforeClass
    protected void beforeSuite(ITestContext testContext) {
        dataPool = new DataPool<>("dataFile", testContext, AccountData.class);
        dataPool.fillAnotherDataPool("negativeDataFile", testContext, AccountData.class);
        createAnAccountPage = PageFactory.initElements(driver, CreateAnAccountPage.class);
        regPage = PageFactory.initElements(driver, RegPage.class);

    }
    @DataProvider(name = "DataEdit")
    public Object[][] dataProviderUser() {
        return dataPool.getData();
    }

    @Test(dataProvider = "DataEdit")
    public void negativePersonalInfoTest(AccountData accountData, AccountData badData){
        createAnAccountPage.acceptAnEmail(accountData.getEmail());
        createAnAccountPage.CreateAnAccount();
        regPage.CreateOfAccount(badData);
    }

}
