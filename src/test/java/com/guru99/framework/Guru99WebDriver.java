package com.guru99.framework;

import java.net.MalformedURLException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


public interface Guru99WebDriver {
	void init(String Browser);
	void intSauceLabs(String Chrome) throws MalformedURLException;
	
	Boolean navigateTo(final String relativeURL);
	 void sendKeys(WebElement element, String name);
	   
	   void clickElement(WebElement element);
	 
	   String getElementText(By element);
	 
	   WebElement FindElement(By element );
	   List<WebElement> findElements(By element);
	   //void acceptPopAlert();
	   String acceptPopAlert();
	    /**
	     * Quits the web driver.
	     */
	    void quitDriver();
	
	    //closes browser window    
	    void closeBrowser();
}
