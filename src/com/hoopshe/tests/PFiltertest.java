package com.hoopshe.tests;

import java.awt.AWTException;
import java.io.IOException;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.hoopshe.pages.Filterpage;
import com.hoopshe.pages.Homepage;
import com.hoopshe.pages.premiumpost;

import jxl.read.biff.BiffException;

public class PFiltertest extends Loginpagetest{
		@DataProvider(name="test3")
		public Object[][] Postingdata() throws BiffException, IOException, InterruptedException{
			
			return (Object[][]) Readdata.data("filtersheet");
		}
		@Test(dataProvider="test3")
		
		public void filter(String Filter_type,String Title,String Category, String Subcategory,String City) throws AWTException, InterruptedException{
			 
			    Homepage hom = PageFactory.initElements(driver, Homepage.class);
			    
			  Filterpage fil = PageFactory.initElements(driver, Filterpage.class);
			  Thread.sleep(5000);
			  fil.fiter_on(Filter_type, Title, Category, Subcategory, City);
			  
			  Thread.sleep(1000);
			   hom.hoopshe_home();
		}
		
	}

