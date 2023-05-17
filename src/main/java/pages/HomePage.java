package pages;

import drivers.DriverSingleton;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage {
    private WebDriver driver;

    public HomePage(){
        driver = DriverSingleton.getDriver();
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath ="//div/ul/li/a[contains(text(),'Login')]")
    WebElement signIn;

    @FindBy(xpath ="//div/ul/li/a[contains(text(),'Shop')]")
    WebElement shop;


    @FindBy(xpath ="//div/ul/li/a[contains(text(),'Hello, test1')]")
    WebElement username;

    public void clickOnSignIn(){
        WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(15));
        webDriverWait.until(ExpectedConditions.elementToBeClickable(signIn));
        signIn.click();
    }

    public void clickOnShopButton(){
        WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(15));
        webDriverWait.until(ExpectedConditions.elementToBeClickable(shop));
        shop.click();
    }

    public String getUsername(){
        return username.getText();
    }
}
