package BestPractices.Pages.Addresses;

import BestPractices.Models.AccountData;
import BestPractices.Models.UserData;
import BestPractices.Pages.RegPage;
import BestPractices.Util.Config;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Data

public class AddressesPage extends RegPage {
    public AddressesPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(xpath = "//span[contains(text(),'Add a new address')]")
    private  WebElement addAddressButton;

    @FindBy(css = "a[title = \"Update\"]")
    List<WebElement> updateButtons;

    private ArrayList<String> arrayOfAlies = new ArrayList<>();

    public void addToAlisesArray(AccountData accountData) {
        for (int i = 0; i < accountData.getAddresses().size(); i++) {
            arrayOfAlies.add(accountData.getAddresses().get(i).getAlias());
        }
    }
    public boolean verifyAddOfAddresses(AccountData accountData) {
        addToAlisesArray(accountData);
        return (arrayOfAlies.size() == accountData.getAddresses().size()) ;
    }
    public void changeOfAddresses(AccountData accountData) {

        addToAlisesArray(accountData);

        for (int i = 0; i < arrayOfAlies.size(); i++) {

            updateButtons.get(i).click();

            fillForm(getFirstNameAddress(), accountData.getAddresses().get(i).getAddressFirstName());
            fillForm(getLastNameAddress(), accountData.getAddresses().get(i).getAddressLastName());
            fillForm(getCompany(), accountData.getAddresses().get(i).getCompany());
            fillForm (getAdress1(), accountData.getAddresses().get(i).getAddress1());
            fillForm(getAdress2(), accountData.getAddresses().get(i).getAddress2());
            fillForm(getCity(), accountData.getAddresses().get(i).getCity());
            selectTextable(getState(), accountData.getAddresses().get(i).getState());
            fillForm(getZipCode(), accountData.getAddresses().get(i).getZipCode());
            selectTextable(getCountry(), accountData.getAddresses().get(i).getCountry());
            fillForm(getAdditionalInformation(), accountData.getAddresses().get(i).getInfo());
            fillForm(getHomePhone(), accountData.getAddresses().get(i).getHomePhone());
            fillForm(getMobilePhone(), accountData.getAddresses().get(i).getMobilePhone());
            fillForm(getAlias(), accountData.getAddresses().get(i).getAlias());
            UpdateOfAddress updateOfAddress = PageFactory.initElements(driver, UpdateOfAddress.class);
            updateOfAddress.clickSave();
        }
    }



    }

