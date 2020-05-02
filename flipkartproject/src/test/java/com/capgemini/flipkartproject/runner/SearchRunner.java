package com.capgemini.flipkartproject.runner;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(features = "./src/main/java/Feature/Search.feature", glue = {
		"com.capgemini.flipkartproject.stepdefinition" }, dryRun = false, // checks currently all steps defines properly
																			// or not (*without run)
		monochrome = true, plugin = { "pretty", "html:target/cucumber" }, // or we can use format instead of plugin
		strict = true, // checks currently all steps defines properly or not (*run)
		tags = "@SmokeTest")

//AbstractTestNGCucumberTests===Runs cucumber every detected feature as separated test

public class SearchRunner extends AbstractTestNGCucumberTests {

}
