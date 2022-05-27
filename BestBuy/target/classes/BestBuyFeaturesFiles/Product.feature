Feature: Verify the product path of best buy api

Scenario Outline: To verify the response when valid product is created
Given I make a POST request with valid product '<product>' name
Then verify response code 201
Examples: 
		|product|
		|Apple  |
		|Mangoes|


Scenario Outline: To validate GET product is successful when valid limit and skip parameters are passed
    Given I make a GET product with valid parameters Limit <limit> and Skip <skip>
     Then verify response code is 200
     Then I verify the first id is 346575
      Examples: 
      | limit | skip | 
      | 10    | 9    |
    
