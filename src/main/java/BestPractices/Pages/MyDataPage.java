package BestPractices.Pages;

import BestPractices.Models.AccountData;
import BestPractices.Models.AddressessData;
import BestPractices.Models.UserData;
import lombok.Data;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;

@Data

public class MyDataPage extends RegPage {



    public MyDataPage(WebDriver driver){
        super(driver);
    }
    @FindBy(xpath = "//*[@id=\"firstname\"]")
    private WebElement firstname;

    @FindBy(xpath = "//*[@id=\"old_passwd\"]")
    private WebElement acceptPass;

    @FindBy (xpath = "\"//span[contains(text(),'Save')]")
    private WebElement save;


    @FindBy(xpath = "//p[@class='alert alert-success']")
    private WebElement successUpdate;


    public String getSuccessUpdate(){
        return successUpdate.getText();
    }
    public UserData getInformationAboutUser(){

        return new UserData(
                verifyGenderOfUser(),
                getAttribute(getFirstNameAddress()),
                getAttribute(getLastNameAddress()),
                getAttribute(getDay()),
                getAttribute(getMonth()),
                getAttribute(getYear())

        );
    }
    public AccountData getEmailOfUser(){

        return AccountData.accountDataBuilder(getAttribute(getEmail())).password("").userData(getInformationAboutUser()).addresses(new ArrayList<AddressessData>()).build();
    }

    public String verifyGenderOfUser(){
        if(getGenderMale().isSelected()){
            return getAttribute(getGenderMale());
        }
        else
            return getAttribute(getGenderFemale());
    }



    public boolean verifyEmail(AccountData accountData){
        return accountData.compareTo(getEmailOfUser()) == 0;
    }

    public boolean verifyOfFields(AccountData accountData){
        return accountData.getUserData().compareTo(getInformationAboutUser()) == 0;
    }

    public void changeInformationOfUser(AccountData previousData, AccountData accountData){
        accountData.getUserData().getGender();
        fillForm(getFirstNameAddress(), accountData.getUserData().getFirstName());
        fillForm(getLastNameAddress(), accountData.getUserData().getLastName());
        fillForm(getEmail(), accountData.getEmail());
        fillForm(acceptPass, accountData.getPassword());
        valueOfSelect(getDay(), accountData.getUserData().getDate());
        valueOfSelect(getMonth(), accountData.getUserData().getMonth());
        valueOfSelect(getYear(), accountData.getUserData().getYear());
    }
    public void saveNewData(){
        save.click();
    }




}



