@GetListUsers
Feature: To perform deserialization and get employees having odd employee id

  Scenario: To GET employee having odd employee numbers
    Given I make a GET user with valid parameters page
      | 2  | 
    Then I verify response code is 200 for reqres
     