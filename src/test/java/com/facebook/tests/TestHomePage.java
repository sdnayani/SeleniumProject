package com.facebook.tests;

import org.testng.annotations.Test;
import com.examples.cofig.GlobalDataStore;
import com.examples.pages.FaceBookHomePage;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
//import org.openqa.selenium.firefox.F
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class TestHomePage {
 
	GlobalDataStore gds = new GlobalDataStore();
	String GecKoDriver;
	WebDriver driver=null;
	String HomePage;
	String ChromeDriver;
	FaceBookHomePage FBPage;
	/*
	 * Initilaizes the gecko driver object and all the variables needed.
	 *  
	 */
	@Parameters({ "BrowserName","HomePage" })
	@BeforeClass
	public void setUp(@Optional("FireFox") String BrowserName,String HomePage) {		
       System.out.println(" The BrowserName....");
		System.out.println(" The Browser Name "+BrowserName);
		gds.initParameters();
		GecKoDriver=GlobalDataStore.GeckoDriver_MAC;
		//HomePage=GlobalDataStore.HomePage;
		this.HomePage=HomePage;
		System.out.println("The HomePage " +HomePage);
		System.out.println(" The GeckoDriver " +GecKoDriver);
	
		
		if(BrowserName.equalsIgnoreCase("firefox")){
			System.setProperty("webdriver.gecko.driver", GecKoDriver);
	          driver= new FirefoxDriver();
		}
	      
	    else if(BrowserName.equalsIgnoreCase("chrome")){
	    	
	    	System.out.println(" The chrome Driver " +GlobalDataStore.ChromeDriver_MAC);
	    System.setProperty("webdriver.chrome.driver",GlobalDataStore.ChromeDriver_MAC);
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
  public void testFaceBookTitleOnPageLoad() {
	  
		//String baseUrl = "http://facebook.com";
		String expectedTitle = "Facebook - Log In or Sign Up";
		String actualTitle = "";
		
		FBPage= new FaceBookHomePage(driver);
		FBPage.launchHomePage(HomePage);
	     actualTitle=FBPage.getLoginTitle();
		Assert.assertEquals(actualTitle, expectedTitle);
  }
  
  @Test
  @Parameters({"sFirstName","sLastName"})
  public void testUserRegistration(String sFirstName, String sLastName) {
	  System.out.println(" The first Name " +sFirstName);
	  System.out.println("The Password "+sLastName);
	  FBPage= new FaceBookHomePage(driver);
	  FBPage.launchHomePage(HomePage);
	driver.findElement(By.name("firstname")).sendKeys(sFirstName);
	driver.findElement(By.name("lastname")).sendKeys(sLastName);
    driver.findElement(By.name("reg_email__")).sendKeys("888-99-8888");
    		
	Select sel1 = new Select(driver.findElement(By.xpath(".//*[@id='month']")));
		sel1.selectByVisibleText("Mar");
		Select sel2 = new Select(driver.findElement(By.xpath(".//*[@id='day']")));
		sel2.selectByValue("6");
		Select sel3 = new Select(driver.findElement(By.xpath(".//*[@id='year']")));
		sel3.selectByIndex(4);
		driver.findElement(By.name("reg_email__"));
		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//label[contains(text(), 'Female')]")));
		element.click();
		WebElement signUp = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(text(), 'Create Account')]")));
		signUp.click();
	    //driver.findElement(By.xpath("//button[contains(text(), 'Sign Up')]")).click();
		
		//wait.until(ExpectedConditions.visibilityOfElementLocated(
		//driver.findElement(By.xpath(".//*[@id='reg_pages_msg']/a")).click();
			//driver.navigate().back();
	 	
	}
  
  @Test
  @Parameters({"sUsername","sPassword"})
  public void testUserLogin(String sUsername, String sPassword){  
	  System.out.println(" The userName " +sUsername);
	  System.out.println("The Password "+sPassword);
	  FBPage= new FaceBookHomePage(driver);
		FBPage.launchHomePage(HomePage);
		//driver.findElement(By.xpath(".//input[@name='email']")).sendKeys(sUsername);
		driver.findElement(By.id("email")).sendKeys(sUsername);
		driver.findElement(By.id("pass")).sendKeys(sPassword);
		driver.findElement(By.xpath(".//input[@name='pass']")).sendKeys(sPassword);
		driver.findElement(By.name("email")).sendKeys(sUsername);
	    //driver.findElement(By.name("pass")).sendKeys(sPassword);
		driver.findElement(By.cssSelector("#email")).sendKeys(sUsername);
	    //driver.findElement(By.name("pass")).sendKeys(sPassword);
        
  }
  
  @Test
  public void verifyTextforCreateNewAccount(){
	  FBPage= new FaceBookHomePage(driver);
		FBPage.launchHomePage(HomePage);
		//driver.findElement(By.id("email")).
		//WebDriverWait wait = new WebDriverWait(driver, 10);
		//WebElement element = wait.until(ExpectedConditions.e(By.xpath("//div[contains(text(), 'Create a New Account')]")));
		//WebElement element=driver.findElement(By.xpath("//h2[contains(text(), 'Sign Up')]"));
		WebElement element1=driver.findElement(By.xpath("//div[contains(text(), \"What's your name?')]\""));
		////div[contains(text(), ' What\'s your name?')]
		System.out.println("The text " +element1.getText());
		
  }
  
  
  @Test
  public void VerifyClickLinkText(){
	  FBPage= new FaceBookHomePage(driver);
		FBPage.launchHomePage(HomePage);
		//driver.findElement(By.id("email")).
		WebDriverWait wait = new WebDriverWait(driver, 10);
		//WebElement element = wait.until(ExpectedConditions.e(By.xpath("//div[contains(text(), 'Create a New Account')]")));
		WebElement element=driver.findElement(By.linkText("Forgot account?"));
		element.click();
		////div[contains(text(), ' What\'s your name?')]
		//System.out.println("The text " +element.getText());
		
  }
  
  
  @AfterClass
  public void afterClass() {
	// close Fire fox
	//driver.close();

  }

}
