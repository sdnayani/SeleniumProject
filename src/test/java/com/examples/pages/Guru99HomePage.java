package com.examples.pages;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.examples.cofig.GlobalDataStore;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.support.PageFactory;

import com.guru99.framework.Guru99WebDriverImpl;
//import com.examples.cofig.GlobalDataStore;

public class Guru99HomePage {

	Guru99WebDriverImpl driver;
	//public static WebElement element="//table//tr[@class='heading3']";
   // By homePageUserName = By.xpath("//table//tr[@class='heading3']");
	By homePageUserName = By.xpath("//h2[@class='barone']");
	By StepsToGenerateAccess=By.xpath("//h4[@class='barone']");
	By checkLinkToGenerateAccess=By.xpath("//a[@href='http://demo.guru99.com/']");
	By LoginButton=By.xpath("//input[@type='submit']");
	By ResetButton=By.xpath("//input[@type='reset']");
	By checkSeleniumDropDown=By.xpath("//ul[@class='nav navbar-nav']/li[1]/a[1]");
	//get all the siblings of li[1]
   By checkSiblings=By.xpath("//ul[@class='nav navbar-nav']/li[1]/ul/li[1]/following-sibling::li");
	//By checkSeleniumDropDownLinks=By.xpath("//ul[@class='nav navbar-nav']/li[1]/ul//a[contains(text(),'Flash')]");
	By checkSeleniumDropDownLinks1=By.xpath("//ul[@class='nav navbar-nav']/li[1]/ul//a[contains(text()");
	//Week6Day5
	By LoginText=By.xpath("//td[contains(text(),'UserID')]");
	// td:contains('UserID')
	// td:contains('UserID') 
	By Password=By.xpath("//td[contains(text(),'UserID')]//parent::tr/following-sibling::tr/td[contains(text(),'Password')]");
	By Login= By.xpath("//td[contains(text(),'UserID')]//parent::tr/following-sibling::tr//input[@type='submit']");
	By Reset=By.xpath("//td[contains(text(),'UserID')]//parent::tr/following-sibling::tr//input[@type='reset']");
	By h4StepsToGenerateAccess=By.xpath("//form[@name='frmLogin']//following-sibling::h4");
	By listOfElementsBelowStepsToGenerate=By.xpath("//form[@name='frmLogin']//following-sibling::h4//following-sibling::div//li");
	GlobalDataStore gds=new GlobalDataStore();
	WebDriver driverInstance;
    public static String LogCategory;
    public static Logger logger;

	   public  void setLogCategory(String LogFile) {

	          LogCategory = LogFile;

	           logger = Logger.getLogger(LogCategory);//

	   }

public void setWebDriver(Guru99WebDriverImpl webDriver) {
				logger.info("START:Set webDriver");
		this.driver = webDriver;		
		logger.info("END:Set webDriver");
		
		
	}

    //Get the User name from Home Page

    public String getHomePageDashboardUserName(){
    	logger.info("START: getHomePageDashboardUserName");
      System.out.println("comming here");    
      //System.out.println(" The Text "+driver.FindElement(homePageUserName).getText());
      logger.info("END: getHomePageDashboardUserName");
         return    driver.FindElement(homePageUserName).getText();
         //return driver.getElementText(homePageUserName);
        }
    
    public String getStepsToGenerateAccess(){
    	
     	logger.info("START: getStepsToGenerateAccess");
       
        //System.out.println(" The Text "+driver.FindElement(homePageUserName).getText());
          	   //driver.FindElement(homePageUserName).click();
     	logger.info("END: getStepsToGenerateAccess");
     	return driver.getElementText(StepsToGenerateAccess);
           //return    driver.FindElement(StepsToGenerateAccess).getText();

          }
    
    public Boolean checkTheLinkToGenerateAccountAccess(){
    	System.out.println("comming here in checkTheLinkToGenerateAccountAccess");
    	    return driver.FindElement(checkLinkToGenerateAccess).isEnabled();
    }
    public Boolean checkLoginButtonEnabled() {
	 	System.out.println("comming here in checkTheLinkToGenerateAccountAccess");
	    return driver.FindElement(LoginButton).isEnabled();
}
  
    public Boolean checkResetButtonEnabled(){
    	System.out.println("comming here in checkTheLinkToGenerateAccountAccess");
    	
    	    return driver.FindElement(ResetButton).isEnabled();
    }

    public void clickSeleniumDropDownOnPage(){
    	   WebElement element= driver.FindElement(checkSeleniumDropDown);
    	   
    		   driver.clickElement(element);
    		    
    		   
    	   }
    public int getCountOfAllLinks(){
    	WebElement element= driver.FindElement(checkSeleniumDropDown);
 	   
		   driver.clickElement(element);
		    List<WebElement>elements= driver.findElements(checkSiblings);
		    System.out.println("The elements Size " +elements.size());
		    return elements.size();
    	
    }
    
    public void clickSeleniumSelectElementFromDropDownOnPage(String Text){
   String Path= 	"//ul[@class='nav navbar-nav']/li[1]/ul//a[contains(text()," + "'"+Text+ "'" +")]";
   By checkText=By.xpath(Path);
 	   WebElement element= driver.FindElement(checkText);
 		   driver.clickElement(element);
 	   }
    
        public Boolean init() {
    		
    		   		
    		   gds.initParameters();
    		   String TestPage=GlobalDataStore.HomePage;
    	       	  
    	       System.out.println("The test page is "+TestPage);
    	     
        	   Boolean mainPageFound=this.driver.navigateTo(TestPage);
        	
        	    return mainPageFound;
         
        
        }
//week6Day5
        
        public String  getTheTextForUserID(){
        	     //return driver.FindElement(LoginText).getText();
        	     return driver.getElementText(LoginText);
        }
	
}