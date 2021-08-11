package com.qa.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

//import com.crm.qa.pages.HomePage;
import com.qa.util.TestBase;

public class LoginPage extends TestBase {

	//Page Factory  - Object repository or Page Objects.
	
		@FindBy(xpath="//input[@type='email']")
		WebElement textUsername;
		
		@FindBy(xpath="//input[@type='submit']")
		WebElement nextBtn;
		
		@FindBy(xpath="//input[@name='passwd']")
		WebElement textPassword;
		
		@FindBy(xpath="//input[@value='Yes']")
		WebElement clickYes;
		
		
		//Initializing the Page Objects.
		
		//public LoginPage()
		public LoginPage()
		{
			PageFactory.initElements(driver,this);
			
		}
		
		//Actions or Features available on Login Page.
		public String validateLoginPageTitle() 
		{
			return driver.getTitle();	
		}
		
		
		public HomePage login(String usname, String pwd)
		
		{
			
			textUsername.sendKeys(usname);
			nextBtn.click();
			textPassword.sendKeys(pwd);
			
			driver.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);
			
			JavascriptExecutor je = (JavascriptExecutor) driver;
			WebElement SignIn_Btn= driver.findElement(By.xpath("//input[@value='Sign in']"));
			je.executeScript("arguments[0].scrollIntoView(true);",SignIn_Btn);
			SignIn_Btn.click();
			
			clickYes.click();

			return new HomePage();
			
		}
		

		
}
