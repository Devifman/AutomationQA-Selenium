package BestPractices;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CreateAnAccountPage {
private WebDriver driver;
private WebDriverWait waiter;
private By emailLocator = By.xpath("//*[@id=\"email_create\"]");
private By createAnAccountButton = By.xpath("/html/body/div[1]/div[2]/div/div[3]/div/div/div[1]/form/div/div[3]/button/span");

public CreateAnAccountPage(WebDriver driver){
    this.driver = driver;
    this.waiter = new WebDriverWait(driver, 30);

}
public void SignUpWith(String email){
    WebElement emailField = findElement(emailLocator);
    emailField.click();
    emailField.sendKeys(email);
    WebElement signUp = findElement(createAnAccountButton);
    signUp.click();
}
private WebElement findElement(By locator){
    return waiter.until(ExpectedConditions.visibilityOfElementLocated(locator));
}

}
