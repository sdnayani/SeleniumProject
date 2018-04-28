package com.guru99.tests;

import org.testng.annotations.Test;

import com.examples.cofig.GlobalDataStore;
import com.examples.pages.Guru99HomePage;
import com.examples.pages.Guru99LoginPage;
import com.guru99.framework.ExcelUtils;
import com.guru99.framework.Guru99WebDriverFactory;
import com.guru99.framework.Guru99WebDriverImpl;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import java.net.MalformedURLException;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;

public class TestGuru99LoginTests {
	final static Logger logger = Logger.getLogger("GURU99_LOGIN_TESTS");
	Guru99WebDriverImpl driver;
	GlobalDataStore gds = new GlobalDataStore();
     String BankHomePage;
    //Guru99Login objLogin;
     Boolean HomePageLaunch=false;
    Guru99HomePage objHomePage;
    Guru99LoginPage objLoginPage;
    String baseDir=null;
    String FilePath=null;
    
    @Parameters({ "BrowserName" })
   	@BeforeClass
   	public void setUp(@Optional("FireFox") String BrowserName) throws MalformedURLException  {
    	GlobalDataStore.setLogCategory("GURU99_LOGIN_TESTS");
    	gds.initParameters();
	     //calls the init Method in getWebDriverInstance and gets the WebDriverImpl Object driver..     
   driver = Guru99WebDriverFactory.getWebDriverInstance(BrowserName);
   BankHomePage=GlobalDataStore.Guru99HomePage;
  HomePageLaunch= driver.navigateTo(BankHomePage);
 // objHomePage= new Guru99HomePage(driver);
   //driver.get("http://demo.guru99.com/V4/");
  objHomePage= new Guru99HomePage();
  objHomePage.setLogCategory("GURU99_LOGIN_TESTS");
  objHomePage.setWebDriver(driver);
  objLoginPage=new Guru99LoginPage();
  objLoginPage.setWebDriver(driver);
  baseDir= System.getProperty("user.dir");
  FilePath=baseDir+ "/" +"src/test/resources/" +GlobalDataStore.TestDataFile;
  
    }
	
  @Test(dataProvider="Authentication")
  public void testGuru99Login(String sUserName,String sPassword) throws Exception {
	  logger.info("In Test Login Method ");
	  String loginTitle = null;
	  System.out.println(" The FilePath " +FilePath);
	  //ExcelUtils.setExcelFile(FilePath, "sheet1");	  
	  driver.navigateTo(BankHomePage);		  
	  logger.info(" The userName from Excel " +sUserName);
	  logger.info(" The password from Excel " +sPassword);
	  
	  objLoginPage.loginToGuru99(sUserName, sPassword);
	  loginTitle=objLoginPage.getLoginTitle();
	  System.out.println(" The logn Title " +loginTitle);    
	  Thread.sleep(2000);
	  
	  Assert.assertTrue(loginTitle.toLowerCase().contains("guru99 bank"));	  	  
  }
  
  @DataProvider
  public Object[][] Authentication() throws Exception{

       Object[][] testObjArray = ExcelUtils.getTableArray(FilePath,"Sheet1");

       return (testObjArray);

		}
  
  @Test
  public void testGuru99Logout() {
	  String strUserName=GlobalDataStore.UserName;
	  String strPassword=GlobalDataStore.Password;
	  String loginTitle = null;
	  System.out.println(" The user Name " +strUserName);
	  System.out.println(" The password " +strUserName);
	  if(HomePageLaunch==true){
	  objLoginPage.loginToGuru99(strUserName, strPassword);
	  }
	  String logOutText=objLoginPage.clickLogout();
	  System.out.println(" The logOut Text " +logOutText);
	  String generateAccess =objHomePage.getStepsToGenerateAccess();
      System.out.println(" The login Title " +generateAccess);
      
      Assert.assertTrue(generateAccess.contains("Steps To Generate Access"));
	  
	 
	  
  }

  @AfterClass
  public void afterClass() {
	 this.driver.quitDriver();
	  
  }

}
