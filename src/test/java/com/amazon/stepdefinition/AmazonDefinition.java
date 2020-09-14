package com.amazon.stepdefinition;

import org.junit.Assert;

import com.amazon.pom.HomePage;
import com.amazon.utils.SingletonManager;
import com.baseclass.BaseClass;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AmazonDefinition extends BaseClass {
	
	SingletonManager s= new SingletonManager();

	@Given("User login the application")
	public void user_login_the_application() {
		System.out.println("Background");
	}

	@When("User should enter Keyword {string} in the search box")
	public void user_should_enter_Keyword_in_the_search_box(String string) {
		elementIsDisplayed(s.getHp().getAmazonText());
		sendkeys(s.getHp().getSearchBox(), string);
//Hooks.scenario.em
	}

	@Then("User should click on search button")
	public void user_should_click_on_search_button() {
		clickOnElement(s.getHp().getSearchButton());

	}

	@Then("User should see {string} in the result")
	public void user_should_see_in_the_result(String string) throws InterruptedException {

		elementIsDisplayed(s.getHp().getSearchText());
		try {
			String ssearchText = s.getHp().getSearchText().getText();
			Thread.sleep(3000);
			Assert.assertEquals(string, ssearchText.substring(1, ssearchText.length() - 1));
			highlightWebElement_green(s.getHp().getSearchText());
		} catch (Exception e) {
			highlightWebElement_red(s.getHp().getSearchText());
		}

	}

}
