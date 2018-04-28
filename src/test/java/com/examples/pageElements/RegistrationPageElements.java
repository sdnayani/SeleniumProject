package com.examples.pageElements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class RegistrationPageElements {
	//private static TMXWebDriver driver;
		//private static WebDriver driver1;
		@FindBy(how = How.XPATH, using = ".//*[@id='email']")
		public static By txtbx_UserName;
		
}
