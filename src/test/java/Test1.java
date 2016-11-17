import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import pages.AmazonMainPage;
import pages.AmazonSearchResultsPage;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import java.text.NumberFormat;


public class Test1 {

    public static void main(String[] args) {

        final Integer MIN = 200;
        final Integer MAX = 250;

        System.setProperty("webdriver.gecko.driver", "C:\\pr\\gecko\\geckodriver.exe");
        WebDriver driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get("http://amazon.com");

        AmazonMainPage amazonMainPage = PageFactory.initElements(driver, AmazonMainPage.class);
        AmazonSearchResultsPage amazonSearchResultsPage = PageFactory.initElements(driver,
                AmazonSearchResultsPage.class);

        amazonMainPage.searchGood("Google Nexus");
        amazonSearchResultsPage.setPriceRange(MIN, MAX);

        AmazonSearchResultsPage amazonSearchResultsPage2 = PageFactory.initElements(driver,
                AmazonSearchResultsPage.class);
        driver.navigate().refresh();
        List<WebElement> listOfPrices = driver.findElements(
                By.xpath(".//*[contains(@id,'result')]//span[contains(text(),'$')]"));
        for(WebElement priceToCheck : listOfPrices){

            NumberFormat n = NumberFormat.getCurrencyInstance(Locale.US);

            if(amazonSearchResultsPage2.getIntFromWebElement(priceToCheck)!=0
                    &&(
                    amazonSearchResultsPage2.getIntFromWebElement(priceToCheck) < MIN*100
                    ||
                    amazonSearchResultsPage2.getIntFromWebElement(priceToCheck) > MAX*100
                    )
                    ){
                    long price = amazonSearchResultsPage2.getIntFromWebElement(priceToCheck);
                    String s = n.format(price);
                    System.out.println(s);
            }
        }
    }
}
