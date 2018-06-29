package com.hoopshe.tests;

import java.awt.AWTException;
import java.io.IOException;
import java.util.Hashtable;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.hoopshe.pages.Homepage;

import com.hoopshe.pages.Postpage;
import com.hoopshe.utils.TestUtil;

import jxl.read.biff.BiffException;

public class Posting_test extends Loginpagetest{
	@DataProvider(name="test")
	public Object[][] Postingdata() throws BiffException, IOException, InterruptedException{
		
		return (Object[][]) Readdata.data("postsheet");
	}
	@Test(dataProvider="test")
	
	public void posting(String post_type,String title,String category, String subcategory,
            String description,String city,String file,String price,
            String tags,String publishtype,String start_month,String start_date ,
            String end_month,String end_date,String verificationpost_type) throws AWTException, InterruptedException
	  {
		Thread.sleep(1000);
		Homepage hom = PageFactory.initElements(driver, Homepage.class);
		
		try
		{
		hom.postclick();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		try
		{
		Postpage pos = PageFactory.initElements(driver, Postpage.class);
	    
		pos.dopoast(post_type, title, category, subcategory, description, city, file, price, tags, publishtype, start_month, start_date, end_month, end_date, verificationpost_type);	      

		}
		catch(Exception e)
		{
	       e.printStackTrace();
	      }
		hom.hoopshe_home();
	 
	  }
		 
	}
	
	
	




