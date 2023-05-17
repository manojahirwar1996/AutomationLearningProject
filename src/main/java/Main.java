import org.openqa.selenium.WebDriver;
import drivers.DriverSingleton;
import pages.HomePage;
import pages.SignInPage;
import utils.FrameworkProperties;

public class Main {
    public static void main(String[] args) {
        FrameworkProperties frameworkProperties = new FrameworkProperties();
        DriverSingleton driverSingleton = DriverSingleton.getInstance(frameworkProperties.getProperty("browser"));
        WebDriver driver= DriverSingleton.getDriver();
        driver.get("https://bitheap.tech");
        HomePage homePage = new HomePage();
        SignInPage signInPage = new SignInPage();
        homePage.clickOnSignIn();
        signInPage.login("test123","123456");

        if(homePage.getUsername().equals("Hello, test1")){
            System.out.println("Test Passed");
        }
        else
            System.out.println("Test failed");
        DriverSingleton.closeObjectInstance();

    }
}
