package Factory;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class DriverFactory {

private WebDriver driver;

public static ThreadLocal<WebDriver> tDriver = new ThreadLocal<WebDriver>();
    public WebDriver init_driver(String browser){

 if(browser.equals("chrome")){
     System.out.println("The browser used to automate is "+browser);
     WebDriverManager.chromedriver().setup();
     tDriver.set(new ChromeDriver());
 }else if(browser.equals("firefox")){
     System.out.println("The browser used to automate is "+browser);
     WebDriverManager.firefoxdriver().setup();
     tDriver.set(new FirefoxDriver());
 }else{
            System.out.println("Please pass the correct browser value: " + browser);
        }
        getDriver().manage().deleteAllCookies();
        getDriver().manage().window().maximize();
        getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        return getDriver();

    }
    public static synchronized WebDriver getDriver(){
        return tDriver.get();
    }
}
