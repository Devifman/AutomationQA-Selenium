package BestPractices;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.security.PublicKey;

public class RegPage {
    private WebDriver driver;

    public RegPage(WebDriver driver){
        this.driver = driver;
    }
    @FindBy(xpath = "//*[@id=\"id_gender1\"]")
    private WebElement genderTitle;

    @FindBy(xpath = "//*[@id=\"customer_firstname\"]")
    private WebElement firstNameField;

    @FindBy (xpath = "//*[@id=\"customer_lastname\"]")
    private WebElement lastNameField;

    @FindBy (xpath = "//*[@id=\"passwd\"]")
    private WebElement passwordField;

    @FindBy(xpath = "//*[@id=\"days\"]")
    private  WebElement days;

    @FindBy(xpath = "//*[@id=\"months\"]")
    private  WebElement months;

    @FindBy(xpath = "//*[@id=\"years\"]")
            private WebElement years;

    @FindBy(xpath = "//*[@id=\"newsletter\"]")
    private  WebElement newsletter;

    @FindBy(xpath = "//*[@id=\"optin\"]")
    private WebElement offers;

    @FindBy(xpath = "//*[@id=\"firstname\"]")
    private  WebElement addressFirstNameField;

    @FindBy(xpath = "//*[@id=\"lastname\"]")
    private  WebElement addressLastNameField;

    @FindBy(xpath = "//*[@id=\"address1\"]")
    private WebElement addressField;

    @FindBy(xpath = "//*[@id=\"address2\"]")
    private WebElement address2Field;

    @FindBy(xpath = "//*[@id=\"city\"]")
    private WebElement cityField;

    @FindBy( xpath = "//*[@id=\"id_state\"]")
    private  WebElement state;

    @FindBy (xpath = "//*[@id=\"postcode\"]")
    private WebElement zipCodeField;


    @FindBy(xpath = "//*[@id=\"other\"]")
    private WebElement additionalInfoField;

    @FindBy(xpath = "//*[@id=\"phone\"]")
    private WebElement homePhoneField;

    @FindBy(xpath = "//*[@id=\"phone_mobile\"]")
    private WebElement mobilephoneField;

    @FindBy (xpath = "//*[@id=\"alias\"]")
    private WebElement aliasAddressField;

    @FindBy(xpath = "//*[@id=\"company\"]")
    private WebElement companyField;

    @FindBy (xpath = "/html/body/div[1]/div[2]/div/div[3]/div/div/form/div[4]/button/span")
    private WebElement regButton;

    public void setGender(){
        genderTitle.click();
    }

    public void setFirstName(String name){
        firstNameField.sendKeys(name);
    }


    public void setSecondName(String secondName){
        lastNameField.sendKeys(secondName);
    }
    public void setPass(String pass){
        passwordField.sendKeys(pass);
    }

    public void setDateDay(){
        Select day = new Select(days);
        day.selectByValue("1");
    }

    public void setDateMonth(){
        Select month = new Select(months);
        month.selectByValue("1");
    }

    public void setDateYear(){
        Select year = new Select(years);
        year.selectByValue("1991");
    }
    public void addNewsLetter(){
        newsletter.click();
    }

    public void addOffers(){
        offers.click();
    }

    public void setFirstNameInAddressDiv(String nameAddress){
        addressFirstNameField.sendKeys(nameAddress);
    }

    public void setSecondNameInAddressDiv(String secondNameAddress){
        addressLastNameField.sendKeys(secondNameAddress);
    }

    public void setCompany(String companyName){
    companyField.sendKeys(companyName);
    }
    public void setAddress1(String address1){
        addressField.sendKeys(address1);
    }

    public void setAddress2(String address2){
        address2Field.sendKeys(address2);
    }

    public void setCity(String cityName){
        cityField.sendKeys(cityName);
    }
    public void setState(String userState){
        Select stateName = new Select(state);
        stateName.selectByValue(String.valueOf(userState));
    }

    public void setZipCode(String zip){
        zipCodeField.sendKeys(zip);
    }
    public void setAdditoinalInfo(String info){
        additionalInfoField.sendKeys(info);
    }

    public void setHomePhone(String homePhoneNumber){
        homePhoneField.sendKeys(homePhoneNumber);
    }

    public void setMobilePhone(String mobilePhoneNumber){
        mobilephoneField.sendKeys(mobilePhoneNumber);
    }
    public void setAlias(String aliasAddress){
        aliasAddressField.sendKeys(aliasAddress);
    }

    public void acceptRegistration(){
        regButton.click();
    }


}
