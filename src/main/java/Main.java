import org.openqa.selenium.WebDriver;
import drivers.DriverSingleton;
import pages.HomePage;
import pages.SignInPage;
import utils.Constants;
import utils.FrameworkProperties;

public class Main {
    public static void main(String[] args) {
        FrameworkProperties frameworkProperties = new FrameworkProperties();
        DriverSingleton driverSingleton = DriverSingleton.getInstance(frameworkProperties.getProperty(Constants.BROWSER));
        WebDriver driver= DriverSingleton.getDriver();
        driver.get(Constants.URL);
        HomePage homePage = new HomePage();
        SignInPage signInPage = new SignInPage();
        homePage.clickOnSignIn();

        signInPage.login("test123",frameworkProperties.getProperty(Constants.PASSWORD));

        if(homePage.getUsername().equals("Hello, test1")){
            System.out.println("Test Passed");
        }
        else
            System.out.println("Test failed");
        DriverSingleton.closeObjectInstance();

    }
}
