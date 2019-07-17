package BestPractices.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CreateAnAccountPage {
private WebDriver driver;
private WebDriverWait waiter;


public CreateAnAccountPage(WebDriver driver){
    this.driver = driver;
    this.waiter = new WebDriverWait(driver, 30);

}
@FindBy(xpath ="//*[@id='email_create']")
private WebElement emailAddressField;

@FindBy(xpath = "//form[@id='create-account_form']//span[1]")
private WebElement createAnAccountButton;

private WebElement findElement(By locator){
    return waiter.until(ExpectedConditions.visibilityOfElementLocated(locator));
}
public CreateAnAccountPage acceptAnEmail(String email){
    emailAddressField.sendKeys(email);
    return this;
}
public RegPage CreateAnAccount(){
    createAnAccountButton.click();
    RegPage regPage = PageFactory.initElements(driver,RegPage.class);
    return new RegPage(driver);
}

}
