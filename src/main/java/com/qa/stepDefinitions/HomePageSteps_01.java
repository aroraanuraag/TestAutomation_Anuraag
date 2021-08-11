package com.qa.stepDefinitions;

import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;


//import org.junit.Assert;

import com.qa.pages.HomePage;
import com.qa.pages.LoginPage;
import com.qa.util.TestBase;
import com.qa.util.TestUtil;

import cucumber.api.DataTable;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class HomePageSteps_01 extends TestBase {

	LoginPage loginpage1;
	HomePage homePage;
	TestUtil testUtil;
	
	private String itemPrice;
	private String totalPrice;
	
	
	//AUTO IT - http://www.guru99.com/use-autoit-selenium.html 
	//GIT Repository for the Code of this PDF report:
	//https://www.youtube.com/redirect?event=comments&redir_token=QUFFLUhqbnZuUXZTcTBBS0RoYjM0WDduY2hVVS16djFQQXxBQ3Jtc0ttekR0cFV3YUVrYjduREtTNXpkU1QtY0FWSmlzdHg5SVBvZXdkd2d4TU0wLV8wUFk5dzFzTXRiN1VnUmpjZU8zb3dpTHBLOXRnLUtieGFuSkxwVlJDaWZyYjhtcWdLSGkzb1hhZ2ZUbU1PZkJtS3dDOA&q=https%3A%2F%2Fgithub.com%2Fnaveenanimation20%2FLatestCucumber6WithPOM.git&stzid=Ugx8XjMQ7Z4zuEA2Sot4AaABAg.9HWRFQvWUcr9HWUgExsgk7
	
	
	
	// Below site helps to setup the PDF report.
	//https://www.programsbuzz.com/article/cucumber-report-generation-using-extent-report-cucumber-6-adapter-grass-shopper

	@Before // @Before and @After are concept of hooks.
	public void setUp() {
		System.out.println("Launch the browser and enter url");
		TestBase.initialization();
	}

	
	// To Implement 'LOGS' in each functions.
	// To Implement 'PDF Reports - Watch Naveen (Extent PDF Report).
	// Make a separate Class (Java class) and implement Getter and Setter. 
	// Getter and Setter is used to get a value and then set a value - Passing values in Function / Method.
	
	// Passing values within Steps of Cucumber is solved by:https://stackoverflow.com/questions/43067617/cucumber-java-how-to-use-returned-string-from-a-step-in-next-step
	
	@Given("^user is on Home Page$")
	public void user_is_on_Home_Page() {

		loginpage1 = new LoginPage();
		driver.manage().timeouts().implicitlyWait(10000, TimeUnit.SECONDS);
		String title = driver.getTitle();
		System.out.println(title);
		Assert.assertEquals("My Store", title);

	}

	  @When ("^user clicks on Women T-shirts$") 
		public void user_clicks_on_Women_T_shirts() {

			// Performing the mouse hover action on the target element.
			Actions actions = new Actions(driver);
			WebElement menuWomen = driver.findElement(By.xpath("//a[@title='Women']"));
			actions.moveToElement(menuWomen).perform();

			/*
			 * WebDriverWait wait2 = new WebDriverWait(driver, 100); WebElement ele1 =
			 * wait2.until(ExpectedConditions.elementToBeClickable(By.xpath(
			 * "//ul[@class='submenu-container clearfix first-in-line-xs']//ul//li//a[contains(text(),'T-shirts')]"
			 * ))); WebElement subMenuTshirts = driver.findElement(By.xpath(
			 * "//ul[@class='submenu-container clearfix first-in-line-xs']//ul//li//a[contains(text(),'T-shirts')]"
			 * )); actions.moveToElement(subMenuTshirts); actions.click().build().perform();
			 */

		}
	
	
	
		@When("^user selects one of the Women \"([^\"]*)\"$")
		public void user_selects_one_of_the_Women(String Options) {

// Performing the mouse hover action on the target element.
			Actions actions = new Actions(driver);
			WebElement menuWomen = driver.findElement(By.xpath("//a[@title='Women']"));
			actions.moveToElement(menuWomen).perform();

			WebElement womenOptions_Selector = driver.findElement(
			By.xpath("//ul[@class='submenu-container clearfix first-in-line-xs']//ul//li//a[contains(text(),'" + Options + "')]"));
			
			
				
			// womenOptions_Selector.click();

			actions.moveToElement(womenOptions_Selector);
			actions.click().build().perform();

		}

	@And ("^user selects either Women T-shirts or Blouses$")
	public void user_selects_either_Women_T_shirts_or_Blouses(DataTable dataT)
	{

		  List<Map<String, String>> userList = dataT.asMaps(String.class,
		  String.class); System.out.println(userList.get(0).get("UserOption"));
		  
		  String txtUserOption = userList.get(0).get("UserOption");
		  System.out.println(txtUserOption);
		  
		  // Performing the mouse hover action on the target element. 
		  Actions actions = new Actions(driver); 
		  WebElement menuWomen = driver.findElement(By.xpath("//a[@title='Women']"));
		  actions.moveToElement(menuWomen).perform();
		  
		  
			if (txtUserOption == "T-shirts") {

				WebElement subMenuTshirts = driver.findElement(By.xpath(
				"//ul[@class='submenu-container clearfix first-in-line-xs']//ul//li//a[contains(text(),'T-shirts')]"));
				actions.moveToElement(subMenuTshirts);
				actions.click().build().perform();

			} else {

				WebElement subMenuBlouses = driver.findElement(By.xpath("//a[@title='Blouses']"));
				actions.moveToElement(subMenuBlouses);
				actions.click().build().perform();

			}
			

	}
	
	



	@And("^user selects Add to cart$")
	public void user_selects_Add_to_cart() throws InterruptedException {
		// Scrolling down on Page.

		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,250)");
		WebDriverWait wait1 = new WebDriverWait(driver, 5000);
		WebElement eleImage = wait1.until(
				ExpectedConditions.elementToBeClickable(By.xpath("//img[@itemprop='image']")));
		
		Actions actions = new Actions(driver);
		WebElement menuAdd_to_Cart_hover = driver.findElement(By.xpath("//img[@itemprop='image']"));
		actions.moveToElement(menuAdd_to_Cart_hover).perform();

		WebDriverWait wait2 = new WebDriverWait(driver, 100);
		WebElement element2 = wait2.until(ExpectedConditions
				.elementToBeClickable(By.xpath("//a[@title='Add to cart']")));
		WebElement subMenu_AddtoCart_Click = driver
				.findElement(By.xpath("//a[@title='Add to cart']"));
		actions.moveToElement(subMenu_AddtoCart_Click);
		actions.click().build().perform();

	}

	@And("^user Verifies Item is added to Cart and selects Proceed to checkout$")
	public void user_Verifies_Item_is_added_to_Cart_and_selects_Proceed_to_checkout() throws InterruptedException

	{

		WebDriverWait wait = new WebDriverWait(driver, 100);
		WebElement ele_ProceedtoCheckout = wait.until(ExpectedConditions.elementToBeClickable(
				By.xpath("//a[@class='btn btn-default button button-medium' and @title='Proceed to checkout']")));

		String TxtBoxContent = driver
				.findElement(
						By.xpath("//a[@class='btn btn-default button button-medium' and @title='Proceed to checkout']"))
				.getText();
		Assert.assertEquals("Proceed to checkout", TxtBoxContent);

		//span[@xpath='1']
		
		driver.findElement(
				By.xpath("//a[@class='btn btn-default button button-medium' and @title='Proceed to checkout']"))
				.click();

	}
	


	@And("^user clicks on Proceed to checkout on the Summary Page$")
	public void user_clicks_on_Proceed_to_checkout_on_the_Summary_Page()
	{
		
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,250)");
	
	
		
		//Make a separate Class and implement Getter and Setter
		// Implement above by: http://www.thinkcode.se/blog/2017/04/01/sharing-state-between-steps-in-cucumberjvm-using-picocontainer
		//VERY VERY imp : http://www.thinkcode.se/blog/2017/04/01/sharing-state-between-steps-in-cucumberjvm-using-picocontainer
		
		
		String txt_totalCost = driver.findElement(By.xpath("//span[@id='total_price']")) .getText();
		System.out.println("Total Cost is" + txt_totalCost);
		
		String new_string = txt_totalCost.replace("$","");
		System.out.println(new_string);
		
		itemPrice = new_string;
		
		System.out.println(itemPrice);
		
		
		// To IMPLEMENT : http://www.thinkcode.se/blog/2017/04/01/sharing-state-between-steps-in-cucumberjvm-using-picocontainer to the code here..
		
		/*
		 * int i = Integer. parseInt(new_string); System.out.println(i);
		 */
		 
		//Assert.assertEquals(txt_totalCost, "$18.51");
		 
		// span[contains(text(),'$18.51') and @id='total_price']

		/*
		 * driver.findElement(By.xpath(
		 * "//a[@class='button btn btn-default standard-checkout button-medium' and @title='Proceed to checkout']"
		 * )) .click();
		 */

		
		
	}
	
	/*
	 * @Then("^User pays (\\d+) USD$") public void user_pays_USD(int arg1) throws
	 * Throwable { // Write code here that turns the phrase above into concrete
	 * actions throw new PendingException(); }
	 */
	
	
	@And("^user selects Title,State,Country and enters following Account details with columns for registration$")
	public void user_selects_Title_State_Country_and_enters_following_Account_details_with_columns_for_registration(
			DataTable dataTable) {

		List<Map<String, String>> userList = dataTable.asMaps(String.class, String.class);
		System.out.println(userList.get(0).get("FName"));

		WebDriverWait wait = new WebDriverWait(driver, 5000);
		WebElement radioButton_title = wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@type='radio' and @id='id_gender1']")));
		radioButton_title.click();

		driver.findElement(By.xpath("//input[@name='customer_firstname']")).sendKeys(userList.get(0).get("FName"));

		driver.findElement(By.xpath("//input[@name='customer_lastname']")).sendKeys(userList.get(0).get("LName"));

		driver.findElement(By.xpath("//input[@name='passwd']")).sendKeys(userList.get(0).get("Pwd"));

		driver.findElement(By.xpath("//input[@name='address1']")).sendKeys(userList.get(0).get("Address"));

		driver.findElement(By.xpath("//input[@name='city']")).sendKeys(userList.get(0).get("City"));

		Select dropdown_State = new Select(driver.findElement(By.xpath("//select[@name='id_state']")));
		dropdown_State.selectByVisibleText("Florida");

		driver.findElement(By.xpath("//input[@name='postcode']")).sendKeys(userList.get(0).get("Zip"));

		Select dropdown_Country = new Select(driver.findElement(By.xpath("//select[@name='id_country']")));
		dropdown_Country.selectByVisibleText("United States");

		driver.findElement(By.xpath("//input[@name='phone_mobile']")).sendKeys(userList.get(0).get("Mobile"));

		driver.findElement(By.xpath("//button[@name='submitAccount']")).click();

	}

	@And("^user types \"([^\"]*)\" and clicks on Create an Account$")
	public void user_types_and_clicks_on_Create_an_Account(String EmailAddress) throws InterruptedException {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,150)");

		Thread.sleep(100);
		String randomString = RandomStringUtils.randomAlphanumeric(8);
		System.out.println(randomString);
		WebDriverWait wait = new WebDriverWait(driver, 5000);
		WebElement text_Email = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//input[@type='text' and @id='email_create']")));
		
		String fEmailAddress = randomString.concat(EmailAddress);
		text_Email.sendKeys(fEmailAddress);

		Thread.sleep(50);
		driver.findElement(By.xpath("//button[@type='submit' and @id='SubmitCreate']")).click();

	}
	
	
	@And("^user clicks Proceed to checkout on the Address Page$")
	public void user_clicks_Proceed_to_checkout_on_the_Address_Page() {

		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,200)");

		WebDriverWait wait = new WebDriverWait(driver, 5000);
		WebElement AddressPage = wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("//button[@class='button btn btn-default button-medium']")));
		driver.findElement(By.xpath("//button[@class='button btn btn-default button-medium']")).click();

	}
	
	@And("^user selects the Terms of service Checkbox and clicks Proceed to checkout on Shipping Page$")
	public void user_selects_the_Terms_of_service_Checkbox_and_clicks_Proceed_to_checkout_on_Shipping_Page() 
	{

		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(0,200)");
		
		WebDriverWait wait = new WebDriverWait(driver, 5000); 
		WebElement AddressPage = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='checker']")));
		driver.findElement(By.xpath("//div[@class='checker']")).click();
		
		driver.findElement(By.xpath("//button[@class='button btn btn-default standard-checkout button-medium']")).click();
		
		
		//Integer.parseInt(getNumberText().getText());
		
	}

		
	@And("^user Verifies final Payment and selects Pay by bank wire on Payment page$")
	public void user_Verifies_final_Payment_and_selects_Pay_by_bank_wire_on_Payment_page() {

		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,150)");

		WebDriverWait wait = new WebDriverWait(driver, 5000);
		WebElement AddressPage = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@title='Pay by bank wire']")));
		
		
		String finalCost = driver .findElement(By.
		 xpath("//span[@id='total_price']")).getText();
		
		String verify_TotalCost = finalCost.replace("$","");
		System.out.println(verify_TotalCost);
		
		 System.out.println(itemPrice);
		 Assert.assertEquals(verify_TotalCost, itemPrice);
		 
		driver.findElement(By.xpath("//a[@title='Pay by bank wire']")).click();

	}

	@And("^user clicks on I confirm my order button on ORDER SUMMARY page$")
	public void user_clicks_on_I_confirm_my_order_button_on_ORDER_SUMMARY_page() {

		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,150)");

		WebDriverWait wait = new WebDriverWait(driver, 5000);
		WebElement AddressPage = wait.until(ExpectedConditions.elementToBeClickable(
				By.xpath("//button[@class='button btn btn-default button-medium' and @type='submit']")));
		driver.findElement(By.xpath("//button[@class='button btn btn-default button-medium' and @type='submit']"))
				.click();

	}


		@Then("^user verifies the Order is completed$")
		public void user_verifies_the_Order_is_completed() {

			JavascriptExecutor jse = (JavascriptExecutor) driver;
			jse.executeScript("window.scrollBy(0,120)");
			WebDriverWait wait = new WebDriverWait(driver, 5000);
			WebElement ordConfirm_Page = wait.until(
					ExpectedConditions.elementToBeClickable(By.xpath("//h1[normalize-space()='Order confirmation']")));

			String finalOrderCompletion = driver
					.findElement(By.xpath("//strong[normalize-space()='Your order on My Store is complete.']"))
					.getText();
			Assert.assertEquals("Your order on My Store is complete.", finalOrderCompletion);
		}
		
		


		@After
		public void tearDown(Scenario scenario) {
			if (scenario.isFailed()) {
				final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
				// embed it in the report.
				scenario.embed(screenshot, "image/png");

			}
		}

		@Then("^user closes the Browser")
		public void user_closes_the_Browser() {
			System.out.println("Exit from the browser");
			driver.close();
		}

}
