package BestPractices.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class BasePage {
    public WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;

    }

    @FindBy(xpath = "/html/body/div[1]/div[1]/header/div[2]/div/div/nav/div[1]/a")
    private WebElement logIn;

    @FindBy(xpath = "/html/body/div[1]/div[1]/header/div[2]/div/div/nav/div[2]/a")
    private WebElement logOut;

    @FindBy(xpath = "/html/body/div[1]/div[1]/header/div[2]/div/div/nav/div[1]/a/span")
    private WebElement userAccount;

    public void clickLogIn() {
        logIn.click();
    }

    public void clickLogOut() {
        logOut.click();
    }

    public String getTitle() {
        return driver.getTitle();
    }

    public void clickAccount(){
        userAccount.click();
    }

    public void selectTextable(WebElement webElement, String text){
        Select droplist = new Select(webElement);
        //webElement.click();
        droplist.selectByVisibleText(String.valueOf(text));
    }

    public void fillForm(WebElement webElement, String text){
        webElement.clear();
        webElement.sendKeys(text);
    }


    public void valueOfSelect(WebElement webElement, String value){
        Select dropList = new Select(webElement);
        //webElement.click();
        dropList.selectByValue(String.valueOf(value));
    }

    public void selectOption(WebElement webElement, boolean o){
        if(!webElement.isSelected() && o){
           webElement.click();
        }
        else if(webElement.isSelected() && !o){
            webElement.click();
        }
    }

    public String getAttribute(WebElement webElement){
        return webElement.getAttribute("value");
    }

    public String getError(WebElement webElement){
        return webElement.getText();
    }

    public boolean visible(WebElement webElement){
        return webElement.isDisplayed();
    }

    public boolean enableElement(WebElement webElement){
        return webElement.isEnabled();
    }

}
