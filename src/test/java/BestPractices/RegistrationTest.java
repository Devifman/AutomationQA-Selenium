package BestPractices;

import BestPractices.Models.AccountData;
import BestPractices.Pages.CreateAnAccountPage;
import BestPractices.Pages.RegPage;
import BestPractices.Util.Config;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class RegistrationTest extends  BaseTest {
    private WebDriver driver;
    private CreateAnAccountPage createAnAccountPage;
    private RegPage regPage;
    @DataProvider(name = "RegistrationData")
    public Object[][] dataProviderNewUser(){
        return dataPool.getData();
    }




    @Test(dataProvider= "RegistrationData")
    public void checkInfoTest(AccountData accountData){
       createAnAccountPage = PageFactory.initElements(driver,CreateAnAccountPage.class);
       regPage = PageFactory.initElements(driver,RegPage.class);

       createAnAccountPage.logIn(accountData);
       regPage.registationOfAccount(accountData);
        Assert.assertEquals(">My account",regPage.getWrongData());

    }

}
