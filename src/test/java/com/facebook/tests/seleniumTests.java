package com.facebook.tests;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
public class seleniumTests {
	
	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException{
		//This particular statement will initiate a firefox browser.
	    driver=new FirefoxDriver();
		driver.get("http://www.facebook.com");
		driver.manage().window().maximize();
		driver.findElement(By.xpath(".//*[@id='email']")).sendKeys("test@gmail.com");
		
		driver.findElement(By.xpath(".//*[@id='pass']")).sendKeys("test123");
		
		//driver.findElement(By.xpath(".//*[@id='u_0_6']")).sendKeys("test@gmail.com");
		//driver.findElement(By.xpath(".//*[@id='pass']")).sendKeys("test123");
		//driver.findElement(By.xpath(".//*[@id='u_0_4']")).click();
		//driver.findElement(By.xpath(".//*[@id='u_0_o']")).click();
		
		Select sel1 = new Select(driver.findElement(By.xpath(".//*[@id='month']")));
		sel1.selectByVisibleText("Mar");
		Select sel2 = new Select(driver.findElement(By.xpath(".//*[@id='day']")));
		sel2.selectByValue("6");
			Select sel3 = new Select(driver.findElement(By.xpath(".//*[@id='year']")));
			sel3.selectByIndex(4);
			driver.findElement(By.xpath(".//*[@id='reg_pages_msg']/a")).click();
			driver.navigate().back();
		//driver.close();
		
	}
	
	@Test
	@Parameters({"sUsername","sPassword"})
	public void testUserLogin(String sUsername, String sPassword){
		driver=new FirefoxDriver();
		driver.get("http://www.facebook.com");
		driver.manage().window().maximize();
		driver.findElement(By.xpath(".//*[@id='email']")).sendKeys(sUsername);
		
		driver.findElement(By.xpath(".//*[@id='pass']")).sendKeys(sPassword);
		
		//driver.findElement(By.xpath(".//*[@id='u_0_6']")).sendKeys("test@gmail.com");
		//driver.findElement(By.xpath(".//*[@id='pass']")).sendKeys("test123");
		//driver.findElement(By.xpath(".//*[@id='u_0_4']")).click();
		//driver.findElement(By.xpath(".//*[@id='u_0_o']")).click();
		
		Select sel1 = new Select(driver.findElement(By.xpath(".//*[@id='month']")));
		sel1.selectByVisibleText("Mar");
		Select sel2 = new Select(driver.findElement(By.xpath(".//*[@id='day']")));
		sel2.selectByValue("6");
			Select sel3 = new Select(driver.findElement(By.xpath(".//*[@id='year']")));
			sel3.selectByIndex(4);
			driver.findElement(By.xpath(".//*[@id='reg_pages_msg']/a")).click();
			driver.navigate().back();
		
		
	}
}
