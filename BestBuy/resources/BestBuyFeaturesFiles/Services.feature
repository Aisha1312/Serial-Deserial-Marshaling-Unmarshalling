Feature: To validate Services path of best buy API

  Scenario Outline: To validate GET service is successful when valid limit and skip parameters are passed
    Given I make a GET service with valid parameters Limit <limit> and Skip <skip>
     Then I verify response code is 200
      Examples: 
      | limit | skip | 
      | 10    | 3    | 
      | 15    | 5    | 
  
   
  Scenario Outline: To validate POST service is successful when service name is passed
    Given I make a POST service with Service '<service>' name
     Then I verify response code is 201
    Examples: 
      | service     | 
      | trade       |
      | hospitality |
     

   