Feature: Automated End2End Tests

 
Scenario Outline: Customer place an order by purchasing an item from search	
	Given user is on Home Page
	When he search for "dress"
	And choose to buy the "1" item
	And add "3" products also moves to checkout from mini cart
	And enter "<customer>" personal details on checkout page
	And place the order
	Then verify Order Placed
Examples:
	|customer|
	|Kiran|
	|Mahendra|
