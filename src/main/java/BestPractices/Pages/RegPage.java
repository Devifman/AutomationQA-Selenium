package BestPractices.Pages;

import BestPractices.Models.AccountData;
import lombok.Data;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

@Data
public class RegPage extends BasePage {
    public RegPage (WebDriver driver) {
        super(driver);
    }
    private ArrayList<WebElement> elements = new ArrayList<>();
    private ArrayList<String> errors = new ArrayList<>();
    @FindBy(css = "div.alert li")
    List<WebElement> userErrors;

    @FindBy(xpath = "//input[@id='id_gender1']")
    private WebElement genderMale;

    @FindBy(xpath = "//input[@id='id_gender2']")
    private WebElement genderFemale;

    @FindBy(xpath = "//input[@id='customer_firstname']")
    private WebElement firstName;

    @FindBy(xpath = "//*[@id=\"customer_lastname\"]")
    private WebElement lastName;

    @FindBy(xpath = "//input[@id='email']")
    private WebElement email;

    @FindBy(xpath = "//input[@id='passwd']")
    private WebElement password;

    @FindBy(xpath = "//select[@id='days']")
    private WebElement day;

    @FindBy(xpath = "//select[@id='months']")
    private WebElement month;

    @FindBy(xpath = "//select[@id='years']")
    private WebElement year;


    @FindBy(xpath = "//input[@id='firstname']")
    private WebElement firstNameAddress;

    @FindBy(xpath = " //input[@id='lastname']")
    private WebElement lastNameAddress;

    @FindBy(xpath = "//input[@id='company']")
    private WebElement company;

    @FindBy(xpath = "//*[@id=\"address1\"]")
    private WebElement adress1;

    @FindBy(xpath = "//*[@id=\"address2\"]")
    private WebElement adress2;

    @FindBy(xpath = "//*[@id=\"city\"]")
    private WebElement city;

    @FindBy(xpath = "//select[@id='id_state']")
    private WebElement state;

    @FindBy(xpath = "//input[@id='postcode']")
    private WebElement zipCode;

    @FindBy(xpath = "//select[@id='id_country']")
    private WebElement country;

    @FindBy(xpath = "//*[@id=\"other\"]")
    private WebElement additionalInformation;

    @FindBy(xpath = "//*[@id=\"phone\"]")
    private WebElement homePhone;

    @FindBy(xpath = "//*[@id=\"phone_mobile\"]")
    private WebElement mobilePhone;

    @FindBy(xpath = "//*[@id=\"alias\"]")
    private WebElement alias;

    @FindBy(xpath = "//*[@id=\"submitAccount\"]/span")
    private WebElement regButton;

    @FindBy(xpath = "//*[@id=\"columns\"]/div[1]")
    private WebElement wrongData;

    public void fillPageElementsList(){
        elements.add(genderMale);
        elements.add(genderFemale);
        elements.add(firstName);
        elements.add(lastName);
        elements.add(email);
        elements.add(password);
        elements.add(day);
        elements.add(month);
        elements.add(year);
        elements.add(firstNameAddress);
        elements.add(lastNameAddress);
        elements.add(company);
        elements.add(adress1);
        elements.add(adress2);
        elements.add(city);
        elements.add(state);
        elements.add(zipCode);
        elements.add(country);
        elements.add(additionalInformation);
        elements.add(homePhone);
        elements.add(mobilePhone);
        elements.add(alias);
        elements.add(regButton);
    }
public void CreateOfAccount(AccountData accountData){
accountData.getUserData().getGender();
fillForm(firstName,accountData.getUserData().getFirstName());
fillForm(lastName,accountData.getUserData().getLastName());
fillForm(email,accountData.getEmail());
fillForm(password,accountData.getPassword());
valueOfSelect(day,accountData.getUserData().getDate());
valueOfSelect(month,accountData.getUserData().getMonth());
valueOfSelect(year,accountData.getUserData().getYear());
fillForm(company,accountData.getAddresses().get(0).getCompany());
fillForm(adress1,accountData.getAddresses().get(0).getAddress1());
fillForm(adress2,accountData.getAddresses().get(0).getAddress2());
fillForm(city,accountData.getAddresses().get(0).getCity());
selectTextable(state,accountData.getAddresses().get(0).getState());
fillForm(zipCode,accountData.getAddresses().get(0).getZipCode());
fillForm(country,accountData.getAddresses().get(0).getCountry());
fillForm(additionalInformation,accountData.getAddresses().get(0).getInfo());
fillForm(homePhone,accountData.getAddresses().get(0).getHomePhone());
fillForm(mobilePhone,accountData.getAddresses().get(0).getMobilePhone());
regButton.click();



}

    }



