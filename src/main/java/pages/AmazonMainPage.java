package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class AmazonMainPage {


    private WebDriver driver;


    public AmazonMainPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }




    @FindBy(id = "twotabsearchtextbox")
    private WebElement searchField;
    @FindBy(xpath = "//input[@type='submit']")
    private WebElement searchBtn;

    public void searchGood (String good){
        searchField.sendKeys(good);
        searchBtn.click();
    }
}
