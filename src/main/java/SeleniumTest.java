import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SeleniumTest {
    public ChromeDriver driver;

    @BeforeClass
    public void setup() {
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();

    }

    @Test
    public void firstTest() {
        driver.get("http://automationpractice.com/index.php");
        driver.findElement(By.xpath("/html/body/div[1]/div[1]/header/div[2]/div/div/nav/div[1]/a")).click();
        driver.findElement(By.xpath("//*[@id=\"email_create\"]")).sendKeys("example219@example.com");
        driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div[3]/div/div/div[1]/form/div/div[3]/button/span")).
                click();
        WebDriverWait waiter = new WebDriverWait(driver,15);
        waiter.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"id_gender1\"]")));
        driver.findElement(By.xpath("//*[@id=\"id_gender1\"]")).click();
        driver.findElement(By.xpath("//*[@id=\"customer_firstname\"]")).sendKeys("TeddyBoy");
        driver.findElement(By.xpath("//*[@id=\"customer_lastname\"]")).sendKeys("Red");
        driver.findElement(By.xpath("//*[@id=\"passwd\"]")).sendKeys("12345");
        Select days = new Select(driver.findElement(By.xpath("//*[@id=\"days\"]")));
        days.selectByValue("1");
        Select months = new Select(driver.findElement(By.xpath("//*[@id=\"months\"]")));
        months.selectByValue("1");
        Select years = new Select(driver.findElement(By.xpath("//*[@id=\"years\"]")));
        years.selectByValue("1997");
        driver.findElement(By.xpath("//*[@id=\"firstname\"]")).sendKeys("Tedd");
        driver.findElement(By.xpath("//*[@id=\"lastname\"]")).sendKeys("Red");
        driver.findElement(By.xpath("//*[@id=\"company\"]")).sendKeys("Google");
        driver.findElement(By.xpath("//*[@id=\"address1\"]")).sendKeys("55 Avenue");
        driver.findElement(By.xpath("//*[@id=\"address2\"]")).sendKeys("H2Ap1");
        driver.findElement(By.xpath("//*//*[@id=\"city\"]")).sendKeys("Boston");
        Select state = new Select(driver.findElement(By.xpath("//*[@id=\"id_state\"]")));
        state.selectByValue("3");
        driver.findElement(By.xpath("//*[@id=\"postcode\"]")).sendKeys("00000");
        driver.findElement(By.xpath("//*[@id=\"phone_mobile\"]")).sendKeys("8800131454");
        driver.findElement(By.xpath("//*[@id=\"alias\"]")).sendKeys("Myhouse");
        WebDriverWait waiter2 = new WebDriverWait(driver,20);
        waiter2.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[1]/div[2]/div/div[3]/div/div/form/div[4]/button/span")));
        driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div[3]/div/div/form/div[4]/button/span")).click();
        driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div[3]/div/div/div[1]/ul/li[4]/a/span")).click();


    }
}
