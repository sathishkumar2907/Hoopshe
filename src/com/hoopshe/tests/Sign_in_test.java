package com.hoopshe.tests;

import java.awt.AWTException;
import java.io.IOException;
import java.util.Hashtable;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.hoopshe.pages.Loginpage;
import com.hoopshe.utils.TestUtil;

import jxl.read.biff.BiffException;

public class Sign_in_test extends TestBase {
	@DataProvider
	public Object[][] getLoginData() throws BiffException, IOException{
		
		return TestUtil.getData("Post", null);
	}

	@Test(dataProvider="getLoginData")
	public void loginTest(Hashtable<String, String> data) throws InterruptedException, AWTException
	
	{
		
		Loginpage logPage = PageFactory.initElements(driver, Loginpage.class);
		//if(data.get("Runmode").equalsIgnoreCase("NO"))
			//throw new SkipException("Skipping the test case as rumode is set to false. TestcaseID:" + data.get("TCID"));
		     
		
		 logPage.sign_in(data.get("file"), data.get("name"),data.get("email"),data.get("mobile"),data.get("passwd"),data.get("city"));
		 
	}
}
