package BestPractices;

import BestPractices.CreateAnAccountPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

public class testSusccessfullLogin {
    public static void main(String[] args){
        WebDriver driver = new ChromeDriver();

        driver.get("http://automationpractice.com/index.php");

        CreateAnAccountPage page = PageFactory.initElements(driver,CreateAnAccountPage.class);

        page.SignUpWith("Franky@lol.pow");
    }
}
