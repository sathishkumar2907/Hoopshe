package com.hoopshe.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Homepage extends Page {

	 WebDriver driver; 
	
	    public Homepage(WebDriver driver){ 
	            this.driver=driver; 
	    }
	    
	    @FindBy(xpath=".//*[@id='headingTabsContent']/div[7]")
		public  WebElement post_tab;
	    
	    @FindBy(xpath=".//*[@id='navbarResponsive']/ul/li[3]/a")
		public  WebElement premium_tab;
	    
	    @FindBy(xpath="html/body/nav/div/div[1]/a")
		public  WebElement home_hoopshe;
	    
	    @FindBy(xpath="html/body/nav/div/div[2]/div[1]/span/span[2]")
		public WebElement prof_image;
	    
	    @FindBy(xpath=".//*[@id='navbarResponsive']/div[1]/ul/li[1]/a")
		public  WebElement profile;
		public  Postpage postclick()
		{
			post_tab.click();
			
			return PageFactory.initElements(driver, Postpage.class);
		}
		public  premiumpost premium_tabclick()
		{
			premium_tab.click();
			
			return PageFactory.initElements(driver, premiumpost.class);
		}
		public void hoopshe_home(){
			try{
			home_hoopshe.click();
		    
			}catch(Exception e){
				e.getLocalizedMessage();
			}
			}
		public void profile_click() throws InterruptedException{
			prof_image.click();
			Thread.sleep(2000);
			profile.click();
		}
		
		
		
}
