package BestPractices;

import BestPractices.Models.AccountData;
import BestPractices.Pages.Addresses.AddressesPage;
import BestPractices.Pages.CreateAnAccountPage;
import BestPractices.Pages.RegPage;
import BestPractices.Pages.UserAccount;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;

public class AddressesChangeTest extends BaseTest {

    private CreateAnAccountPage createAnAccountPage;
    private RegPage regPage;
    private UserAccount userAccount;
    private AddressesPage addressesPage;

    @DataProvider(name = "addresses")
    public Object[][] dataProviderNewUser() {
        return dataPool.getData();
    }

        @Test(dataProvider = "addresses")
        public void testOfAddresess(AccountData accountData ) throws IOException{
createAnAccountPage = PageFactory.initElements(driver,CreateAnAccountPage.class);
regPage = PageFactory.initElements(driver,RegPage.class);
userAccount = PageFactory.initElements(driver,UserAccount.class);
addressesPage = PageFactory.initElements(driver,AddressesPage.class);
createAnAccountPage.startOfRegistration(accountData);
regPage.registrationOfAccount(accountData);
userAccount.addressClick();
addressesPage.changeAddress(accountData);

            Assert.assertEquals("Addresess - My Store",addressesPage.getTitle());
        }


}
