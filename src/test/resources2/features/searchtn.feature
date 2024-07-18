Feature: Search functionality

Scenario: User searches for valid product
Given User opens the application
When User enters the valid product "HP"
And  User clicks on search button
Then User shold get valid product displayed in search result

Scenario: User searches for invalid product
Given User opens the application
When User enters the invalid product "Honda"
And User clicks on search button
Then User should get a message about no product matching

Scenario: User searches without any product
Given User opens the application
When User dont enter any product 
And User clicks on search button
Then User should get a message about no product matching