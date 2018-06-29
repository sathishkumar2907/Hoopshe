package com.hoopshe.tests;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.hoopshe.utils.Constants;


public class TestBase {

	// Create the Global Objects
	public static Logger APPLICATION_LOGS = null;
	public static Properties CONFIG = null;
	public WebDriver driver = null;

	// Initialize Configuration
	public void initConfig() {
		APPLICATION_LOGS = Logger.getLogger(TestBase.class);

		CONFIG = new Properties();
		try {
			FileInputStream input = new FileInputStream(Constants.PROPERTIES_FILE_PATH);
			// load a properties file
			CONFIG.load(input);
		} catch (Exception e) {
			e.printStackTrace();
			APPLICATION_LOGS.debug("Error", e);
		}
	}

	// To initialize the Driver
	public void initBrowser() {
		if (driver == null) {
			if (CONFIG.getProperty("browser").equalsIgnoreCase("Mozilla")) {
				driver = new FirefoxDriver();				
			}
			else if (CONFIG.getProperty("browser").equalsIgnoreCase("IE")) {
				driver = new InternetExplorerDriver();				
			}
			else if (CONFIG.getProperty("browser").equalsIgnoreCase("Chrome")) {
				System.setProperty("webdriver.chrome.driver", Constants.CHROME_DRIVER);
				driver = new ChromeDriver();				
			}
			else {
				System.setProperty("webdriver.chrome.driver", Constants.CHROME_DRIVER);
				driver = new ChromeDriver();
			}			

			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			driver.manage().window().maximize();
			APPLICATION_LOGS.info("Browser Initialized");
		} else {
			APPLICATION_LOGS.debug("WebDriver Instance was avaiable ");

		}
	}

	public void invokeApplication() {
		driver.get("http://tvishasystems.com/webdemo/hoopshe/public/");
	}

	public void closeBrowser() {
		driver.close();
		APPLICATION_LOGS.info("Browser Closed");
	}

	public void quitDriver() {
		driver.quit();
		APPLICATION_LOGS.info("All Browser Instance are closed");
	}

	public void takeScreenShot(String fileName) {
		File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(srcFile, new File(System.getProperty("user.dir") + "\\screenshots\\" + fileName + ".jpg"));
		} catch (Exception e) {
			APPLICATION_LOGS.error("Failed to create Screenshot with following exception" + e);
			e.printStackTrace();
		}
	}

	@BeforeClass
	public void init() {
		initConfig();
		initBrowser();
		invokeApplication();
	}

	@AfterClass
	public void tearDown() throws InterruptedException {
		Thread.sleep(5000);
		quitDriver();
	}
}
