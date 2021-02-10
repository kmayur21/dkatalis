package com.dkatalis.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * Class for Initializing the variables and setting up of environment.
 *
 * @author Mayur.Kumbhar
 */

public class TestBase {

/**
 * All the initialization will occurs in this class
 * WebDriver
 * Properties files
 * Logs
 * ExtentReport
 * DB
 * Excel
 * Mail
 * 
 */

	public static WebDriver driver;
	
	public static Properties config=new Properties();
	
	public static FileInputStream fis;
	public static Logger log=Logger.getLogger("TestBase");
	public  ExtentReports extent;
	public ExtentHtmlReporter HTMLreporter;
	public ExtentTest test;
	
	
	/**
	 * Method for setting up the environment.
	 */
	@BeforeSuite
	public void setUp()
	{
		if(driver==null)
		{
			try {
					fis=new FileInputStream("C:\\Users\\Mayur\\eclipse-workspace1\\com.dkatalis.midtrans\\src\\test\\resources\\properties\\Config.properties");
					try {
						config.load(fis);
						PropertyConfigurator.configure("Log4j.properties");
						log.debug("Config File Loaded");
					} catch (IOException e) {
						System.out.println("Unable to load Config File...");
						e.printStackTrace();
					}
				
			} catch (FileNotFoundException e) {
				
				log.debug("File not Found on Specified Location");
				e.printStackTrace();
			}
		
			if(config.getProperty("TEST.CONFIG.BROWSER").equals("chrome"))
			{
				System.setProperty("webdriver.chrome.silentOutput", "true");
				
				WebDriverManager.chromedriver().setup();;
				driver=new ChromeDriver();
				log.debug("browser Launched ....");
			}
		
			else if (config.getProperty("browser").equals("firefox"))
			{
				WebDriverManager.firefoxdriver().setup();
				log.info("launching firefox browser");
				driver=new FirefoxDriver();
				log.info("Firefox browser Launched..");
			}
		
		driver.manage().window().maximize();
		driver.get(config.getProperty("TEST.CONFIG.APPLICATIONURL"));
		driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
		}
		
	}
	
	
	@AfterSuite
	public void tearDown()
	{
		if(driver!=null)
			driver.quit();
		log.info("Execution Completed...");
	}


	
}
