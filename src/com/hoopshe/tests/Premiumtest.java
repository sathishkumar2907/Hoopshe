package com.hoopshe.tests;

import java.awt.AWTException;
import java.io.IOException;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.hoopshe.pages.Homepage;
import com.hoopshe.pages.Postpage;
import com.hoopshe.pages.premiumpost;

import jxl.read.biff.BiffException;


	public class Premiumtest extends Loginpagetest {
		@DataProvider(name="test2")
		public Object[][] Postingdata() throws BiffException, IOException, InterruptedException{
			
			return (Object[][])Readdata.data("premiumsheet");
		}
		@Test(dataProvider="test2")
		
		public void premium_posting(String post_type,String title,String category, String subcategory,
	            String description,String city,String file,String price,
	            String tags,String filetype,String start_month,String start_date ,
	            String end_month,String end_date,String posted_loction,String verificationpost_type) throws AWTException, InterruptedException
		{
			Thread.sleep(2000);
			Homepage hom = PageFactory.initElements(driver, Homepage.class);
			hom.premium_tabclick();
			
			premiumpost pre = PageFactory.initElements(driver, premiumpost.class);
			pre.do_prepoast(post_type, title, category, subcategory, description, city,
					file, price, tags, filetype, start_month, start_date, end_month, end_date, posted_loction);
			
			Thread.sleep(2000);
			//validation.......
			hom.profile_click();
			Postpage pos = PageFactory.initElements(driver, Postpage.class);
			try{
		
			pos.postverfication(verificationpost_type, title);
			 Thread.sleep(3000);
			}
			catch(Exception e)
			{
				e.getLocalizedMessage();
			}
			 hom.hoopshe_home();
        }
		
	}
