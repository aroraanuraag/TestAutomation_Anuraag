package com.qa.pages;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.qa.util.TestBase;

public class HomePage extends TestBase{
	
	
	WebDriverWait wait = new WebDriverWait(driver, 10000);
	
	
	 ExtentReports report; 
	 ExtentTest logger;
	 
	@FindBy(xpath="//span[contains(text(),'Sales')]")
	WebElement crmLoginVerify;
	
	@FindBy(xpath="//input[@aria-label='Last Name']")
	WebElement textLastName;
	
	@FindBy(xpath="//input[@aria-label='Job Title']")
	WebElement textJobTitle;
	
	@FindBy(xpath="//input[@aria-label='Email']")
	WebElement textEmail;
	
	@FindBy(xpath="//input[@aria-label='Mobile Phone']")
	WebElement textMobilePhone;
	
	@FindBy(xpath="//span[@class='cp s dg dh di dj ai an am']")
	WebElement click_ContactsMenu;
	
	@FindBy(xpath="//a[@title='Women']")
	WebElement hover_Women;
	

	//Initialising the Page Objects by Defining the Constructor below.
	public HomePage()
	{
		PageFactory.initElements(driver, this);
		
	}

	
	public String verifyHomePageTitle() throws InterruptedException
	{
		driver.wait(500);
		driver.manage().timeouts().implicitlyWait(20000, TimeUnit.SECONDS);
		System.out.println(driver.getTitle());
		return driver.getTitle();
	}
	
	

public void click_ContactsMenu()
	{
		
		WebDriverWait wait = new WebDriverWait(driver, 100);
		WebElement ContactsMenu = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//img[@role='presentation' and  @title='Contacts']")));
		
		ContactsMenu.click();
		
	}
	
	
	public void click_NewOption()
	{
		
		WebDriverWait wait = new WebDriverWait(driver, 100);
		WebElement NewOption = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@aria-label='New']")));
		
		NewOption.click();
		
	}
	
	
	
	
	public void enterFirstName(String FirstName) throws InterruptedException
	{
		//driver.wait(500);
		driver.manage().timeouts().implicitlyWait(10000, TimeUnit.SECONDS);
		WebDriverWait wait = new WebDriverWait(driver, 5000);
		WebElement Firstname_Text = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@aria-label='First Name']")));
		
		Firstname_Text.sendKeys(FirstName);
		
	}
	

	
	public void enterLastName(String LastName) throws InterruptedException
	{
		
		//driver.wait(100);
		driver.manage().timeouts().implicitlyWait(10000, TimeUnit.SECONDS);
		// Date and time format
		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
		
		Date date = new Date();
		
		String date1 = dateFormat.format(date);
		
		
		textLastName.sendKeys(LastName +date1);
		
	}
	
	
	
	public void enterJobtitle(String JobTitle) throws InterruptedException
	{
		driver.manage().timeouts().implicitlyWait(10000, TimeUnit.SECONDS);
		textJobTitle.sendKeys(JobTitle);
	
	}
	
	
	
	public void enterEmail(String Email) throws InterruptedException
	{
		driver.manage().timeouts().implicitlyWait(10000, TimeUnit.SECONDS);
		textEmail.sendKeys(Email);

		
	}
	
	
	
	public void enterMobileNo(String MobilePhone) throws InterruptedException
	{
		
	  driver.manage().timeouts().implicitlyWait(10000, TimeUnit.SECONDS);
      textMobilePhone.sendKeys(MobilePhone);
		
	}
	

	
  public void clickSave()
	{

	WebDriverWait wait = new WebDriverWait(driver, 500);
	WebElement clickSave = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@aria-label='Save' and @data-id='contact|NoRelationship|Form|Mscrm.Form.contact.Save']")));
	
	clickSave.click();
	
	}
	
	
	public boolean verify_ContactCreation() throws InterruptedException
	
	{
        WebDriverWait wait = new WebDriverWait(driver, 200);
		WebElement confirmed_ContactCreated = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@aria-label='Assign']")));
		return confirmed_ContactCreated.isDisplayed();
		
	}
	
	
	
	public void quit_the_Browser()
	{
		driver.quit();
	}
	

}
