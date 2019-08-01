package BestPractices;

import BestPractices.Models.AccountData;
import BestPractices.Models.AddressessData;
import BestPractices.Pages.Addresses.AddNewAddress;
import BestPractices.Pages.Addresses.AddressesPage;
import BestPractices.Pages.CreateAnAccountPage;
import BestPractices.Pages.RegPage;
import BestPractices.Pages.UserAccount;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;

public class AddressesChangeTest extends BaseTest {

    private CreateAnAccountPage createAnAccountPage;
    private RegPage regPage;
    private UserAccount userAccount;
    private AddressesPage addressesPage;
    private AddNewAddress addNewAddress;

    @BeforeClass
    protected void beforeSuite(ITestContext testContext) {
        dataPool = new DataPool<>("dataFile", testContext, AccountData.class);
        createAnAccountPage = PageFactory.initElements(driver, CreateAnAccountPage.class);
        regPage = PageFactory.initElements(driver, RegPage.class);
        userAccount = PageFactory.initElements(driver, UserAccount.class);
        addressesPage = PageFactory.initElements(driver, AddressesPage.class);
        addNewAddress = PageFactory.initElements(driver, AddNewAddress.class);
    }

    @DataProvider(name = "DataEdit")
    public Object[][] dataProviderUser() {
        return dataPool.getData();

    }
    @Test(dataProvider = "DataEdit")
    public void addNewAddressesTest(AccountData accountData){
        createAnAccountPage.acceptAnEmail(accountData.getEmail());
        createAnAccountPage.CreateAnAccount();
        regPage.CreateOfAccount(accountData);
        userAccount.addressClick();
        addNewAddress.addNewAddress(accountData);

        Assert.assertTrue(addressesPage.verifyAddOfAddresses(accountData));

    }
}