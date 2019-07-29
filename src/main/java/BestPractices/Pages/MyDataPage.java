package BestPractices.Pages;

import BestPractices.Models.AccountData;
import BestPractices.Models.UserData;
import BestPractices.Util.Config;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.io.File;
import java.io.IOException;
import java.util.logging.Logger;

@Data

public class MyDataPage extends RegPage {



    public MyDataPage(WebDriver driver){
        super(driver);
    }
    @FindBy(xpath = "//*[@id=\"firstname\"]")
    private WebElement firstname;

    @FindBy(xpath = "//*[@id=\"old_passwd\"]")
    private WebElement acceptPass;

    @FindBy (xpath = "/html/body/div[1]/div[2]/div/div[3]/div/div/form/fieldset/div[11]/button/span")
    private WebElement save;


    @FindBy(xpath = "/html/body/div[1]/div[2]/div/div[3]/div/div/p")
    private WebElement successUpdate;


//    public void saveUpdates(){
//        save.click();
//    }
//
//    public boolean genderEquals(AccountData accountData){
//        return (this.getGenderTitle().getAttribute("someValue")).contentEquals(accountData.getGender());
//    }
//
//    public boolean nameEquals(AccountData accountData){
//        return (this.getFirstNameField().getAttribute("someValue")).contentEquals(accountData.getFirstName());
//    }
//
//    public boolean secondNameEquals(AccountData accountData){
//        return (this.getLastNameField().getAttribute("someValue")).contentEquals(accountData.getLastName());
//    }
//
//    public boolean changeInformation(AccountData accountData) throws IOException {
//        ObjectMapper om = new ObjectMapper();
//        UserData account = om.readValue(new File(Config.getJS()),UserData.class);
//        this.getFirstNameField().sendKeys(account.getFirstName());
//        this.getLastNameField().sendKeys(account.getLastName());
//        //acceptPass.sendKeys(account.getPassword());
//        saveUpdates();
//return successUpdate.isDisplayed();
//
//    }
}
