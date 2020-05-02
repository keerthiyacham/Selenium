package com.capgemini.flipkartproject.pageobject;

import org.testng.Assert;

import com.capgemini.flipkartproject.test.LoadingDataFromPropertiesFile;

public class HomePage extends LoadingDataFromPropertiesFile{
	
	public  void titleChecking() {

		String actualTitle = driver.getTitle();
		String expectedtitle = "Online Shopping Site for Mobiles, Electronics, Furniture, Grocery, Lifestyle, Books & More. Best Offers!";
		Assert.assertEquals(actualTitle, expectedtitle,"Unexpected Title");
	}

}
