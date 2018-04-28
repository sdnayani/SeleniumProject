package com.facebook.tests;

//import java.nio.file.FileSystems;
//import java.nio.file.Path;

//import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
//import org.openqa.selenium.support.ui.ExpectedCondition;
//import org.openqa.selenium.support.ui.WebDriverWait;
//import org.openqa.selenium.firefox.FirefoxOptions;

import com.examples.cofig.GlobalDataStore;

public class FirefoxTest {
	

	public static void main(String[] args) {
      
		basicTest();
	}

	public static void basicTest() {
		GlobalDataStore gds = new GlobalDataStore();
	    gds.initParameters();
	    String GecKoDriver=GlobalDataStore.GeckoDriver_MAC;
		String HomePage=GlobalDataStore.HomePage;
		System.out.println("The HomePage " +HomePage);
		System.out.println(" The GeckoDriver " +GecKoDriver);
		//System.setProperty("webdriver.gecko.driver", "drivers/geckodriver");
		System.setProperty("webdriver.gecko.driver", GecKoDriver);
	     WebDriver driver = new FirefoxDriver();
		String baseUrl = "http://facebook.com";
		String expectedTitle = "Facebook - Log In or Sign Up";
		String actualTitle = "";
         
		// launch Fire fox and direct it to the Base URL
		driver.get(baseUrl);

		// get the actual value of the title
		actualTitle = driver.getTitle();
		String actualURL=driver.getCurrentUrl();
		System.out.println(" The URL "+actualURL);
		actualTitle=actualTitle.trim();
		System.out.println(" The actual Title " +actualTitle);

		/*
		 * compare the actual title of the page with the expected one and print
		 * the result as "Passed" or "Failed"
		 */
		if (actualTitle.contentEquals(expectedTitle)) {
			System.out.println("Test Passed!");
		} else {
			System.out.println("Test Failed");
		}

		// close Fire fox
		driver.close();

	}

}