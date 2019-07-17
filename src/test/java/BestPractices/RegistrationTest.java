package BestPractices;

import BestPractices.Models.AccountData;
import BestPractices.Pages.CreateAnAccountPage;
import BestPractices.Pages.RegPage;
import BestPractices.Util.Config;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.logging.Logger;

public class RegistrationTest extends BaseTest {
    private CreateAnAccountPage createAnAccountPage;
    private RegPage regPage;
    private static final Logger LOGGER = Logger.getLogger(RegistrationTest.class.getName());

    @BeforeClass
    public void beforeClassMethod() {
        createAnAccountPage = PageFactory.initElements(driver, CreateAnAccountPage.class);
        regPage = PageFactory.initElements(driver, RegPage.class);

    }

    @Test (dataProvider = "RegistrationData",dataProviderClass = RegPage.class)
    public void setCreateAnAccountError(AccountData ob){
        //LOGGER.info("email: "+ ob.getBadEmail);
        createAnAccountPage.CreateAnAccount();


    }

    @Test(dataProvider= "RegistrationData",dataProviderClass = AccountData.class)
    public void checkInfoTest(AccountData ob){
        LOGGER.info("First Name: " + ob.getFirstName());
        LOGGER.info("Last Name: "+ ob.getLastName());
        LOGGER.info("Password: "+ob.getPassword());
        createAnAccountPage.acceptAnEmail(ob.getEmail());
        createAnAccountPage.CreateAnAccount();
        waiter.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"id_gender1\"]")));
        regPage.selectGender();
        regPage.selectFirstName(ob.getFirstName());
        regPage.selectSecondName(ob.getLastName());
        regPage.selectPass(ob.getPassword());
        regPage.selectFirstNameInAddressDiv(ob.getFirstName());
        regPage.selectSecondNameInAddressDiv(ob.getLastName());
        regPage.selectCompany(ob.getCompany());
        regPage.selectAddress1(ob.getAddress1());
        regPage.selectAddress2(ob.getAddress2());
        regPage.selectCity(ob.getCity());
        regPage.selectState(ob.getState());
        regPage.selectZipCode(ob.getZipCode());
        regPage.selectHomePhone(ob.getHomePhone());
        regPage.selectMobilePhone(ob.getMobilePhone());
        regPage.selectAlias(ob.getAlias());
        regPage.acceptRegistration();

        //String wrongData = regPage.getDataError();

//        try {
//            Assert.assertNotEquals(">My account",wrongData);
//        }catch (Error error){
//            LOGGER.error("Email Accepted);
//        }


    }

}
