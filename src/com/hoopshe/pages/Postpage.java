package com.hoopshe.pages;

import java.awt.AWTException;
import java.util.List;

import javax.swing.text.html.HTML.Tag;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ByTagName;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class Postpage extends Page
{
	
	  WebDriver driver; 
	
         public Postpage(WebDriver driver){ 
            this.driver=driver; 
           }
        
    @FindBy(xpath="//*[@id='posting_type']")
	public WebElement post_select;
    
    @FindBy(xpath=".//*[@id='postTitle']")
	public WebElement Title;
    
    @FindBy(xpath=".//*[@id='postCategory']")
	public WebElement Category;
    
    @FindBy(xpath=".//*[@id='postSubCategory']")
	public WebElement Subcategory;
    
    @FindBy(xpath=".//*[@id='postDescription']")
	public WebElement Description;
    
    @FindBy(xpath=".//*[@id='postLocation']")
	public WebElement Location;
    
    @FindBy(xpath="html/body/div[13]")
	public WebElement Location_dropdown;
    
    @FindBy(xpath=".//*[@id='postPriceTagPlus']/img")
	public WebElement Pricetag;
    
    @FindBy(xpath=".//*[@id='postPriceTagInput']")
	public WebElement Pricetagdata;
    
    @FindBy(xpath=".//*[@id='postTagPlus']")
	public WebElement Tag;
    
    @FindBy(xpath=".//*[@id='postTagInput']")
	public WebElement Tagdata;
    
    @FindBy(xpath=".//*[@id='postPublishType']")
	public WebElement Publishtype;
    
    @FindBy(xpath=".//*[@id='postStartPublishDate']")
    public WebElement Publish_startddatefield;
    
    @FindBy(xpath="//*[@id='postPublishDate']")
    public WebElement Publish_enddatefield;
    
    @FindBy(xpath=".//*[@id='postAttachments']")
	public WebElement Attachment;
    
    @FindBy(xpath=".//*[@id='postProductSubmit']")
	public WebElement p_Submit;
    
    @FindBy(xpath=".//*[@id='postServiceSubmit']")
   	public WebElement s_Submit;
    
    @FindBy(xpath="//button[@id='postIshareSubmit']")
   	public WebElement ish_Submit;
    
    @FindBy(xpath=".//*[@id='postVideoSubmit']")
   	public WebElement vid_Submit;
    
    @FindBy(xpath=".//*[@id='postEventSubmit']")
   	public WebElement eve_Submit;
    
    
    @FindBy(xpath="//div[@class='profile-main-container container']/div/div[2]/div[2]/div[1]/div/span")
	public List<WebElement> Posttypes;
 
    @FindBy(xpath="xpath=//div[@class='profile-main-wrapper']/div[2]/div[2]/div[2]")
	public WebElement Posts_infeeds;
   
    @FindBy(xpath="//div[@id='feedsContainer']")
    public WebElement Posts_imainfeeds;
    
    @FindBy(xpath=".//*[@id='feedbackSection']/span")
    public WebElement Posts_valid;
   
   
	public Postpage dopoast(String post_type,String title,String category, String subcategory,
			                String description,String city,String file,String price,
			                String tags,String publishtype,String start_month,String start_date ,
			                String end_month,String end_date,String verificationpost_type) throws AWTException, InterruptedException
	{
		Thread.sleep(2000);
	 try {
		post_select.click();
		select_dropdown(post_select, post_type);
		
		Title.sendKeys(title);
		if(!post_type.equalsIgnoreCase("ISHARE"))
		{
		Category.click();
		select_dropdown(Category, category);
		Subcategory.click();
		Thread.sleep(2000);
		Subcategory.click();
		Subcategory.click();
		select_dropdown(Subcategory, subcategory);
		}
		Description.sendKeys(description);
		
		if(post_type.equalsIgnoreCase("EVENTS")) 
		{
			Publish_startddatefield.click();
			Thread.sleep(1000);
			setpost_startdate(driver, start_month, start_date);
			Publish_startddatefield.sendKeys(Keys.ENTER);
			
			Publish_enddatefield.click();
			Thread.sleep(1000);
			setpost_enddate(driver, end_month, end_date);
		}
		
		
		/*if(post_type.equalsIgnoreCase("ISHARE")) 
		{
			Publish_startddatefield.click();
			Thread.sleep(1000);
			setpost_startdate(driver, start_month, start_date);
			Publish_startddatefield.sendKeys(Keys.ENTER);
			
			Publish_enddatefield.click();
			Thread.sleep(1000);
			setpost_enddate(driver, end_month, end_date);
		}
		*/
		Location.sendKeys(city);
		Thread.sleep(2000);
		Location.sendKeys(Keys.ARROW_DOWN);
		Location.sendKeys(Keys.ENTER);
		//Actions a = new Actions(driver);
		//a.moveToElement(Location).pause(1000).keyDown(Keys.ARROW_DOWN).pause(1000).keyDown(Keys.ENTER).keyUp(Keys.ARROW_DOWN).keyUp(Keys.ENTER).build().perform();
		try{
		
			Attachment.click();
			Thread.sleep(1000);
			fileupload(file);
			Thread.sleep(1000);
		}catch(Exception e){
			System.out.println(e);
		}
		
		if(post_type.equalsIgnoreCase("PRODUCT")|| post_type.equalsIgnoreCase("SERVICE"))
		{
		Pricetag.click();
		Pricetagdata.sendKeys(price);
		Thread.sleep(2000);
		}
		
		/*if(post_type.equalsIgnoreCase("PRODUCT")||post_type.equalsIgnoreCase("SERVICE")){
		 Tag.click(); 
		Thread.sleep(1000);
		Tagdata.sendKeys(tags);
		Thread.sleep(1000);
		}*/
		
		Publishtype.click();
		select_dropdown(Publishtype, publishtype);
		Thread.sleep(1000);
		
		if(post_type.equalsIgnoreCase("PRODUCT"))
		{
			p_Submit.click();
		}
		else if(post_type.equalsIgnoreCase("SERVICE"))
		{
			s_Submit.click();
		}
		else if(post_type.equalsIgnoreCase("EVENTS"))
		{
			eve_Submit.click();
		}
		else if(post_type.equalsIgnoreCase("VIDEOS"))
		{
	    	vid_Submit.click();
		}
		else 
		{
			try{
			
				ish_Submit.click();
		
			}catch(Exception e){
				e.getLocalizedMessage();
			}
			}
		
		if(isElementPresent(driver, Posts_valid))
		{
			System.out.println(Posts_valid.getText()+"..post");
		}
		Thread.sleep(3000);
		Thread.sleep(2000);
		Homepage hom = PageFactory.initElements(driver, Homepage.class);
		Thread.sleep(1000);
		hom.hoopshe_home();
		Thread.sleep(2000);
		Thread.sleep(1000);
		hom.postclick();
		Thread.sleep(2000);	
		Thread.sleep(1000);
		System.out.println("post upload succesfully");
		Reporter.log(Posts_valid.getText()+"..post upload succesfully");

	 }catch(Exception e){
		        e.printStackTrace();
		        System.out.println("post not uploaded");
	                         }
		return PageFactory.initElements(driver, Postpage.class);
	
	}
	
	
    public void postverfication(String verificationpost_type,String title) throws InterruptedException
      {  
         
    	  /*for(WebElement posttype:Posttypes)
    		   {    
    		   
    		   if(posttype.getText().equalsIgnoreCase(verificationpost_type))
    		    {  
    			      System.out.println("match");
    		          Thread.sleep(2000);
    			      posttype.click();
    			      break;
    		      }
    		   else
    		   {
    		   System.out.println("match fail");
    	       }
         }   
         	Thread.sleep(5000);
    		    */
    	//  List<WebElement> Postslist = Posts_infeeds.findElements(By.xpath("//div[contains(@id,'feed-block') and contains(@class,'feed-block clearfix-height')]"));
    	   List<WebElement> Postslist = Posts_imainfeeds.findElements(By.xpath("//div[contains(@id,'feed-block')]")); 
    	 
    	   
    	  // System.out.println("postlist_size"+Postslist.size());
     
       try{
    	     
    	   if(!Postslist.isEmpty()) 
       	{ 
    	 	for(int i =1;i<= Postslist.size();i++)
    	 	   {  
    	 		
    	 		
    		    // System.out.println("in the for loop");
    	 		
    	 		 if(verificationpost_type.equalsIgnoreCase("Products")||verificationpost_type.equalsIgnoreCase("Services"))
    	 		 {
    	 			 
    	 			 // System.out.println("in the if condition");
    	 		     WebElement tagname=driver.findElement(By.xpath("//div[@id='feedsContainer']/div["+i+"]/div[2]/div[2]/a"));
    	 		       System.out.println("post title.."+tagname.getText());   
    	 		       System.out.println(title);
    	 		       if(tagname.getText().equals(title))
    	 		      {
    	 			     System.out.println(title+"post match and varified");
    	 			     Reporter.log(title+"post match and varified");
    	 			      break;
    	 		       }
    	 		      
    	 		 }
    	 		 else
    	 		 {

    	 		     WebElement tagname=driver.findElement(By.xpath("//div[@id='feedsContainer']/div["+i+"]/div[2]/div[1]/a"));
    	 		      // System.out.println("post title.."+tagname.getText());
    	 		       //System.out.println(title);
    	 		       if(tagname.getText().equals(title))
    	 		      {
    	 			     System.out.println(title+"post match and varified");
    	 			    Reporter.log(title+"post match and varified");
    	 			      break;
    	 		       }
    	 		 }
    	 		
                 }
       	}
    	   else
    		   System.out.println("no post avalable");
       }catch(Exception e){
			System.out.println(e);
			System.out.println("post not matched");
			Reporter.log(title+"post not match and varified");
		}
   
       }
}
       
       
       
            	
    		  
            	