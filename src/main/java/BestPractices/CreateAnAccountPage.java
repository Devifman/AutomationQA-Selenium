package BestPractices;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
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

@FindBy(xpath = "/html/body/div[1]/div[2]/div/div[3]/div/div/div[1]/form/div/div[3]/button/span")
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
    return new RegPage(driver);
}

}
