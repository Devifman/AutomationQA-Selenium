package BestPractices.Pages;

import BestPractices.Models.AccountData;
import BestPractices.Util.Config;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.io.File;
import java.io.IOException;
import java.util.List;

@Data

public class AddressesPage extends RegPage {
    public AddressesPage(WebDriver driver){
        super(driver);
    }
    @FindBy(xpath = "//div[@class='addresses']//li[2]")
    List<WebElement> fullNameAddresses;
    @FindBy(xpath = "//div[@class='columns-container']//li[3]")
    List<WebElement> companiesAddresses;
    @FindBy(xpath = "//span[@class='address_address1']")
            List<WebElement> address1;
    @FindBy(xpath = "//span[@class='address_address2']")
    List<WebElement> address2;
    @FindBy(xpath = "//span[@class='address_phone']")
    List<WebElement> homePhoneAddresses;
    @FindBy(xpath = "//span[@class='address_phone_mobile']")
    List<WebElement> mobilePhoneAddresses;
@FindBy (xpath = "/html/body/div[1]/div[2]/div/div[3]/div/div[1]/div/div/ul/li[2]/span[1]")
    private WebElement firstNameAddressField;
    @FindBy (xpath = "/html/body/div[1]/div[2]/div/div[3]/div/div[1]/div/div/ul/li[2]/span[2]")
    private WebElement lastNameAddressField;
    @FindBy(xpath = "/html/body/div[1]/div[2]/div/div[3]/div/div[1]/div/div/ul/li[3]/span")
    private WebElement companyAddressField;
    @FindBy(xpath = "/html/body/div[1]/div[2]/div/div[3]/div/div[1]/div/div/ul/li[4]/span[1]")
    private WebElement addressLine1Field;
    @FindBy(xpath = "/html/body/div[1]/div[2]/div/div[3]/div/div[1]/div/div/ul/li[4]/span[2]")
    private WebElement addressLine2Field;
    @FindBy (xpath = "/html/body/div[1]/div[2]/div/div[3]/div/div[1]/div/div/ul/li[5]/span[1]")
    private WebElement cityAddressField;
    @FindBy (xpath = "/html/body/div[1]/div[2]/div/div[3]/div/div[1]/div/div/ul/li[5]/span[1]"                       )
    private WebElement stateField;
    @FindBy (xpath = "//*[@id=\"postcode\"]")
    private WebElement zipCodeField;
    @FindBy(xpath = "//*[@id=\"phone\"]")
    private WebElement homePhoneField;
    @FindBy (xpath = "//*[@id=\"phone_mobile\"]")
    private WebElement mobilePhoneField;
    @FindBy(xpath = "//p[@class='submit2']")
    private WebElement sumbit;
    @FindBy(xpath = "/html/body/div[1]/div[2]/div/div[3]/div/div[2]/a/span")
    private WebElement addNewAddress;

    public void seachForElement(List<WebElement> webElementList){
        for (WebElement webElement: webElementList){
            System.out.println(webElement.getText());
        }

    }

    public void addNewAddress(){
        addNewAddress.click();
    }

//    public boolean firstNameEquals(AccountData accountData){
//        return firstNameAddressField.getText().contentEquals(accountData.getFirstName());
//    }
//
//    public boolean lastNameEquals(AccountData accountData){
//        return lastNameAddressField.getText().contentEquals(accountData.getLastName());
//    }
//
//    public boolean companyEquals(AccountData accountData){
//        return companyAddressField.getText().contentEquals(accountData.getCompany());
//    }
//
//    public boolean addressLine1Equals(AccountData accountData){
//        return addressLine1Field.getText().contentEquals(accountData.getAddress1());
//    }
//
//    public boolean addressLine2Equals(AccountData accountData){
//        return addressLine2Field.getText().contentEquals(accountData.getAddress2());
//    }
//
//    public boolean cityEquals(AccountData accountData){
//        return cityAddressField.getText().contentEquals(accountData.getCity());
//    }
//
//    public boolean zipCodeEquals(AccountData accountData){
//        return zipCodeField.getText().contentEquals(accountData.getZipCode());
//    }
//
//    public boolean homePhoneEquals(AccountData accountData){
//        return homePhoneField.getText().contentEquals(accountData.getHomePhone());
//    }
//
//    public boolean mobilePhoneEquals(AccountData accountData){
//        return mobilePhoneField.getText().contentEquals(accountData.getMobilePhone());
//    }
//
//
//    public void clickSumbit(){
//        sumbit.click();
//    }
//
//
//
//    public void changeAddress(AccountData account) throws IOException{
//        ObjectMapper om = new ObjectMapper();
//        AccountData user = om.readValue( new File( Config.getJS() ), AccountData.class );
//
//        clickSumbit();
//        this.getAddressField().clear();
//        this.addressLine1Field.sendKeys(account.getAnotherAddress());
//    }


}
