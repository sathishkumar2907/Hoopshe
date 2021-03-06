package com.hoopshe.tests;

import java.awt.AWTException;
import java.io.IOException;
import java.util.Hashtable;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.hoopshe.pages.Homepage;
import com.hoopshe.pages.Loginpage;
import com.hoopshe.pages.Postpage;
import com.hoopshe.utils.TestUtil;

import jxl.read.biff.BiffException;



public class Loginpagetest extends TestBase{
	/*@DataProvider
	public Object[][] getLoginData() throws BiffException, IOException{
		
		return TestUtil.getData("LoginSheet", null);
	}

	@Test(dataProvider="getLoginData")
	public void loginTest(Hashtable<String, String> data) throws InterruptedException
	
	{
		
		Loginpage logPage = PageFactory.initElements(driver, Loginpage.class);
		if(data.get("Runmode").equalsIgnoreCase("NO"))
			throw new SkipException("Skipping the test case as rumode is set to false. TestcaseID:" + data.get("TCID"));
		     
		
		 logPage.validateLogin(data.get("UserName"), data.get("Password"));
	}*/
	@DataProvider
	public String[][] getLoginData() throws BiffException, IOException{
		
		return Readdata.data("loginsheet");
      }
	
	@Test(dataProvider="getLoginData")
	public void loginTest(String us,String ps) throws InterruptedException, AWTException
	{    
		System.out.println("tests");
		Loginpage logPage = PageFactory.initElements(driver, Loginpage.class);
	
		 
		logPage.login(us,ps);
		
		
		
		
			}
			
	}


