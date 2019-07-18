package BestPractices.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.security.cert.X509Certificate;

public class AddressesPage extends RegPage {
    public AddressesPage(WebDriver driver){
        super(driver);
    }
@FindBy (xpath = "/html/body/div[1]/div[2]/div/div[3]/div/div[1]/div/div/ul/li[2]/span[1]")
    private WebElement firstNameAddressField;
    @FindBy (xpath = "/html/body/div[1]/div[2]/div/div[3]/div/div[1]/div/div/ul/li[2]/span[2]")
    private WebElement lastNameAddressField;
    @FindBy(xpath = "/html/body/div[1]/div[2]/div/div[3]/div/div[1]/div/div/ul/li[3]/span")
    private WebElement companyAddressField;
    @FindBy(xpath = "/html/body/div[1]/div[2]/div/div[3]/div/div[1]/div/div/ul/li[4]/span[1]")
    private WebElement addressLine1;
    @FindBy(xpath = "/html/body/div[1]/div[2]/div/div[3]/div/div[1]/div/div/ul/li[4]/span[2]")
    private WebElement addressLine2;
    @FindBy (xpath = "/html/body/div[1]/div[2]/div/div[3]/div/div[1]/div/div/ul/li[5]/span[1]")
    private WebElement cityAddressField;
    @FindBy (xpath = "/html/body/div[1]/div[2]/div/div[3]/div/div[1]/div/div/ul/li[5]/span[1]" +
            "")
    private WebElement stateField;
    @FindBy (xpath = "//*[@id=\"postcode\"]")
    private WebElement zipCodeField;
    @FindBy(xpath = "//*[@id=\"phone\"]")
    private WebElement homePhoneField;
    @FindBy (xpath = "//*[@id=\"phone_mobile\"]")
    private WebElement mobilePhoneField;
    @FindBy(xpath = "//p[@class='submit2']")
    private WebElement sumbit;
}
