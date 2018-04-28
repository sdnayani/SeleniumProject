package com.examples.selenium.locators;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;

public class testLocators1 {
	WebDriver driver=null;
	String baseUrl=null;
  @BeforeClass
  public void beforeClass() {

    
      }
  
  @Test
  public void testLocators() {
	  baseUrl = "file:///Users/srinivasnayani/Documents/SQAToolsAutomation/SQASeleniumProject/src/test/resources/sample.html";
	  System.setProperty("webdriver.gecko.driver","drivers/geckodriver");
	  driver = new FirefoxDriver();
	  driver.get(baseUrl);
      //driver.findElement((By.id("email"))).sendKeys("test@gmail.com");
     // driver.findElement((By.name("firstname"))).sendKeys("Srini");
      driver.findElement((By.name("lastname"))).sendKeys("Nayani");
      driver.findElement(By.name("genderFemale")).click();
      //driver.findElement((By.xpath("//input[@id='email']"))).sendKeys("test@gmail.com");
      driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys("Srini");
     driver.findElement(By.cssSelector("input[id='email']")).sendKeys("test@gmail.com");
    
      //driver.findElement((By.linkText("Visit our HTML tutorial"))).click();
      //driver.findElement((By.partialLinkText("Visit"))).click();
      
       
  }
 
  
  @AfterClass
  public void afterClass() {
	//driver.close();
      //System.exit(0);
  }

}
