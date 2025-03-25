package stepDefinitions;


import Factory.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import util.ConfigReader;

import java.io.IOException;
import java.util.Properties;


public class ApplicationHooks {

    ConfigReader config;
    private static Properties prop;
    DriverFactory driverfactory;
    WebDriver driver;

    @Before(order =0)
    public void get_properties() throws IOException {
        config = new ConfigReader();
        prop=config.init_prop();

    }

    @Before(order=1)
    public void launch_browser(){

        driverfactory = new DriverFactory();
        driver=driverfactory.init_driver(prop.getProperty("browser"));



    }

    @After(order=0)
    public void quit(){

        DriverFactory.getDriver().quit();
    }

    @After(order = 1)
    public void generateAllureReport() {
        try {
            ProcessBuilder builder = new ProcessBuilder(
                    "cmd", "/c", "allure.bat", "generate", "target/allure-results", "-o", "target/site/allure-report", "--clean"
            );
            Process process = builder.start();
            process.waitFor(); // Wait for the process to complete
            System.out.println("✅ Allure report generated successfully!");
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }



    public static Properties getProperties() {
        return prop;
    }
}
