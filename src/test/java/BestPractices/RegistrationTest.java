package BestPractices;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.apache.logging.log4j.LogManager;

import java.util.logging.Logger;

public class RegistrationTest {
    private WebDriver driver;
    private WebDriverWait waiter;
    private CreateAnAccountPage createAnAccountPage;
    private RegPage regPage;
    private static final Logger LOGGER = Logger.getLogger(RegistrationTest.class.getName());

    @BeforeClass
    public void beforeClassMethod() throws Exception {
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get(Config.readUrl());
        createAnAccountPage = PageFactory.initElements(driver, CreateAnAccountPage.class);
        regPage = PageFactory.initElements(driver, RegPage.class);
        LOGGER.info("Begining of the test");
    }

    @Test (dataProvider = "RegData",dataProviderClass = RegPage.class)
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
        regPage.setGender();
        regPage.setFirstName(ob.getFirstName());
        regPage.setSecondName(ob.getLastName());
        regPage.setPass(ob.getPassword());
        regPage.setFirstNameInAddressDiv(ob.getFirstName());
        regPage.setSecondNameInAddressDiv(ob.getLastName());
        regPage.setCompany(ob.getCompany());
        regPage.setAddress1(ob.getAddress1());
        regPage.setAddress2(ob.getAddress2());
        regPage.setCity(ob.getCity());
        regPage.setState(ob.getState());
        regPage.setZipCode(ob.getZipCode());
        regPage.setHomePhone(ob.getHomePhone());
        regPage.setMobilePhone(ob.getMobilePhone());
        regPage.setAlias(ob.getAlias());
        regPage.acceptRegistration();

        //String wrongData = regPage.getDataError();

//        try {
//            Assert.assertNotEquals(">My account",wrongData);
//        }catch (Error error){
//            LOGGER.error("Email Accepted);
//        }


    }
    @AfterClass
    public void afterClassMethod(){
        driver.close();
        LOGGER.info("Finish");
    }
}
