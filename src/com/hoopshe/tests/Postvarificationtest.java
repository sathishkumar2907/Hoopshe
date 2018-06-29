package com.hoopshe.tests;

import java.awt.AWTException;
import java.io.IOException;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.hoopshe.pages.Homepage;
import com.hoopshe.pages.Postpage;

import jxl.read.biff.BiffException;

public class Postvarificationtest extends Loginpagetest{
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
		 Thread.sleep(1000);
    try{
	        hom.profile_click();
		    Postpage pos = PageFactory.initElements(driver, Postpage.class);
			pos.postverfication(verificationpost_type, title);
			Thread.sleep(1000);
			//hom.hoopshe_home();
	  }
	  catch(Exception e){
		  e.getLocalizedMessage();
		  
	  }
        hom.hoopshe_home(); 
	}
	
}
