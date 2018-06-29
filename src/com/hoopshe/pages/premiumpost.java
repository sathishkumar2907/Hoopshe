package com.hoopshe.pages;

import java.awt.AWTException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class premiumpost extends Page {
	
		  WebDriver driver;
		
	         public premiumpost(WebDriver driver){ 
	            this.driver=driver; 
	           }
	    
	    @FindBy(xpath=".//*[@id='globalLocationRadio']")
		public WebElement global;
	    
	    
	    @FindBy(xpath=".//*[@id='locations-display-container']/div[1]/span")
		public WebElement hydlocation;
	    
	    @FindBy(xpath=".//*[@id='startDate']")
		public WebElement startdate;
	    
	    @FindBy(xpath=".//*[@id='endDate']")
		public WebElement enddate;
	    @FindBy(xpath=".//*[@id='activate-step-2']")
		public WebElement next_button;
	    
	    @FindBy(xpath=".//*[@id='step-2']/div/div/div/div[1]/div[2]/div[1]/div[1]")
		public WebElement single_image;
	    
	    @FindBy(xpath=".//*[@id='step-2']/div/div/div/div[1]/div[2]/div[2]/div[1]")
		public WebElement single_video;
	    
	    @FindBy(xpath=".//*[@id='step-2']/div/div/div/div[1]/div[2]/div[3]/div[1]/i")
		public WebElement multi_images;
	    
	    @FindBy(xpath=".//*[@id='step-2']/div/div/div/div[2]/div[2]/span[1]/img")
		public WebElement Attachment;
	    
	    @FindBy(xpath=".//*[@id='title']")
		public WebElement Title;
	    
	    @FindBy(xpath=".//*[@id='description']")
		public WebElement Description;
	    
	    @FindBy(xpath=".//*[@id='tags']")
		public WebElement Tagdata;
	    
	    @FindBy(xpath=".//*[@id='itemType']")
		public WebElement post_select;
	    
	    @FindBy(xpath=".//*[@id='category']")
		public WebElement Category;
	    
	    @FindBy(xpath=".//*[@id='subCategory']")
		public WebElement Subcategory;
	    
	    @FindBy(xpath=".//*[@id='priceTag']")
		public WebElement Pricetag;
	    
	    @FindBy(xpath=".//*[@id='itemLocation']")
		public WebElement Location;
	    
	    @FindBy(xpath="html/body/div[8]")
		public WebElement Location_dropdown;
	    
	    
	    @FindBy(xpath=".//*[@id='activate-step-3']")
		public WebElement next2;
	    
	    @FindBy(xpath=".//*[@id='publishAd']")
		public WebElement paynow_button;
	   
	    public Postpage do_prepoast(String post_type,String title,String category, String subcategory,
                String description,String city,String file,String price,
                String tags,String filetype,String start_month,String start_date ,
                String end_month,String end_date,String posted_loction) throws AWTException, InterruptedException{
	    	try{
	       
	    	 if(posted_loction.equalsIgnoreCase("globel"))
	    	 {
	    		 global.click();
	    	 }
	    	 else if(posted_loction.equalsIgnoreCase("local"))
	    	 {
	    		 hydlocation.click();
	    		 Thread.sleep(5000);
	    	 }
	    	 //caleder setting
	    	     startdate.click();
				Thread.sleep(3000);
				setpostdate1(driver, start_month, start_date);
				
				enddate.click();
				Thread.sleep(3000);
				setpostdate1(driver, end_month, end_date);
	    	 
				next_button.click();
				Thread.sleep(2000);
			//2nd stage
				
				if(filetype.equalsIgnoreCase("singleimage"))
				{
					single_image.click();
				}else if(filetype.equalsIgnoreCase("singlevideo"))
				{
					single_video.click();
				}else if(filetype.equalsIgnoreCase("multiimage"))
				{
					multi_images.click();
				}
				Thread.sleep(1000);
				try{
					Attachment.click();
					Thread.sleep(2000);
					fileupload(file);
					Thread.sleep(1000);
			 }catch(Exception e){
							System.out.println(e);
						}
				Title.sendKeys(title);
				Description.sendKeys(description);
				
				
				Tagdata.sendKeys(price);
				Tagdata.sendKeys(Keys.ENTER);
				Thread.sleep(1000);
				
				post_select.click();
				Thread.sleep(1000);
				select_dropdown(post_select, post_type);
				
				Category.click();
				Thread.sleep(1000);
				select_dropdown(Category, category);
				Subcategory.click();
				Thread.sleep(2000);
				Subcategory.click();
				Subcategory.click();
				select_dropdown(Subcategory, subcategory);
				
				Thread.sleep(1000);
				Pricetag.sendKeys(price);
				
				Location.sendKeys(city);
				Thread.sleep(2000);
				Location.sendKeys(Keys.ARROW_DOWN);
				Location.sendKeys(Keys.ENTER);
				//Actions a = new Actions(driver);
				//a.moveToElement(Location).pause(1000).keyDown(Keys.ARROW_DOWN).pause(1000).keyDown(Keys.ENTER).keyUp(Keys.ARROW_DOWN).keyUp(Keys.ENTER).build().perform();
				Thread.sleep(1000);
				
				next2.click();
				Thread.sleep(2000);
				paynow_button.click();
	    	}catch (Exception e){e.printStackTrace();}
				
           return PageFactory.initElements(driver, Postpage.class);

         }

		
	    public void setpostdate1(WebDriver driver,String start_month, String start_date) throws InterruptedException {
		      
	        WebElement YEAR = driver.findElement(By.xpath("//table[@class=' table-condensed']/thead/tr[2]/th[2]"));
	        System.out.println(YEAR.getText());
	        System.out.println(start_month);
			   while(!YEAR.getText().equalsIgnoreCase(start_month)) 
			   {   System.out.println("loopenter");
			   driver.findElement(By.xpath("//table[@class=' table-condensed']/thead/tr[2]/th[3]")).click(); 
				   Thread.sleep(1000);
			   }

			 WebElement table = driver.findElement(By.xpath("//table[@class=' table-condensed']/tbody"));
				  
			List<WebElement> rows = table.findElements(By.tagName("tr"));
			System.out.println("rows size"+rows.size());
			 
			for(WebElement row: rows) 
			{
			  try
			  {
				  List<WebElement> cols = row.findElements(By.tagName("td"));
				 System.out.println("col size"+cols.size());
				 for(WebElement col: cols)
		            { 
					
					  if(col.getText().equals(start_date)) 
					   {  
						 System.out.println(col.getText());
						 if(col.isEnabled()) {
							 col.click();
							 break; 
						 }
						
						 }
					}
				 } 
			  catch (StaleElementReferenceException e)
			      {
				  System.err.println(e);
			      } 
			}
	}
   }
