package BestPractices.Pages;

import BestPractices.Models.AccountData;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.io.IOException;

public class UserAccount extends BasePage {
    public UserAccount(WebDriver driver){
        super(driver);
    }
    @FindBy(xpath = " //div[@class='columns-container']//li[3]")
    private WebElement addresses;

    @FindBy(xpath = "//div[@class='columns-container']//li[4]")
    private WebElement personalInformation;


    public void addressClick(){
        addresses.click();
    }

    public void personalInformationClick(){
        personalInformation.click();
    }

    public void addressEquals(){
        addressClick();
    }

    public void personalInfoEquals(){
        personalInformationClick();
    }

}
