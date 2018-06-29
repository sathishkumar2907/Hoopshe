package com.hoopshe.tests;

import java.io.IOException;
import java.util.Hashtable;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.support.PageFactory;
import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.hoopshe.pages.Loginpage;
import com.hoopshe.utils.TestUtil;

import jxl.JXLException;
import jxl.read.biff.BiffException;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

public class newLoginpagetest extends TestBase {
	@DataProvider
	public Object[][] getLoginData() throws BiffException, IOException{
		
		return TestUtil.getData("LoginSheet", null);
	}

	@Test(dataProvider="getLoginData")
	public void loginTest(Hashtable<String, String> data) throws InterruptedException
	
	{
		
		Loginpage logPage = PageFactory.initElements(driver, Loginpage.class);
		//if(data.get("Runmode").equalsIgnoreCase("NO"))
			//throw new SkipException("Skipping the test case as rumode is set to false. TestcaseID:" + data.get("TCID"));
		     
		
		 logPage.validateLogin(data.get("UserName"), data.get("Password"));
	}
	
	
	
	
	
	
	
	
	
	
}
