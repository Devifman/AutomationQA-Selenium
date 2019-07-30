package BestPractices.Pages.Addresses;

import BestPractices.Models.AccountData;
import BestPractices.Pages.RegPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class AddNewAddress extends RegPage {
    WebDriver driver;
    public AddNewAddress(WebDriver driver){
        super(driver);
    }

    @FindBy(xpath = "//span[contains(text(),'Save')]")
    private WebElement save;


    @FindBy(css = "h3")
    List<WebElement> alias;

    @FindBy(xpath = "//span[contains(text(),'Add a new address')]")
    private  WebElement addNewAddress;

    @FindBy(css = "a[title = \"Update\"]")
    List<WebElement> updateButton;

    private boolean aliasExist(String alias, List<WebElement> webElements){
        for(WebElement web : webElements){
            if(alias.toUpperCase().compareTo(web.getText()) == 0){
                return true;
            }
        }
return false;

   }

   private ArrayList<String> arrayOfAlies;
    public void arrayOfAlies(AccountData accountData){
        for (int i = 0; i < accountData.getAddresses().size(); i++) {
            arrayOfAlies.add(accountData.getAddresses().get(i).getAlias());
        }
    }
    public void saveAddress(){
        save.click();
    }

    public void addNewAddress(AccountData accountData){
        arrayOfAlies(accountData);
        for (int i = 0; i < arrayOfAlies.size(); i++){
            aliasExist(accountData.getAddresses().get(i).getAlias(), alias);
            if (!aliasExist(accountData.getAddresses().get(i).getAlias(), alias)){
                addNewAddress.click();
                fillForm(getFirstNameAddress(),accountData.getAddresses().get(i).getAddressFirstName());
                fillForm(getLastNameAddress(),accountData.getAddresses().get(i).getAddressLastName());
                fillForm(getCompany(),accountData.getAddresses().get(i).getCompany());
                fillForm(getAdress1(),accountData.getAddresses().get(i).getAddress1());
                fillForm(getAdress2(),accountData.getAddresses().get(i).getAddress2());
                fillForm(getCity(),accountData.getAddresses().get(i).getCity());
                selectTextable(getState(),accountData.getAddresses().get(i).getState());
                fillForm(getZipCode(),accountData.getAddresses().get(i).getZipCode());
                selectTextable(getCountry(),accountData.getAddresses().get(i).getCountry());
                fillForm(getAdditionalInformation(),accountData.getAddresses().get(i).getInfo());
                fillForm(getHomePhone(),accountData.getAddresses().get(i).getHomePhone());
                fillForm(getMobilePhone(),accountData.getAddresses().get(i).getMobilePhone());
                fillForm(getAlias(),accountData.getAddresses().get(i).getAlias());
                saveAddress();




            }
        }
    }




}
