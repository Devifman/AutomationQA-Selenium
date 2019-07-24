package BestPractices;

import BestPractices.Models.AccountData;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;

import java.util.HashMap;


@Listeners (TestListener.class)

public class BaseTest {
    protected WebDriver driver;
    protected WebDriverWait waiter;
    protected static final Logger LOGGER = LogManager.getLogger(BaseTest.class);
    DataPool dataPool;


    @BeforeClass
    public void beforeClassMethod(ITestContext testContext) {
        dataPool = new DataPool();
        HashMap<String,String> param = new HashMap<String, String>(testContext.getCurrentXmlTest().getAllParameters());
        dataPool.processDataFile( param.get(System.getProperty("dataFile")), AccountData.class);
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("http://automationpractice.com/index.php?controller=authentication&back=my-account");
        LOGGER.info("Beginning of the test");
    }

    @AfterClass
    public void afterClassMethod(){
        driver.close();
        LOGGER.info("Finish of logger");
    }
}
