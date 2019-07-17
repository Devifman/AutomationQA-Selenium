package BestPractices;

import BestPractices.Pages.MainPage;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MainPageTest extends BaseTest {
    private MainPage mainPage;

    @Test()
    public void setMainPageTesting() {
        mainPage = PageFactory.initElements(driver, MainPage.class);
        String title = mainPage.getTitle();
            LOGGER.info("Title of the page is: " + title);
            Assert.assertEquals("My Store", title);
        }
    }

