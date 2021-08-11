Feature: Test- Women Tops Order Process 
##With Examples Keyword: Here Scenario Outline is needed.
Scenario Outline: Verify Womens Tops Order processing functionality 
	Given user is on Home Page 
	When user clicks on Women T-shirts 
	And user selects one of the Women "<Options>" 
	And user selects Add to cart 
	And user Verifies Item is added to Cart and selects Proceed to checkout 
	
	And user clicks on Proceed to checkout on the Summary Page 
	And user types "<EmailAddress>" and clicks on Create an Account 
	And user selects Title,State,Country and enters following Account details with columns for registration 
		|FName|LName|Pwd|Address|City|Zip|Mobile|
		|Krishna|Krishna|Waheguru@01|9,Bonney Avenue,Clayfield|Brisbane|00001|0410312300|
		|Matt|MAtt|Waheguru@01|9,Bonney Avenue,Clayfield|Brisbane|00001|0410312300|	
		
	And user clicks Proceed to checkout on the Address Page 
	And user selects the Terms of service Checkbox and clicks Proceed to checkout on Shipping Page 
	And user Verifies final Payment and selects Pay by bank wire on Payment page 
    And user clicks on I confirm my order button on ORDER SUMMARY page 
	Then user verifies the Order is completed 
	And user closes the Browser 

	###Below is a Parameterisation example using Examples.
	Examples: 
		|Options|EmailAddress|
		|T-shirts|@in.com|
		
		
		
# "Then" is always used for verification purposes. (See above example).
		
		
		
		
		
		
		
		
		
		
		
		
		
		#Feature: Test- Women Tops Order Process 
		#
		#Scenario: Verify Womens Tops Order processing functionality  
		#     
		#Given user is on Home Page 
		#Then user clicks on Women T-shirts 
		#Then user selects Add to cart 
		#Then user Verifies Item is added to Cart and selects Proceed to checkout 
		#Then user clicks on Proceed to checkout on the Summary Page 
		#Then user types "<EmailAddress>" and clicks on Create an Account 
		#When user selects Title,State,Country and enters following Account details with columns for registration
		#   |FName|LName|Pwd|Address|City|Zip|Mobile|
		#   |Krishna|Krishna|Waheguru@01|9,Bonney Avenue,Clayfield|Brisbane|00001|0410312300|
		#   
		##And user selects Title, "<FName>","<LName>","<Pwd>","<Address>","<City>", State,"<Zip>",Country,"<Mobile>" and clicks on Register 
		#Then user clicks Proceed to checkout on the Address Page 
		#Then user selects the Terms of service Checkbox and clicks Proceed to checkout on Shipping Page 
		#Then user Verifies final Payment and selects Pay by bank wire on Payment page 
		#And user clicks on I confirm my order button on ORDER SUMMARY page 
		#Then user verifies the Order is completed 
		
		
		#Scenario Outline: Verify CRM's Contacts creation functionality
		#Given user opens the browser
		#When user is on Login Page
		#Then User types "<username>" and clicks Next
		#Then User types "<password>" and clicks SignIn button
		#Then User clicks on the Yes option
		#Then User validates Dynamics CRM home page title Page
		#Then on the Home Page user clicks on Contacts Menu
		#Then user clicks on New button
		#And User enters Contact details "<firstname>" "<lastname>" "<JobTitle>" "<Email>" "<MobileNumber>" and clicks Save
		#Then user verifies Contact Creation
		#
		#
		##Below is a Parameterisation example using Examples.
		#Examples:
		#     | username | password | firstname | lastname | JobTitle | Email | MobileNumber |
		#     | admin@crm898120.onmicrosoft.com | P2nEbs012T | Tom | Moody | Cricketer| tom@gmail.com | 0410312333 |
