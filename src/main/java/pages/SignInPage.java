package pages;

import drivers.DriverSingleton;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Utils;

public class SignInPage {
    private WebDriver driver;

   public SignInPage(){
        driver = DriverSingleton.getDriver();
       PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//input[@name='xoo-el-username']")
    WebElement signInEmail;

    @FindBy(xpath = "//input[@name='xoo-el-password']")
    WebElement password;

    @FindBy(xpath = "//button[normalize-space()='Sign In']")
    WebElement signInButton;


    public void login(String email, String password){
        signInEmail.sendKeys(email);
        this.password.sendKeys(Utils.decode64(password));
        signInButton.click();
    }
}
