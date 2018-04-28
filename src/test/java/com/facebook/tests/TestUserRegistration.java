package com.facebook.tests;

import org.testng.annotations.Test;
import com.examples.cofig.GlobalDataStore;
import com.examples.pages.FaceBookHomePage;
import com.examples.pages.FaceBookNewAccoutPage;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
public class TestUserRegistration {
	GlobalDataStore gds = new GlobalDataStore();
	String GecKoDriver;
	WebDriver driver=null;
	String HomePage;
	String ChromeDriver;
	FaceBookNewAccoutPage FBNewAccountPage;

	@Parameters({ "BrowserName" })
	@BeforeClass
	public void setUp(@Optional("FireFox") String BrowserName) {
		
       
		System.out.println(" The Browser Name "+BrowserName);
		gds.initParameters();
		GecKoDriver=GlobalDataStore.GeckoDriver_MAC;
		HomePage=GlobalDataStore.HomePage;
		System.out.println("The HomePage " +HomePage);
		System.out.println(" The GeckoDriver " +GecKoDriver);
	
		
		if(BrowserName.equalsIgnoreCase("firefox")){
			System.setProperty("webdriver.gecko.driver", GecKoDriver);
	          driver= new FirefoxDriver();
		}
	      
	    else if(BrowserName.equalsIgnoreCase("chrome")){
	    	
	    	System.out.println(" The chrome Driver " +GlobalDataStore.ChromeDriver_MAC);
	    System.setProperty("webdriver.chrome.driver",GlobalDataStore.ChromeDriver_WIN);
		ChromeOptions options = new ChromeOptions();
		options.addArguments("disable-infobars");
		options.addArguments("--start-maximized");
	          driver= new ChromeDriver(options);   
	          driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
	          //driver.navigate().to(HomePage);
	    }
   else if(BrowserName.equalsIgnoreCase("safari")){
	    	   
	          driver= new SafariDriver();   
	          driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
	          //driver.navigate().to(HomePage);
	    }
	}
	
  @Test
  public void testNewUserRegistration() {
	  driver.get(HomePage);
	  driver.manage().window().maximize();
	  FBNewAccountPage= new FaceBookNewAccoutPage(driver);
	  FBNewAccountPage.setFirstName("srini");
	  
	  
  }
  @AfterClass
  public void afterClass() {
	// close Fire fox
	//driver.close();

  }
}
