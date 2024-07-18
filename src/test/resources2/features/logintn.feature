Feature: Login functionality

Scenario: Login with valid credentials
Given User navigated to login page
When User enters valid email address "smastan5559@gmail.com"
And User enters valid password "Mastan123"
And User clicks login button
Then User should got successfulley logged in

Scenario: Login with invalid credentials 
Given User navigated to login page
When User enters invalid email address
When User enters invalid password "mastan123"
And User clicks login button
Then User should get a proper warning message about credentials missmatch

Scenario: Login with valid email and invalid password 
Given User navigated to login page
When User enters valid email address "smastan5559@gmail.com"
And User enters invalid password "mastan123"
And User clicks login button
Then User should get a proper warning message about credentials missmatch

Scenario: Login with invalid email and valid password
Given User navigated to login page
When User enters invalid email address 
And User enters valid password "Mastan123"
And User clicks login button
Then User should get a proper warning message about credentials missmatch

Scenario: Login without providing any credentials
Given User navigated to login page
When User dont enter email address
And User dont enter password
And User clicks login button
Then User should get a proper warning message about credentials missmatch
