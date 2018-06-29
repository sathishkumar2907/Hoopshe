package com.hoopshe.pages;


import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.Select;



public class Page {
	
   // Create the Global Objects
   Logger APPLICATION_LOGS = Logger.getLogger(Page.class);
   
   public boolean isElementPresent(WebDriver driver, WebElement element) {
	 
	   try {
		   element.isDisplayed();
		   return true;
	   }
	   catch(Exception e){
		   return false;
	   }
   }
   
   public boolean clickOnElement(WebDriver driver, By locator) {
	   try {
		   driver.findElement(locator).click();
		   return true;
	   }
	   catch(Exception e){
		   APPLICATION_LOGS.error("Error", e);
		   return false;
	   }
   }
   public void fileupload(String file) throws AWTException, InterruptedException 
   {
		   StringSelection s = new StringSelection(file);
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(s, null);
        
         Robot robot = new Robot();
         robot.keyPress(KeyEvent.VK_CONTROL);
              robot.keyPress(KeyEvent.VK_V);
              robot.keyRelease(KeyEvent.VK_V);
              robot.keyRelease(KeyEvent.VK_CONTROL);
              Thread.sleep(1000);
              robot.keyPress(KeyEvent.VK_ENTER);
             robot.keyRelease(KeyEvent.VK_ENTER);
    }

   public void wait( WebDriver driver,WebElement webElement) {
		WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.elementToBeSelected(webElement)); 
		//System.out.println("wait completed");
	}

   public void select_dropdown(WebElement dropdown,String data)



   { try
       {
	   Thread.sleep(1000);
 	   Select s= new Select(dropdown);
 		 s.selectByVisibleText(data);}
       catch (Exception e){
 	   System.out.println(e);}
 		
        }

   public void setpre_postdate(WebDriver driver,String start_month, String start_date) throws InterruptedException {
	      
        WebElement YEAR = driver.findElement(By.xpath("//table[@class=' table-condensed']/thead/tr[1]/th[2]"));
        System.out.println(YEAR.getText());
        System.out.println(start_month);
		   while(!YEAR.getText().equalsIgnoreCase(start_month)) 
		   {   System.out.println("loopenter");
		   driver.findElement(By.xpath("//table[@class=' table-condensed']/thead/tr[1]/th[3]")).click(); 
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
						col.sendKeys(Keys.ENTER);
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
   public void setpost_startdate(WebDriver driver,String start_month, String start_date) throws InterruptedException {
	      
       WebElement YEAR = driver.findElement(By.xpath(".//*[@id='addPostTabContent']/div[1]/div[5]/span[1]/div/ul/li[1]/div/div[1]/table/thead/tr[1]/th[2]"));
       System.out.println("web.."+YEAR.getText());   
       System.out.println("given.."+start_month);    
		   while(!YEAR.getText().equals(start_month)) 
		   {   System.out.println("loopenter");
		   driver.findElement(By.xpath(".//*[@id='addPostTabContent']/div[1]/div[5]/span[1]/div/ul/li[1]/div/div[1]/table/thead/tr[1]/th[3]")).click(); 
			   Thread.sleep(1000);       
		   }

		 WebElement table = driver.findElement(By.xpath(".//*[@id='addPostTabContent']/div[1]/div[5]/span[1]/div/ul/li[1]/div/div[1]/table/tbody"));
			  
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
}public void setpost_enddate(WebDriver driver,String start_month, String start_date) throws InterruptedException {
    
 WebElement YEAR = driver.findElement(By.xpath(".//*[@id='addPostTabContent']/div[1]/div[6]/span[1]/div/ul/li[1]/div/div[1]/table/thead/tr[1]/th[2]"));
 System.out.println("web.."+YEAR.getText());   
 System.out.println("given.."+start_month);    
	   while(!YEAR.getText().equals(start_month)) 
	   {   System.out.println("loopenter");
	   driver.findElement(By.xpath(".//*[@id='addPostTabContent']/div[1]/div[6]/span[1]/div/ul/li[1]/div/div[1]/table/thead/tr[1]/th[3]")).click(); 
		   Thread.sleep(1000);       
	   }

	 WebElement table = driver.findElement(By.xpath(".//*[@id='addPostTabContent']/div[1]/div[6]/span[1]/div/ul/li[1]/div/div[1]/table/tbody"));
		  
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



