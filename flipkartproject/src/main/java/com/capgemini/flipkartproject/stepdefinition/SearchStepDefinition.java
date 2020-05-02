package com.capgemini.flipkartproject.stepdefinition;

import org.testng.annotations.Test;

import com.capgemini.flipkartproject.pageobject.HomePage;
import com.capgemini.flipkartproject.pageobject.LoginPage;
import com.capgemini.flipkartproject.pageobject.SearchBarPage;
import com.capgemini.flipkartproject.test.LoadingDataFromPropertiesFile;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

//to call the super class constructor and load the properties file
public class SearchStepDefinition extends LoadingDataFromPropertiesFile {

	SearchBarPage searchBarpage;
	LoginPage loginPage;
	HomePage homePage;

	@Test
	@Given("^User opens the browser$")
	public void user_opens_the_browser() {

		setUp();
	}

	@Test(dependsOnMethods = "user_opens_the_browser()")
	@When("^User enters Username and  Password$")
	public void User_enters_Username_and_Password() {

		loginPage = new LoginPage(driver);
		loginPage.loginDetails(pro.getProperty("username"), pro.getProperty("password"));
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	@Test
	@Then("^User is on home page$")
	public void User_is_on_home_page() {
		homePage = new HomePage();
		homePage.titleChecking();

	}

	@Test
	@Then("^search bar should enabled$")
	public void search_bar_should_enabled() {

		searchBarpage = new SearchBarPage(driver);
		searchBarpage.searchBoxChecking();
	}

	@Test(dependsOnMethods = "User_enters_Username_and_Password()")
	@Then("^User search for a product$")
	public void user_search_for_a_product() throws InterruptedException {
	
		searchBarpage = new SearchBarPage(driver);
		searchBarpage.searchingProduct(pro.getProperty("productName"));

	}

	@Test(dependsOnMethods = "user_search_for_a_product()")
	@Then("^User is on that product page$")
	public void user_is_on_that_product_page() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		searchBarpage = new SearchBarPage(driver);
		searchBarpage.gettingSearchedProductTitle();

	}

	@Test
	@Then("^close the browser$")
	public void close_the_browser() {
		tearDown();
	}
}
