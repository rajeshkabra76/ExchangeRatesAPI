@LatestExchange
Feature: Latest Exchange Rates API
  I want to validate the latest exchange rates API for various test conditions

  
  Scenario Outline: Validate Status code of response for Latest exchange rate with Valid data 
  	When I perform GET operation with valid Base "<base>" and Symbols "<symbol>"
    Then I should get "<responseCode>" 
    
    Examples: 
      | base  | symbol 	 | responseCode  	 |
      | EUR	  |   GBP    | 200						 |
      
    
