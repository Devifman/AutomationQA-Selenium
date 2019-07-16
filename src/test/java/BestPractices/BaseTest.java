package BestPractices;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.util.logging.Logger;

public class BaseTest {
    private static final Logger LOGGER = Logger.getLogger(RegistrationTest.class.getName());
    WebDriver driver;

    @BeforeClass
    public void beforeClassMethod() {
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("http://automationpractice.com/index.php?controller=authentication&back=my-account");
        LOGGER.info("Begining of the test");
    }

    @AfterClass
    public void afterClassMethod(){
        driver.close();
        LOGGER.info("Finish of logger");
    }
}
