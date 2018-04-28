package com.guru99.tests;
import java.net.URI;

//b9e514f0-4640-457c-bfee-97cb8a296749
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
 
import java.net.URL;




public class SampleSauceTest {

  public static final String USERNAME = "srini123";
  public static final String ACCESS_KEY = "b9e514f0-4640-457c-bfee-97cb8a296749";
  public static final String URL = "http://" + USERNAME + ":" + ACCESS_KEY + "@ondemand.saucelabs.com:80/wd/hub";

  public static void main(String[] args) throws Exception {

    DesiredCapabilities caps = DesiredCapabilities.chrome();
    caps.setCapability("platform", "mac");
    caps.setCapability("version", "63.0");


    //System.setProperty("webdriver.gecko.driver", "drivers/geckodriver");
    WebDriver driver = new RemoteWebDriver(new URL(URL), caps);
    /**
     * Goes to Sauce Lab's guinea-pig page and prints title
     */

    //driver.get("https://saucelabs.com/test/guinea-pig");
    driver.get("https:facebook.com");
    System.out.println("title of page is: " + driver.getTitle());
    
    driver.quit();
  }
}


