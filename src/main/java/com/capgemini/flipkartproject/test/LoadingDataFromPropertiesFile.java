package com.capgemini.flipkartproject.test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoadingDataFromPropertiesFile {

	// to visible or use in all classes making as public

	public static Properties pro;
	public static WebDriver driver;

	public LoadingDataFromPropertiesFile() {

		try {
			pro = new Properties();
			FileInputStream fis = new FileInputStream(
					"E:\\Flipkart Parallel Project\\flipkartproject\\src\\test\\resources\\flipkartproject\\testdata\\testdata.properties");
			pro.load(fis);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	
	public static void setUp() {

		System.setProperty("webdriver.chrome.driver", "./src/main/resources/chromedriver.exe");
		driver = new ChromeDriver();

		driver.get(pro.getProperty("url"));

		// driver.manage().window().maximize();

		driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		
	
		

	}

	public static void tearDown() {

		driver.close();
	}
	
	
}
