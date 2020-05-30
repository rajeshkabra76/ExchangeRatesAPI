package runners;

import java.io.File;

import org.testng.annotations.AfterSuite;


import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;


@CucumberOptions(
 features = "src/test/resources/Features", glue = {"stepDefinitions"}, tags = {"@OrangeHRM_PIM, @OrangeHRM_Recruitment"},
		 plugin = {"com.cucumber.listener.ExtentCucumberFormatter:target/cucumber-reports/report.html"}
 )
public class TestRunner extends AbstractTestNGCucumberTests {
	
	/*
	 * @Override
	 * 
	 * @DataProvider(parallel = true) public Object[][] features(){ return
	 * super.features(); }
	 */
	
	
	@AfterSuite
	public static void writeExtentReport() {
		
	}

}
