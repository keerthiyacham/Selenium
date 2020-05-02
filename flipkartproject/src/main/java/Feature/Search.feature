Feature:Flipkart Application Test

@SmokeTest
Scenario: Successful login with valid credentials and search for a product
	Given User opens the browser
	When User enters Username and  Password 
	Then User is on home page
	Then search bar should enabled
	Then User search for a product
	Then User is on that product page
	Then close the browser