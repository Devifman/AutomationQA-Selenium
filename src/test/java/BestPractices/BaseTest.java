package BestPractices;

import BestPractices.Models.AccountData;
import BestPractices.Util.Config;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.log4testng.Logger;


import java.util.HashMap;
import java.util.concurrent.TimeUnit;


@Listeners (TestListener.class)

public class BaseTest {
    protected WebDriver driver;
    protected WebDriverWait waiter;
    protected static final Logger LOGGER = Logger.getLogger(RegistrationTest.class);
    DataPool dataPool;


    @BeforeClass
    public void beforeClassMethod(ITestContext testContext) {

        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("http://automationpractice.com/index.php?controller=authentication&back=my-account");
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        //PropertyConfigurator.configure(Config.getLog());
        LOGGER.info("Beginning of the test");
    }

    @AfterClass
    public void afterClassMethod(){
       // driver.close();
        LOGGER.info("Finish of logger");
    }
}
