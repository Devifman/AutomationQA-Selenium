package BestPractices;

import BestPractices.Models.AccountData;
import BestPractices.Pages.AddressesPage;
import BestPractices.Pages.CreateAnAccountPage;
import BestPractices.Pages.RegPage;
import BestPractices.Pages.UserAccount;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;

public class AddressesTest {

    private CreateAnAccountPage createAnAccountPage;
    private RegPage regPage;
    private UserAccount userAccount;
    private AddressesPage addressesPage;

    @DataProvider(name = "addresses")
    public Object[][] dataProviderNewUser() {
        return DataPool.getData();

        @Test(dataProvider = "addresses")
        public void testOfAddresess(AccountData ) throws IOException{
createAnAccountPage = PageFactory.initElements(driver,CreateAnAccountPage.class);
regPage = PageFactory.initElements(driver);
        }

    }
}
