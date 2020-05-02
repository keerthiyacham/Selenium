package com.capgemini.flipkartproject.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.capgemini.flipkartproject.test.LoadingDataFromPropertiesFile;

public class SearchBarPage extends LoadingDataFromPropertiesFile{
	

	@FindBy(xpath = "//input[@type='text']")
	WebElement searchBar;

	@FindBy(xpath = "//button[@type='submit']")
	WebElement searchSubmit;

	
	// initializing page objects
	public SearchBarPage(WebDriver driver) {

		PageFactory.initElements(driver, this);
	}

	

	public void searchBoxChecking() {

		boolean box = searchBar.isEnabled();
		Assert.assertTrue(box, "Search box not present");
	}

	public void searchingProduct(String testData) throws InterruptedException {

		searchBar.sendKeys(testData);
		searchSubmit.click();
		

	}

	public void gettingSearchedProductTitle()  {

		
		String actualTitle = "Shoes - Buy Products Online at Best Price in India - All Categories | Flipkart.com";
		driver.navigate().refresh();
		String expectedTitle = driver.getTitle();
		Assert.assertEquals(actualTitle, expectedTitle, "Unexpected Title");

	}

}
