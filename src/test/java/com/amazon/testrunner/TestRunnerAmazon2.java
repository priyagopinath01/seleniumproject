package com.amazon.testrunner;

import com.baseclass.BaseClass;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import com.amazon.utils.CucumberJVMReport;
import com.amazon.utils.LoadProperties;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(plugin = { "pretty", "json:src\\test\\resource\\com\\reports\\cucumber-report2.json",
		"junit:src\\test\\resource\\com\\reports\\cucumber-report2.xml",
		"html:src\\test\\resource\\com\\reports\\cucumber-report2.html" }, features = "src\\test\\java\\com\\amazon\\features\\Amazon.feature", glue = {
				"com.amazon.stepdefinition", "com.hooks.com" })
public class TestRunnerAmazon2 extends BaseClass {
	public static WebDriver driver;

	@BeforeClass
	public static void user_should_launch_the_application() throws Exception {
		try {
			driver = getBrowser("chrome");
			getUrl("https://www.amazon.in/");

		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception();
		}
	}

	@AfterClass
	public static void driverQuit() {
		driver.quit();
		CucumberJVMReport.getReport();
	}

	// 3 steps -> 1. dependency 2. add java code - json part and output path
	// 3rs - call that java class at after class in test runner

}
