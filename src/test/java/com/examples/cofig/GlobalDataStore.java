package com.examples.cofig;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Logger;

public class GlobalDataStore {
	private static Logger logger;
	private Properties configFile= new Properties();
	public static String HomePage;
	public static String Guru99HomePage;
	public static String UserName;
	public static String Password;
	public static String GeckoDriver_MAC;
	public static String GeckoDriver_WIN;
	public static String ChromeDriver_MAC;
	public static String ChromeDriver_WIN;
    public static String LogCategory;	
    public static String TestDataFile;
	/*
    * Initialize log4j Appenders.
    */
   public  static void setLogCategory(String LogFile) {

          LogCategory = LogFile;

           logger = Logger.getLogger(LogCategory);//

   }
	
	public  void initParameters(){
		
		//logger.info("START:Global Data Store initParameters Method");
		
		String baseDir= System.getProperty("user.dir");
		
		String propFile="selenium.properties";
		FileInputStream fis = null;
		
		
		try{
			
			///Users/srinivasnayani/Documents/SQAToolsAutomation/SQASeleniumProject/src/test/resources/selelium.properties
			fis=new FileInputStream(baseDir+ "/" +"src/test/resources/" +propFile);			
		    configFile.load(fis);
			
		    GeckoDriver_MAC=configFile.getProperty("GECKO_DRIVER_MAC");
		    //logger.info("GeckoDriver_MAC Value " +GeckoDriver_MAC);
		    GeckoDriver_WIN=configFile.getProperty("GECKO_DRIVER_WIN");
		    HomePage=configFile.getProperty("BASE_URL");
		    
		    ChromeDriver_MAC=configFile.getProperty("CHROME_DRIVER_MAC");
		    ChromeDriver_WIN=configFile.getProperty("CHROME_DRIVER_WIN");
		    Guru99HomePage=configFile.getProperty("GURU99_HOMEPAGE");
		    UserName=configFile.getProperty("USERNAME");
		    Password=configFile.getProperty("PASSWORD");
		    TestDataFile=configFile.getProperty("TEST_DATA_FILE");
	    }catch(FileNotFoundException e){
	    	
		System.out.println("File not Found" +e.getMessage());
		
	    }catch(IOException e){
	    	
		System.out.println("IO Exception " +e.getMessage());
		
	 }
		//logger.info("END:Global Data Store initParameters Method");
  }


}	
