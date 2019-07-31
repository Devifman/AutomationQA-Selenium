package BestPractices;

import BestPractices.Models.AccountData;
import BestPractices.Pages.Addresses.AddNewAddress;
import BestPractices.Pages.Addresses.AddressesPage;
import BestPractices.Pages.Addresses.UpdateOfAddress;
import BestPractices.Pages.CreateAnAccountPage;
import BestPractices.Pages.RegPage;
import BestPractices.Pages.UserAccount;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class UpdateAddressTest extends BaseTest {
    private CreateAnAccountPage createAnAccountPage;
    private RegPage regPage;
    private UserAccount userAccount;
    private AddressesPage addressesPage;
    private AddNewAddress addNewAddress;
    private UpdateOfAddress updateOfAddress;

    @BeforeClass
    protected void beforeSuite( ITestContext testContext ){
        dataPool = new DataPool<>("dataFile", testContext, AccountData.class);
        dataPool.fillAnotherDataPool("secondDataFile", testContext, AccountData.class);
        createAnAccountPage = PageFactory.initElements(driver,CreateAnAccountPage.class);
        regPage= PageFactory.initElements(driver,RegPage.class);
        userAccount = PageFactory.initElements(driver,UserAccount.class);
        addressesPage = PageFactory.initElements(driver,AddressesPage.class);
        addNewAddress = PageFactory.initElements(driver,AddNewAddress.class);
        updateOfAddress = PageFactory.initElements(driver,UpdateOfAddress.class);

    }

    @DataProvider(name = "userInformation")
    public Object[][] dataProviderNewUser() {
        return dataPool.getData();
    }
    @Test(dataProvider = "userInformation")
    public void updateAddressOfUser(AccountData accountData, AccountData accountData2){
        createAnAccountPage.acceptAnEmail(accountData.getEmail());
        createAnAccountPage.CreateAnAccount();
        regPage.CreateOfAccount(accountData);
        userAccount.addressClick();
        addNewAddress.addNewAddress(accountData);
        addressesPage.changeOfAddresses(accountData2);
        Assert.assertTrue(addressesPage.verifyAddOfAddresses(accountData2));
    }

}
