package com.examples.pages;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;

import com.guru99.framework.Guru99WebDriverImpl;

import com.examples.cofig.GlobalDataStore;


public class Guru99LoginPage {

	Guru99WebDriverImpl driver;

    By user99GuruName = By.name("uid");

    By password99Guru = By.name("password");

    By titleText =By.className("barone");

    By login = By.name("btnLogin");
    By logout=By.linkText("Log out");
    By SignOutVerification=By.xpath("//td[@style='color: green']");
    

    
    public void setWebDriver(Guru99WebDriverImpl webDriver) {
		
		this.driver = webDriver;		
		
		
	}

    //Set user name in textbox

    public void setUserName(String strUserName){

        //driver.FindElement(user99GuruName).sendKeys(GlobalDataStore.UserName);
    	
        driver.sendKeys(driver.FindElement(user99GuruName), strUserName);

    }

    

    //Set password in password textbox

    public void setPassword(String strPassword){

        // driver.FindElement(password99Guru).sendKeys(GlobalDataStore.Password);
    	driver.sendKeys(driver.FindElement(password99Guru), strPassword);
    }

    

    //Click on login button

    public void clickLogin(){

            //driver.FindElement(login).click();
            driver.clickElement(driver.FindElement(login));
            

    }
    

    public String clickLogout(){

            //driver.FindElement(login).click();
            driver.clickElement(driver.FindElement(logout));
           String popUpText= driver.acceptPopAlert();
            return popUpText;

    }
    

    //Get the title of Login Page

    public String getLoginTitle(){

     //return  driver.FindElement(titleText).getText();
     return driver.getElementText(titleText);

    }

    public String getSignOutVerification(){

     return  driver.FindElement(SignOutVerification).getText();

    }
    

    /**

     * This POM method will be exposed in test case to login in the application

     * @param strUserName

     * @param strPasword

     * @return

     */

    public void loginToGuru99(String strUserName,String strPasword){

        //Fill user name

        this.setUserName(strUserName);

        //Fill password

        this.setPassword(strPasword);

        //Click Login button

        this.clickLogin();        

        

    }

}
