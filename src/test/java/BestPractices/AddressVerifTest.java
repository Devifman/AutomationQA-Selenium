package BestPractices;

import BestPractices.Models.AccountData;
import BestPractices.Pages.AddressesPage;
import BestPractices.Pages.CreateAnAccountPage;
import BestPractices.Pages.RegPage;
import BestPractices.Pages.UserAccount;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class AddressVerifTest extends BaseTest {
    private CreateAnAccountPage createAnAccountPage;
    private RegPage regPage;
    private UserAccount userAccount;
    private AddressesPage addressesPage;

    @DataProvider(name = "addresses")
    public Object[][] dataProviderNewUser(){
        return dataPool.getData();
    }

    @Test(dataProvider = "addresses")
    public void setAddressesVerification(AccountData accountData){
        createAnAccountPage = PageFactory.initElements(driver,CreateAnAccountPage.class);
        regPage = PageFactory.initElements(driver,RegPage.class);
        userAccount = PageFactory.initElements(driver,UserAccount.class);
         addressesPage = PageFactory.initElements(driver,AddressesPage.class);
         createAnAccountPage.logIn(accountData);
         regPage.registationOfAccount(accountData);
         userAccount.addressClick();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(addressesPage.firstNameEquals(accountData));
        softAssert.assertTrue(addressesPage.lastNameEquals(accountData));
        softAssert.assertTrue(addressesPage.companyEquals(accountData));
        softAssert.assertTrue(addressesPage.addressLine1Equals(accountData));
        softAssert.assertTrue(addressesPage.addressLine2Equals(accountData));
        softAssert.assertTrue(addressesPage.cityEquals(accountData));
        softAssert.assertTrue(addressesPage.zipCodeEquals(accountData));
        softAssert.assertTrue(addressesPage.homePhoneEquals(accountData));
        softAssert.assertTrue(addressesPage.mobilePhoneEquals(accountData));
        softAssert.assertAll();


    }
}
