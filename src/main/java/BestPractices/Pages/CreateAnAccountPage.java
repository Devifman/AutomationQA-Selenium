package BestPractices.Pages;

import BestPractices.Models.AccountData;
import lombok.Data;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
@Data
public class CreateAnAccountPage {
    private WebDriver driver;
    private WebDriverWait waiter;


    public CreateAnAccountPage(WebDriver driver) {
        this.driver = driver;
        this.waiter = new WebDriverWait(driver, 30);

    }

    @FindBy(xpath = "//*[@id='email_create']")
    private WebElement emailAddressField;

    @FindBy(xpath = "//form[@id='create-account_form']//span[1]")
    private WebElement createAnAccountButton;

    private WebElement findElement(By locator) {
        return waiter.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    @FindBy(xpath = "//*[@id=\"email\"]")
    private  WebElement loginEmail;

    @FindBy(xpath = "//*[@id=\"passwd\"]")
    private WebElement loginPassword;

    @FindBy(xpath = "/html/body/div[1]/div[2]/div/div[3]/div/div/div[2]/form/div/p[2]/button/span")
    private WebElement signIn;

    public CreateAnAccountPage acceptAnEmail(String email) {
        waiter.until(ExpectedConditions.elementToBeClickable(emailAddressField));
        emailAddressField.sendKeys(email);
        return this;
    }

    public RegPage CreateAnAccount() {
        createAnAccountButton.click();
        RegPage regPage = PageFactory.initElements(driver, RegPage.class);
        return new RegPage(driver);
    }

    public void selectEmail(String email){
        loginEmail.sendKeys(email);
    }

    public void selectPassword(String password){
        loginPassword.sendKeys(password);
    }

    public void acceptLogin(){
        signIn.click();
    }

    public void logIn(AccountData accountData){
        {
        selectEmail(accountData.getEmail());
        selectPassword(accountData.getPassword());
        acceptLogin();

        }


    }
public void startOfRegistration(AccountData accountData){

      acceptAnEmail(accountData.getEmail());
      CreateAnAccount();
}
}
