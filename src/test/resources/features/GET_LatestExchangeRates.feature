@LatestExchange
Feature: Latest Exchange Rates API
  I want to validate the latest exchange rates API for various test conditions

  
  Scenario: Validate response for Latest exchange rate with Valid data 
  	When I perform GET operation with Base and Symbols
  	| base  | symbol 	 |
    | EUR	  |   GBP  |
    Then I should get response code as 200
    And validate the following response
    | base | rates |
    | EUR	 | GBP	 |
    And validate the Content Type as "application/json"
    
  Scenario: Validate response for invaild request
  
  When I make an invalid request
  Then I should get response code as 400
    
      
    
