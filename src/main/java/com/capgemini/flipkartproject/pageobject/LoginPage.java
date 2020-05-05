package com.capgemini.flipkartproject.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	@FindBy(xpath = "(//input[@type='text'])[2]")
	private WebElement username;

	@FindBy(xpath = "//input[@type='password']")
	private WebElement password;

	@FindBy(xpath = "//button/span[.='Login']")
	private WebElement loginbtn;

	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public void loginDetails(String un, String pwd) {

		username.sendKeys(un);
		password.sendKeys(pwd);
		loginbtn.click();

	}

}
