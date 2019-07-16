package BestPractices;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BasePage {
    private WebDriver driver;
    public BasePage(WebDriver driver){
        this.driver = driver;

    }
    @FindBy(xpath = "/html/body/div[1]/div[1]/header/div[2]/div/div/nav/div[1]/a")
    private WebElement logIn;

    @FindBy(xpath = "/html/body/div[1]/div[1]/header/div[2]/div/div/nav/div[2]/a")
    private WebElement logOut;

    public void clickLogIn(){
        logIn.click();
    }

    public void clickLogOut(){
        logOut.click();
    }

    public String getTitle(){
        return driver.getTitle();
    }

}
