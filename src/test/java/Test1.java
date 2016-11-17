import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import pages.AmazonMainPage;
import pages.AmazonSearchResultsPage;

import java.util.concurrent.TimeUnit;


public class Test1 {

    public static void main(String[] args) {
        System.setProperty("webdriver.gecko.driver", "C:\\pr\\gecko\\geckodriver.exe");
        WebDriver driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get("http://amazon.com");

        AmazonMainPage amazonMainPage = PageFactory.initElements(driver, AmazonMainPage.class);
        AmazonSearchResultsPage amazonSearchResultsPage = PageFactory.initElements(driver, AmazonSearchResultsPage.class);

        amazonMainPage.searchGood("Google Nexus");
        amazonSearchResultsPage.setPriceRange(200, 250);






    }
}
