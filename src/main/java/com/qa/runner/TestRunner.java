package com.qa.runner;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.CucumberFeatureWrapper;
import cucumber.api.testng.TestNGCucumberRunner;

// To fix Cucumber Advanced Reports option.......

//https://github.com/naveenanimation20/Cucumber-TestNG (Location for the Pom.xml and other code.


@CucumberOptions(
        //features = "src/main/java/Features",
        features = "C:\\TEST Automation - Selenium Java\\eclipse-workspace\\Om_Sai_Ram_PDF_REPORT _and_OtherRnd\\src\\main\\java\\com\\qa\\features\\1_Order_Tops.feature",
		glue = {"com/qa/stepDefinitions"},
        //tags = {"~@Ignore"},
		/*
		 * format = { "pretty", "html:target/cucumber-reports/cucumber-pretty",
		 * "json:target/cucumber-reports/CucumberTestReport.json",
		 * "rerun:target/cucumber-reports/rerun.txt" },
		 */
		
		//plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
		/*
		 * plugin = {"pretty",
		 * "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
		 * "timeline:test-output-thread/" },
		 */
		 
		  plugin = "json:target/cucumber-reports/CucumberTestReport.json",
        		
          monochrome = true,  //Monochrome displays the console output in a proper readable format.
          strict = true, // Strict will fail the Execution of the Test case, if mapping is not defined for it.
          dryRun = false
          )


			public class TestRunner {
				private TestNGCucumberRunner testNGCucumberRunner;

				@BeforeClass(alwaysRun = true)
				public void setUpClass() throws Exception 
				{
					testNGCucumberRunner = new TestNGCucumberRunner(this.getClass());
				}

				@Test(groups = "cucumber", description = "Runs Cucumber Feature", dataProvider = "features")
				public void feature(CucumberFeatureWrapper cucumberFeature)
				{
					testNGCucumberRunner.runCucumber(cucumberFeature.getCucumberFeature());
				}

				
				  @DataProvider // this Dataprovider is not related to Excel data. It is used to run "Multiple // Features files" one by one. 
				  public Object[][] features()
				  { 
					  return testNGCucumberRunner.provideFeatures();
				  }
				 
				 

				
				
				@AfterClass(alwaysRun = true)
				public void tearDownClass() throws Exception {
					testNGCucumberRunner.finish();
				}
			}