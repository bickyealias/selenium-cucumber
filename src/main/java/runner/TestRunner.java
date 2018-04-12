package runner;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;
import org.testng.annotations.AfterClass;
import setup.CreateDriver;

/**
 * Created by bicky on 4/10/2018.
 */
@RunWith(Cucumber.class)
@CucumberOptions(features = "src/main/java/features/test.feature",glue = "stepdefs",tags ="@BasicSearch" )
public class TestRunner {
@AfterClass()
public void quitdriver(){
    CreateDriver.getDriver().quit();
}

}
