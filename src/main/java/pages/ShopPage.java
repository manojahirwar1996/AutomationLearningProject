package pages;

import drivers.DriverSingleton;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShopPage {
    private WebDriver driver;

    public ShopPage(){
        driver = DriverSingleton.getDriver();
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath =" a[aria-label='Add “[Ebook] Chatbot Development - From 0 to Hero” to your cart']")
    WebElement addToCart ;
    @FindBy()
    WebElement numberOfProducts;
    @FindBy()
    WebElement cartButton;

}
