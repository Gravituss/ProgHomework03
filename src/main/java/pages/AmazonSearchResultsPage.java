package pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AmazonSearchResultsPage {



    @FindBy(id = "low-price")
    private WebElement lowPriceField;
    @FindBy(id = "high-price")
    private WebElement highPriceField;
    @FindBy(xpath = "//*[@class='leftNavGoBtn']")
    private WebElement goBtn;

    @FindBy(xpath = ".//*[contains(@id,'result')]//span[contains(text(),'$')]")
    private WebElement goodPriceSpan;


    public void setPriceRange(int i, int j){
        String stLow = Integer.toString(i);
        lowPriceField.sendKeys(stLow);
        String stHigh = Integer.toString(j);
        highPriceField.sendKeys(stHigh);
        goBtn.click();


    }

    public Integer getIntFromWebElement(WebElement weToInt){
        Integer result = 0;
        String st = weToInt.getText();
        String to = "";
        for(int i = 0; i < st.length(); i++){
            if(Character.isDigit(st.charAt(i))){
                to = to + st.substring(i);
            }
        }
        result = result + Integer.valueOf(to);
        return result;
    }

    public void getPriceString(WebElement goodPrice){
        String priceString = goodPrice.getText();
    }

//    public void checkItemNotSponsored(){
//
//    }













}
