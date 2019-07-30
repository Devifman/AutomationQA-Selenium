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
import java.io.File;
import java.io.IOException;
import java.util.List;

@Data

public class AddressesPage extends RegPage {
    public AddressesPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(xpath = "//span[contains(text(),'Add a new address')]")
    private  WebElement addAddressButton;


    }

