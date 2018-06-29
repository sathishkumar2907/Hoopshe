package com.hoopshe.pages;

	import java.awt.AWTException;
import java.util.Arrays;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.support.FindBy;
	import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;



	public class Loginpage extends Page{
		
		WebDriver driver;
		 
	    public Loginpage(WebDriver driver){ 
	            this.driver=driver; 
	          
	    }
	    
		@FindBy(xpath=".//*[@id='dXNlcm5hbWU']")
		public WebElement userid;
		
		@FindBy(xpath=".//*[@id='cGFzc3dvcmQ']")
		public WebElement password;
		
		@FindBy(xpath=".//*[@id='bG9naW5CdG4']")
		public WebElement login;
		
		@FindBy(xpath=".//*[@id='forgotPassword']")
		public WebElement forgetpswd;
		
		@FindBy(xpath="html/body/div[1]/div[1]/div[1]/div[2]/div/div/div[1]/span")
		public WebElement newuser_signlink;
		
		@FindBy(xpath=".//*[@id='forgotPasswordUsername']")
		public WebElement forgetuserid;
		

		@FindBy(xpath="html/body/div[1]/div[2]/div/div/div/div[2]/div[2]/div[1]/div/div[1]/form/div")
		public WebElement signin_profle_pic;
		
		@FindBy(xpath=".//*[@id='bmFtZUlucHV0']")
		public WebElement signin_name;
		
		@FindBy(xpath=".//*[@id='ZW1haWxJbnB1dA']")
		public WebElement signin_email;
		
		@FindBy(xpath=".//*[@id='bW9iaWxlSW5wdXQ']")
		public WebElement signin_mobilenum;
		
		@FindBy(xpath=".//*[@id='cGFzc3dvcmRJbnB1dA']")
		public WebElement signin_pswd;
		
		@FindBy(xpath=".//*[@id='userLocation']")
		public WebElement signin_location;
		
		@FindBy(xpath=".//*[@id='cmVnaXN0ZXJCdG4']")
		public WebElement signin_submit;
		
		@FindBy(xpath=".//*[@id='YWxyZWFkeUhhdmVPdHA']")
		public WebElement already_otp;
		
		@FindBy(xpath="html/body/div[1]/div[5]")
		public WebElement  errormessage;
		
		@FindBy(xpath="html/body/div[1]/div[2]/div/div/div/div[2]/div[2]/div[2]/div[2]/input")
		public WebElement  singin_pass;
		
		@FindBy(xpath="html/body/nav/div/div[2]/div[1]/span/span[2]")
		public WebElement login_pass;
		
		@FindBy(xpath=".//*[@id='navbarResponsive']/div[1]/ul/li[5]/a")
		public WebElement Logout;
	
		public Homepage login(String usid, String pass) throws InterruptedException
		{
			
//			String[] password1=pass.split("//.");
//			String str = Arrays.toString(password1);
//			System.out.println("str "+str.split("//."));
			userid.clear();
			userid.sendKeys(usid);
		     password.clear();
			password.sendKeys(pass);
			//System.out.println("pass"+ pass.substring(0,5));
			
			login.click();
			Thread.sleep(5000);
			return PageFactory.initElements(driver, Homepage.class);
		}
		
		public Loginpage sign_in(String file,String name,String email,String mobile,String passwd,String city) throws AWTException, InterruptedException
		{
			newuser_signlink.click();
			Thread.sleep(3000);
			
			signin_name.sendKeys(name);
			signin_email.sendKeys(email);
			signin_mobilenum.sendKeys(mobile);
			signin_pswd.sendKeys(passwd);
			//select_dropdown(dropdown, city);
			signin_location.sendKeys(city);
			Thread.sleep(2000);
			signin_location.sendKeys(Keys.ARROW_DOWN);
			signin_location.sendKeys(Keys.ENTER);
			
			/*signin_profle_pic.click();
			Thread.sleep(1000);
			fileupload(file);
			Thread.sleep(1000);*/
			signin_submit.click();
			
			if(isElementPresent(driver, errormessage))
			{
				System.out.println(errormessage.getText()+"...null tset passed");
				Reporter.log(errormessage.getText()+"...null test passed");
			}
			else if (isElementPresent(driver, singin_pass)){
				System.out.println(" valid sign in pass");
				Reporter.log(" valid sign in pass");
			}
			Thread.sleep(2000);
			driver.navigate().refresh();
			Thread.sleep(3000);
			
			return PageFactory.initElements(driver, Loginpage.class);
		}
		
		public  String validateLogin(String uname, String pass) throws InterruptedException {
		
			try{
			
			userid.clear();
			userid.sendKeys(uname);
			password.clear();
			password.sendKeys(pass);
			
			login.click();
			Thread.sleep(5000);
			
			if(uname.equals("") && pass.equals(""))
			{   Thread.sleep(2000);
				System.out.println(errormessage.getText()+"...null tset passed");
				Reporter.log(errormessage.getText()+"...null  data test passed");
				return  "null pass";
			}
			else if(uname.equals(""))
			{    Thread.sleep(2000);
				System.out.println(errormessage.getText()+"...null username tset passed");
				Reporter.log(errormessage.getText()+"...null username test passed");
				return  "null pass";
			}
			else if (pass.equals(""))
			{    Thread.sleep(2000);
				System.out.println(errormessage.getText()+"...null password tset passed");
				Reporter.log(errormessage.getText()+"...null password test passed");
				return  "null pass";
			}
			else if(isElementPresent(driver, login_pass))
			{   login_pass.click();
				Thread.sleep(2000);
				Logout.click();
				Reporter.log("...valid test passed");
				return  "valid pass";
			 }
			else 
			{    Thread.sleep(2000);
				System.out.println(errormessage.getText()+"...invalid tset passed");
				Reporter.log(errormessage.getText()+"...invalid test passed");
				return  "invalid pass";
			}
			
			
			}catch(Exception e){
				e.printStackTrace();
				return "case fail";
			}
			
	   }

		
			
		}
		
	

	
	



