import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import pages.AmazonMainPage;

import java.util.concurrent.TimeUnit;


public class Test1 {

    public static void main(String[] args) {
        System.setProperty("webdriver.gecko.driver", "C:\\pr\\gecko\\geckodriver.exe");
        WebDriver driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get("http://amazon.com");

        AmazonMainPage amazonMainPage = PageFactory.initElements(driver, AmazonMainPage.class);

        amazonMainPage.searchGood("Google Nexus");




    }
}
