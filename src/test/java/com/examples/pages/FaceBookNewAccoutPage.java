package com.examples.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.examples.pageElements.RegistrationPageElements;


public class FaceBookNewAccoutPage {
	WebDriver driver;
	By FName = By.xpath(".//*[@id='email']");
	
	public FaceBookNewAccoutPage(WebDriver driver){

        this.driver = driver;

    }
	public void init() {
		
		PageFactory.initElements(this.driver, RegistrationPageElements.class);
	}
	
	public void setFirstName(String FirstName){

        driver.findElement(FName).sendKeys(FirstName);

    }


}
