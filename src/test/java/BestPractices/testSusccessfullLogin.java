package BestPractices;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

public class testSusccessfullLogin {
    public static void main(String[] args){
        WebDriver driver = new ChromeDriver();

        driver.get("http://automationpractice.com/index.php");

        CreateAnAccountTest page = PageFactory.initElements(driver, CreateAnAccountTest.class);

        page.SignUpWith("Franky@lol.pow");
    }
}
