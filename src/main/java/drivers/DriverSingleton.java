package drivers;

import drivers.strategies.DriverStrategy;
import drivers.strategies.DriverStrategyImplementer;
import org.openqa.selenium.WebDriver;

import java.time.Duration;

public class DriverSingleton {

    private static  DriverSingleton instance = null;
    private static WebDriver driver;

    private DriverSingleton (String key){

        instantiate(key);
    }
    public WebDriver instantiate(String string){

        DriverStrategy driverStrategy = DriverStrategyImplementer.chooseStrategy(string);
        assert driverStrategy != null;
        driver = driverStrategy.setStrategy();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();
        return driver;
    }

    public static  DriverSingleton getInstance(String key){

        if (instance==null){
            instance = new DriverSingleton(key);
        }
        return instance;
    }
    public static void closeObjectInstance(){
        instance = null;
        driver.quit();
    }

   public static WebDriver getDriver(){
        return driver;
    }

}
