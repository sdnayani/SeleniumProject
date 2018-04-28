package com.examples.selenium.locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.Assert;

public class assertTable  {
	
	WebDriver driver=null;
	String baseUrl=null;
	@BeforeClass
	public void setUp() throws Exception {
		//System.setProperty("webdriver.gecko.driver","drivers/geckodriver");
	  	//WebDriver driver = new FirefoxDriver();
	   //baseUrl = "file:///Users/srinivasnayani/Documents/SQAToolsAutomation/SQASeleniumProject/src/test/resources/selenium.html";
	}

	@Test
	public void testAssertTable() throws Exception {
	System.setProperty("webdriver.gecko.driver","drivers/geckodriver");
    	 driver = new FirefoxDriver();
    //String baseUrl = "file:///Users/srinivasnayani/Documents/SQAToolsAutomation/SQASeleniumProject/src/test/resources/selenium.html";
    	 //String baseUrl ="/Users/srinivasnayani/Documents/SQAToolsAutomation/SQASeleniumProject/selenium.html";
    	 String baseUrl="file:///Users/srinivasnayani/Documents/SQAToolsAutomation/SQASeleniumProject/selenium.html";
    	 String tagName = "";
		System.out.println(" The base Url " +baseUrl);
		driver.get(baseUrl);
		String Text=driver.findElement(By.xpath("//table[1]//tr[2]/td[1]")).getText();
		////table[@id='firstTable']//tr[2]/td[1]
		//String Text1=driver.findElement(By.xpath("//table[@id='firstTable']//tr[2]/td[1]")).getText();
		String result = driver.findElement(By.xpath("//table[@id='firstTable']//td[contains(text(),'BillGates')]")).getText();
		//int result = driver.findElement(By.xpath("//table[@id='firstTable']//td[contains(text(),'BillGates')]//ancestor::tr").
		Assert.assertEquals("BillGates", result);
		//Assert.assertEquals("BillGates", Text);
	}

	@AfterClass
	public void tearDown() throws Exception {
		//driver.close();
	      //System.exit(0);
	}
}
