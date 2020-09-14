package com.hooks.com;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.baseclass.BaseClass;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks extends BaseClass {

	public static Scenario scenario;

	@Before
	public void beforeHook(Scenario sce) {
		scenario = sce;

		System.out.println("before hook");
	}

	@After
	public void afterHook(Scenario sce) {
		if (sce.isFailed()) {
			TakesScreenshot ts = (TakesScreenshot) driver;
			byte[] screenshotAs = ts.getScreenshotAs(OutputType.BYTES);
			scenario.attach(screenshotAs, "image/png", "Test");
		}
		System.out.println("after hook");
	}
}
