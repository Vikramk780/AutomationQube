package runner;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

@CucumberOptions(features="@target/rerun.txt",
glue={"stepDefinitions"},
        plugin = {"pretty","html:target/RerunedCucumber-reports","rerun:target/rerun.txt"},
        monochrome = true,
        publish = true


)
public class TestRunnerForFailedCases extends AbstractTestNGCucumberTests {

    @Override
    @DataProvider(parallel = true)
    public Object[][] scenarios(){
        int maxThreads = 2; // Set the desired number of threads here
        System.setProperty("dataproviderthreadcount", String.valueOf(maxThreads));

        System.out.println("Running test in thread: " + Thread.currentThread().getId());
        return super.scenarios();
    }

}
