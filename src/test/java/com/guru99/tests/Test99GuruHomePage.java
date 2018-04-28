package com.guru99.tests;

import java.net.MalformedURLException;

import org.apache.log4j.Logger;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
//import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.examples.pages.Guru99HomePage;

import com.examples.pages.Guru99LoginPage;
import com.guru99.framework.Guru99WebDriverFactory;
import com.guru99.framework.Guru99WebDriverImpl;
import com.examples.cofig.GlobalDataStore;

public class Test99GuruHomePage {
	final static Logger logger = Logger.getLogger("GURU99_TESTS");

	Guru99WebDriverImpl driver;
	GlobalDataStore gds = new GlobalDataStore();
     String BankHomePage;
    Guru99LoginPage objLogin;
     Boolean HomePageLaunch=false;
    Guru99HomePage objHomePage;


    @Parameters({ "BrowserName" })
	@BeforeClass
	public void setUp(@Optional("FireFox") String BrowserName) throws MalformedURLException {
    	    logger.info("START: In set-up Method");
    	    GlobalDataStore.setLogCategory("GURU99_TESTS");
    	    gds.initParameters();
    	     //calls the init Method in getWebDriverInstance and gets the WebDriverImpl Object driver..   
        driver = Guru99WebDriverFactory.getWebDriverInstance(BrowserName);       
        BankHomePage=GlobalDataStore.Guru99HomePage;
       HomePageLaunch= driver.navigateTo(BankHomePage);
      // objHomePage= new Guru99HomePage(driver);
        //driver.get("http://demo.guru99.com/V4/");
       objHomePage= new Guru99HomePage();
       objHomePage.setLogCategory("GURU99_TESTS");
       objHomePage.setWebDriver(driver);
       
       
       
       logger.info("END: In set-up Method");
    }
 
    /**
     * This Test verifies the DashBoard Page...It confirms that Page is launched successfully.
     * 
     */
    @Test
    public void test_Home_Page_DashBoard_UserName(){
    	
    	logger.info("START: test_Home_Page_DashBoard_UserName");
    	objHomePage.setLogCategory("GURU99_TESTS");
    	
    	  if(HomePageLaunch==true){
    	
            String loginPageTitle =objHomePage.getHomePageDashboardUserName();
            logger.info(" The login Title " +loginPageTitle); 
            Assert.assertTrue(loginPageTitle.toLowerCase().contains("guru99 bank"));
    	  }
    	  logger.info("END: test_Home_Page_DashBoard_UserName");

   // Assert.assertTrue(objHomePage.getHomePageDashboardUserName().toLowerCase().contains("manger id : mgr123"));

    }
    
    @Test
    public void test_Home_Page_DashBoard_StepsToGenerateAccess(){
    	logger.info("START: test_Home_Page_DashBoard_StepsToGenerateAccess");
    	objHomePage.setLogCategory("GURU99_TESTS");
    	  if(HomePageLaunch==true){
            String stepsToGenerateAcccess =objHomePage.getStepsToGenerateAccess();
            System.out.println(" The login Title " +stepsToGenerateAcccess);
            
            Assert.assertTrue(stepsToGenerateAcccess.toLowerCase().contains("steps to generate access"));
    	  }
    	  logger.info("END: test_Home_Page_DashBoard_StepsToGenerateAccess");

   // Assert.assertTrue(objHomePage.getHomePageDashboardUserName().toLowerCase().contains("manger id : mgr123"));

    }
    @Test
    public void test_Home_Page_DashBoard_checkLinkStepsToGenerateAccess(){

    	  if(HomePageLaunch==true){
            Boolean stepsToGenerateAcccess =objHomePage.checkTheLinkToGenerateAccountAccess();
            System.out.println(" Does the Link Exists " +stepsToGenerateAcccess);
            
            Assert.assertTrue(stepsToGenerateAcccess);
    	  }

   // Assert.assertTrue(objHomePage.getHomePageDashboardUserName().toLowerCase().contains("manger id : mgr123"));

    }
    
    @Test
    public void test_Home_Page_DashBoard_checkLoginButtonEnabled(){

  	  if(HomePageLaunch==true){
          Boolean isLoginButtonEnabled =objHomePage.checkLoginButtonEnabled();
          System.out.println(" Does the Login Button Exists " +isLoginButtonEnabled);
          
          Assert.assertTrue(isLoginButtonEnabled);
  	  }
    }
    
    @Test
  	public void test_Home_Page_DashBoard_checkResetButtonEnabled(){

    	  if(HomePageLaunch==true){
    		  
       Boolean isResetButtonEnabled =objHomePage.checkResetButtonEnabled();
       System.out.println(" Does the Reset Buttton Exists " +isResetButtonEnabled);            
       Assert.assertTrue(isResetButtonEnabled);
    	  }
 // Assert.assertTrue(objHomePage.getHomePageDashboardUserName().toLowerCase().contains("manger id : mgr123"));
  }
    @Test
  	public void test_Home_Page_DashBoard_clickSeleniumDropDown_CheckMenu(){

    	  if(HomePageLaunch==true){
    		  
       objHomePage.clickSeleniumDropDownOnPage();
       objHomePage.clickSeleniumSelectElementFromDropDownOnPage("Flash");
       String Url=driver.getCurrentUrl();
       Url=Url.trim();
       System.out.println(" The url " +Url);
       String ExpectedUrl="http://demo.guru99.com/test/flash-testing.html";
       Assert.assertEquals(Url, ExpectedUrl);
       //System.out.println(" Does the Reset Buttton Exists " +isResetButtonEnabled);            
       //Assert.assertTrue(isResetButtonEnabled);
    	  }
 // Assert.assertTrue(objHomePage.getHomePageDashboardUserName().toLowerCase().contains("manger id : mgr123"));
  }
   
    
    
    @Test
    public void testGuru99TextItems(){
    	
    	logger.info("START: testGuru99TextItems");
    	if(HomePageLaunch==true){
    		
    		String userID=objHomePage.getTheTextForUserID();
    		logger.info("The userID " +userID);
    		System.out.println("The userID " +userID);
    		Assert.assertEquals(userID.trim(), "UserID");
    		
    	}
    	logger.info("END: testGuru99TextItems");
    }
    
    @AfterClass
	public void teardown() {

    	// user logout
   this.driver.quitDriver();
	}

    
    
}