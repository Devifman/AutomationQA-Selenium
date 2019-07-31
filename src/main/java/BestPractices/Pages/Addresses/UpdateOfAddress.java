package BestPractices.Pages.Addresses;

import BestPractices.Models.AccountData;
import BestPractices.Pages.RegPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class UpdateOfAddress extends RegPage {


    public UpdateOfAddress(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = " //span[contains(text(),'Save')]")
    private WebElement saveButton;

    private boolean aliasIsExist(String alias, List<WebElement> webElements) {
        for (WebElement web : webElements) {
            if (alias.toUpperCase().compareTo(web.getText()) == 0) {
                return true;
            }
        }
        return false;


    }

    private ArrayList<String> arrayOfAlies = new ArrayList<>();

    public void setArrayOfAlies(AccountData accountData) {
        for (int i = 0; i < accountData.getAddresses().size(); i++) {
            arrayOfAlies.add(accountData.getAddresses().get(i).getAlias());
        }
    }
    public void clickSave() {
        saveButton.click();
    }
}
