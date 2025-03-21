package runner;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

@CucumberOptions(features="src/test/resources/features",
glue={"stepDefinitions"},
        plugin = {"pretty","html:target/cucumber-reports"},
        monochrome = true,
        publish = true

)
public class TestRunner extends AbstractTestNGCucumberTests {

    @Override
    @DataProvider(parallel = true)
    public Object[][] scenarios(){
        int maxThreads = 2; // Set the desired number of threads here
        System.setProperty("dataproviderthreadcount", String.valueOf(maxThreads));

        System.out.println("Running test in thread: " + Thread.currentThread().getId());
        return super.scenarios();
    }

}
