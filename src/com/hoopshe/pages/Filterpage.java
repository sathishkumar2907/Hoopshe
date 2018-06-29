package com.hoopshe.pages;

import java.awt.AWTException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class Filterpage extends Page{
	
	

	WebDriver driver; 
		
     public Filterpage(WebDriver driver)
     { 
        this.driver=driver; 
      }
	
	 @FindBy(xpath="html/body/nav/div/div[1]/a")
		public  WebElement Home_hoopshe;
	 
	/* @FindBy(xpath="//div[@class='filters-content']/div[2]/select")
		public  WebElement Filter_type;
	 */
	 @FindBy(xpath="html/body/div[1]/div[1]/div/div[1]/div[2]/div[2]/div[2]/select")
		public  WebElement Filter_type;
	 
	 @FindBy(xpath=".//*[@id='feedsLeftwrapper']/div[2]/div[2]/input[1]")
		public  WebElement Title;
	 
	 @FindBy(xpath=".//*[@id='filter_category']")
		public  WebElement Category;
	 
	 @FindBy(xpath=".//*[@id='filter_sub_category']")
		public  WebElement sub_category;
	 
	 @FindBy(xpath=".//*[@id='locationFilter']")
		public  WebElement Location;
	 
	 @FindBy(xpath="html/body/div[8]")
		public  WebElement Location_dropdown;
	 
	 @FindBy(xpath=".//*[@id='submitFilters']")
		public  WebElement Sumbit_button;
	 
	 @FindBy(xpath=".//*[@id='resetFilters']")
		public  WebElement Reset_button;
	 @FindBy(xpath="//div[@class='feeds-main-wrapper']/div[2]/div[3]/div[3]")
		public WebElement Pro_infeeds;
	 
	   @FindBy(xpath="//div[@class='feeds-main-wrapper']/div[2]/div[4]/div[3]")
		public WebElement Ser_infeeds;
	   
	   @FindBy(xpath="//div[@class='feeds-main-wrapper']/div[2]/div[2]/div[3]")
	    public WebElement Posts_infeeds;
	 
	 public Filterpage fiter_on(String filter_type,String title,String category, String subcategory, String city) throws AWTException, InterruptedException
             {
		   try{
		        Thread.sleep(5000);
			   
		         Filter_type.click();
		         select_dropdown(Filter_type, filter_type);
		         Thread.sleep(2000);
		         if(!title.equalsIgnoreCase("null"))
					{
		               Title.sendKeys(title);
					}
		         if(!category.equalsIgnoreCase("null"))			
		         {		
					Category.click();
					select_dropdown(Category, category);
		         }
		         if(!subcategory.equalsIgnoreCase("null"))			
		         {	
		        	    sub_category.click();
		        	    Thread.sleep(1000);
				      // sub_category.click();
					   //sub_category.click();
					   Thread.sleep(2000);
					 select_dropdown(sub_category, subcategory);
				  }
		         if(!city.equalsIgnoreCase("null"))			
		         {			
						Location.sendKeys(city);
						Thread.sleep(2000);
					//  Location.sendKeys(Keys.ARROW_DOWN);
						//Location.sendKeys(Keys.ENTER);
		         }	
				
		         Sumbit_button.click();
		         Thread.sleep(3000);
		         varification( filter_type, title, category,  subcategory, city);
		   }catch (Exception e){ e.printStackTrace();}
		   
		   
		         return PageFactory.initElements(driver, Filterpage.class); 
		   
             }
	   public void varification(String filter_type,String title,String category, String subcategory,String city)  //verification...................;...
	     {    
		   try{
		   
		   //.........varification for product.........
		   
		      if(filter_type.equals("Products"))
		        {
		        	 List<WebElement> Postslist = Pro_infeeds.findElements(By.xpath("//div[contains(@id,'feed-block') and contains(@class,'feed-block clearfix-height')]")); 
		      	   System.out.println("postlist_size"+Postslist.size());
		      	 	for(int i =1;i<= Postslist.size();i++)
		      	 	   {   if(!title.equalsIgnoreCase("null"))
						      {
		      	 		          WebElement tagname=driver.findElement(By.xpath("//div[@class='feeds-main-wrapper']/div[2]/div[3]/div[3]/div["+i+"]/div[2]/div[2]/a"));
		      	 		         // System.out.println("post title.."+tagname.getText());
		      	 		          //System.out.println(title);
		      	 		          if(tagname.getText().equals(title))
		      	 		           {
		      	 			           System.out.println(title+"..title match and varified");
		      	 			        Reporter.log(title+"post match and varified");
		      	 			         
		      	 		            } else {
		      	 		            	System.out.println(title+"..title not match and varified");
		      	 		            	Reporter.log(title+"title  not match and varified");
		      	 		            }
						       } 
		      	      	     if(!category.equalsIgnoreCase("null"))			
			                   {
			      	      	      WebElement tagname=driver.findElement(By.xpath("//div[@class='feeds-main-wrapper']/div[2]/div[3]/div[3]/div["+i+"]/div[2]/div[1]/span[2]"));
		      	 		         // System.out.println("post title.."+tagname.getText());
		      	 		          //System.out.println(title);
		      	 		          if(tagname.getText().equals(category))
		      	 		           {
		      	 			           System.out.println(category+"..category match and varified");
		      	 			        Reporter.log(category+"category match and varified");
		      	 			         
		      	 		            } else 
		      	 		            	{System.out.println(category+"..category not match and varified");
		      	 		            	Reporter.log(category+"category  not match and varified");
		      	 		            	}
			                    }
		      	            if(!subcategory.equalsIgnoreCase("null"))			
				                {	

				      	      	      WebElement tagname=driver.findElement(By.xpath("//div[@class='feeds-main-wrapper']/div[2]/div[3]/div[3]/div["+i+"]/div[2]/div[1]/span[3]"));
			      	 		         // System.out.println("post title.."+tagname.getText());
			      	 		          //System.out.println(title);
			      	 		          if(tagname.getText().equals(subcategory))
			      	 		           {
			      	 			           System.out.println(subcategory+"..subcategory match and varified");
			      	 			        Reporter.log(subcategory+"subcategory match and varified");
			      	 			         
			      	 		            } else 
			      	 		            	{System.out.println(subcategory+"..subcategory not match and varified");
			      	 		                 Reporter.log(subcategory+"subcategory not match and varified");}
				                }
				        
		      	             if(!city.equalsIgnoreCase("null"))			
				                {	

			      	      	          WebElement tagname=driver.findElement(By.xpath("//div[@class='feeds-main-wrapper']/div[2]/div[3]/div[3]/div["+i+"]/div[2]/a/div[1]"));
		      	 		            // System.out.println("post title.."+tagname.getText());
		      	 		             //System.out.println(title);
		      	 		              if(tagname.getText().equals(city))
		      	 		             {
		      	 			           System.out.println(city+"..city match and varified");
		      	 			          Reporter.log(city+"city not match and varified");
		      	 			         
		      	 		              } else {
		      	 		            	  System.out.println(city+"..city not match and varified");
		      	 		            	 Reporter.log(city+"city not match and varified");
		      	 		              }
		      	 		                
				                  }
		      	      	
		      	
		      	 	      }  
		      	 	   
		      	 	
                     }
		      //.......service.............
		      
		      if(filter_type.equals("Services")) //varification for service
		        {
		        	 List<WebElement> Postslist = Ser_infeeds.findElements(By.xpath("//div[contains(@id,'feed-block') and contains(@class,'feed-block clearfix-height')]")); 
		      	   System.out.println("postlist_size"+Postslist.size());
		      	 	for(int i =1;i<= Postslist.size();i++)
		      	 	   {   if(!title.equalsIgnoreCase("null"))
						      {
		      	 		          WebElement tagname=driver.findElement(By.xpath("//div[@class='feeds-main-wrapper']/div[2]/div[4]/div[3]/div["+i+"]/div[2]/div[2]/a"));
		      	 		         // System.out.println("post title.."+tagname.getText());
		      	 		          //System.out.println(title);
		      	 		       if(tagname.getText().equals(title))
	      	 		           {
	      	 			           System.out.println(title+"..title match and varified");
	      	 			        Reporter.log(title+"post match and varified");
	      	 			         
	      	 		            } else {
	      	 		            	System.out.println(title+"..title not match and varified");
	      	 		            	Reporter.log(title+"title  not match and varified");
	      	 		            }
						       } 
		      	      	     if(!category.equalsIgnoreCase("null"))			
			                   {
			      	      	      WebElement tagname=driver.findElement(By.xpath("//div[@class='feeds-main-wrapper']/div[2]/div[4]/div[3]/div["+i+"]/div[2]/div[1]/span[2]"));
		      	 		         // System.out.println("post title.."+tagname.getText());
		      	 		          //System.out.println(title);
			      	      	  if(tagname.getText().equals(category))
	      	 		           {
	      	 			           System.out.println(category+"..category match and varified");
	      	 			        Reporter.log(category+"category match and varified");
	      	 			         
	      	 		            } else 
	      	 		            	{System.out.println(category+"..category not match and varified");
	      	 		            	Reporter.log(category+"category  not match and varified");
	      	 		            	}
			                    }
		      	            if(!subcategory.equalsIgnoreCase("null"))			
				                {	

				      	      	      WebElement tagname=driver.findElement(By.xpath("//div[@class='feeds-main-wrapper']/div[2]/div[4]/div[3]/div["+i+"]/div[2]/div[1]/span[3]"));
			      	 		         // System.out.println("post title.."+tagname.getText());
			      	 		          //System.out.println(title);
				      	      	  if(tagname.getText().equals(subcategory))
		      	 		           {
		      	 			           System.out.println(subcategory+"..subcategory match and varified");
		      	 			        Reporter.log(subcategory+"subcategory match and varified");
		      	 			         
		      	 		            } else 
		      	 		            	{System.out.println(subcategory+"..subcategory not match and varified");
		      	 		                 Reporter.log(subcategory+"subcategory not match and varified");}
				                }
				        
		      	             if(!city.equalsIgnoreCase("null"))			
				                {	

			      	      	          WebElement tagname=driver.findElement(By.xpath("//div[@class='feeds-main-wrapper']/div[2]/div[4]/div[3]/div["+i+"]/div[2]/a/div[1]"));
		      	 		            // System.out.println("post title.."+tagname.getText());
		      	 		             //System.out.println(title);
			      	      	      if(tagname.getText().equals(city))
		      	 		             {
		      	 			           System.out.println(city+"..city match and varified");
		      	 			          Reporter.log(city+"city not match and varified");
		      	 			         
		      	 		              } else {
		      	 		            	  System.out.println(city+"..city not match and varified");
		      	 		            	 Reporter.log(city+"city not match and varified");
		      	 		              }
				                  }
		      	      	
		      	
		      	 	      }  
		      	 	   
		      	 	
                   }
		      
		      
		      
                 else      //verification for event/share/video......
                     {
                	    List<WebElement> Postslist = Posts_infeeds.findElements(By.xpath("//div[contains(@id,'feed-block') and contains(@class,'feed-block clearfix-height')]")); 
		      	      System.out.println("postlist_size"+Postslist.size());
		      	 	  for(int i =1;i<= Postslist.size();i++)
		      	 	    {
		      	 		       if(!title.equalsIgnoreCase("null"))
					              {
                	                 WebElement tagname=driver.findElement(By.xpath("//div[@class='feeds-main-wrapper']/div[2]/div[2]/div[3]/div["+i+"]/div[2]/div[1]/a"));
    	 		                      // System.out.println("post title.."+tagname.getText());
    	 		                      //System.out.println(title);
    	 		                       if(tagname.getText().equals(title))
    	 		                          {
    	 			                        System.out.println(title+"..post match withb title and varified");
    	 			                       Reporter.log(title+"title match and varified");
    	 		                          }
					              } else {
					            	  System.out.println(title+"..post not match and varified");
					            	  Reporter.log(title+"title  not match and varified");
					              }
		      	 		       
    	 		         }  
                   }
	         }catch(Exception e){
	        	e.printStackTrace();
	         }
		         
            
	     }
	 
	 
      }						 
  
