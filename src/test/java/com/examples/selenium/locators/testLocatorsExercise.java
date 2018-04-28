package com.examples.selenium.locators;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.examples.cofig.GlobalDataStore;

public class testLocatorsExercise {
   
	WebDriver driver=null;
	String baseUrl=null;
  @BeforeClass
  public void beforeClass() {

    
      }
  
  @Test
  public void testLocators() {
	  baseUrl = "file:///Users/srinivasnayani/Documents/SQAToolsAutomation/SQASeleniumProject/src/test/resources/locators.html";
	  System.setProperty("webdriver.gecko.driver","drivers/geckodriver");
	  driver = new FirefoxDriver();
	  driver.get(baseUrl);
	  driver.findElement((By.id("loginId"))).sendKeys("test@gmail.com");
         
  }
 
  
  @AfterClass
  public void afterClass() {
	driver.close();
      System.exit(0);
  }

}
