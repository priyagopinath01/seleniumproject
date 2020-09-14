package com.amazon.pom;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.baseclass.BaseClass;

public class HomePage extends BaseClass {

	
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//span[@class='nav-sprite nav-logo-base']")
	private WebElement amazonText;
	
	@FindBy(id="twotabsearchtextbox")
	private WebElement searchBox;
	
	@FindBy(xpath="//input[@type='submit']")
	private WebElement searchButton;
	
	@FindBy(xpath="//span[@class='a-color-state a-text-bold']")
	private WebElement searchText;
	
	public WebElement getSearchText() {
		return searchText;
	}

	public WebElement getAmazonText() {
		return amazonText;
	}

	public WebElement getSearchBox() {
		return searchBox;
	}

	public WebElement getSearchButton() {
		return searchButton;
	}
	
	
}
