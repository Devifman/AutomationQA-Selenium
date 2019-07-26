package BestPractices.Pages;

import BestPractices.Models.AccountData;
import lombok.Data;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
@Data
public class RegPage extends BasePage {
    private WebDriver driver;

    public RegPage(WebDriver driver) {
        super(driver);
        WebDriverWait waiter = new WebDriverWait(driver, 15);
        waiter.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"id_gender1\"]")));
    }

    @FindBy(xpath = "//*[@id=\"id_gender1\"]")
    private WebElement genderTitle;

    @FindBy(xpath = "//*[@id=\"customer_firstname\"]")
    private WebElement firstNameField;

    @FindBy(xpath = "//*[@id=\"customer_lastname\"]")
    private WebElement lastNameField;

    @FindBy(xpath = "//*[@id=\"passwd\"]")
    private WebElement passwordField;

    @FindBy(xpath = "//*[@id=\"days\"]")
    private WebElement days;

    @FindBy(xpath = "//*[@id=\"months\"]")
    private WebElement months;

    @FindBy(xpath = "//*[@id=\"years\"]")
    private WebElement years;

    @FindBy(xpath = "//*[@id=\"newsletter\"]")
    private WebElement newsletter;

    @FindBy(xpath = "//*[@id=\"optin\"]")
    private WebElement offers;

    @FindBy(xpath = "//*[@id=\"firstname\"]")
    private WebElement addressFirstNameField;

    @FindBy(xpath = "//*[@id=\"lastname\"]")
    private WebElement addressLastNameField;

    @FindBy(xpath = "//*[@id=\"address1\"]")
    private WebElement addressField;

    @FindBy(xpath = "//*[@id=\"address2\"]")
    private WebElement address2Field;

    @FindBy(xpath = "//*[@id=\"city\"]")
    private WebElement cityField;

    @FindBy(xpath = "//*[@id=\"id_state\"]")
    private WebElement state;

    @FindBy(xpath = "//*[@id=\"postcode\"]")
    private WebElement zipCodeField;


    @FindBy(xpath = "//*[@id=\"other\"]")
    private WebElement additionalInfoField;

    @FindBy(xpath = "//*[@id=\"phone\"]")
    private WebElement homePhoneField;

    @FindBy(xpath = "//*[@id=\"phone_mobile\"]")
    private WebElement mobilephoneField;

    @FindBy(xpath = "//*[@id=\"alias\"]")
    private WebElement aliasAddressField;

    @FindBy(xpath = "//*[@id=\"company\"]")
    private WebElement companyField;

    @FindBy(xpath = "/html/body/div[1]/div[2]/div/div[3]/div/div/form/div[4]/button/span")
    private WebElement regButton;

    @FindBy (xpath = "//*[@id=\"colums\"]/div[1]")
    private WebDriver wrongData;

    public void selectGender() {
        genderTitle.click();
    }

    public void selectFirstName(String name) {
        firstNameField.sendKeys(name);
    }


    public void selectSecondName(String secondName) {
        lastNameField.sendKeys(secondName);
    }

    public void selectPass(String pass) {
        passwordField.sendKeys(pass);
    }

    public void selectDateDay() {
        Select day = new Select(days);
        day.selectByValue("1");
    }

    public void selectDateMonth() {
        Select month = new Select(months);
        month.selectByValue("1");
    }

    public void selectDateYear() {
        Select year = new Select(years);
        year.selectByValue("1991");
    }

    public void addNewsLetter() {
        newsletter.click();
    }

    public void addOffers() {
        offers.click();
    }

    public void selectFirstNameInAddressDiv(String nameAddress) {
        addressFirstNameField.sendKeys(nameAddress);
    }

    public void selectSecondNameInAddressDiv(String secondNameAddress) {
        addressLastNameField.sendKeys(secondNameAddress);
    }

    public void selectCompany(String companyName) {
        companyField.sendKeys(companyName);
    }

    public void selectAddress1(String address1) {
        addressField.sendKeys(address1);
    }

    public void selectAddress2(String address2) {
        address2Field.sendKeys(address2);
    }

    public void selectCity(String cityName) {
        cityField.sendKeys(cityName);
    }

    public void selectState(String userState) {
        Select stateName = new Select(state);
        stateName.selectByValue(String.valueOf(userState));
    }

    public void selectZipCode(String zip) {
        zipCodeField.sendKeys(zip);
    }

    public void setAdditoinalInfo(String info) {
        additionalInfoField.sendKeys(info);
    }

    public void selectHomePhone(String homePhoneNumber) {
        homePhoneField.sendKeys(homePhoneNumber);
    }

    public void selectMobilePhone(String mobilePhoneNumber) {
        mobilephoneField.sendKeys(mobilePhoneNumber);
    }

    public void selectAlias(String aliasAddress) {
        aliasAddressField.sendKeys(aliasAddress);
    }

    public void acceptRegistration() {
        regButton.click();
    }

    public String getWrongData(){
        return wrongData.getTitle();
    }


    public void registrationOfAccount(AccountData accountData){
        selectGender()    ;
        selectFirstName(accountData.getFirstName());
        selectSecondName(accountData.getLastName());
        selectPass(accountData.getPassword());
        selectFirstNameInAddressDiv(accountData.getFirstName());
        selectSecondNameInAddressDiv(accountData.getLastName());
        selectCompany(accountData.getCompany());

        selectAddress1(accountData.getAddress1());
        selectAddress2(accountData.getAddress2());
        selectCity(accountData.getCity());
        selectState(accountData.getState());
        selectZipCode(accountData.getZipCode());
        selectHomePhone(accountData.getHomePhone());
        selectMobilePhone(accountData.getMobilePhone());
        selectAlias(accountData.getAlias());
        acceptRegistration();
    }


}
