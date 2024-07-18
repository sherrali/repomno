Feature: Register functionality

Scenario: User creates an account only with mandatory fields
Given User navigates to register account page
When User enters the details into below fields 
|firstName   |shaik                     |
|secondName  |mastanvali                |
|telephone   |1234567890                |
|password    |12345                     |
And User selects privacy policy
And User clicks on continue button
Then User account should get created successfully
 
Scenario: User creates an account with all fields
Given User navigates to register account page
When User enters the details into below fields 
|firstName   |shaik                     |
|secondName  |mastanvali                |
|telephone   |1234567890                |
|password    |12345                     |
And User selects yes for newsletter
And User selects privacy policy
And User clicks on continue button
Then User account should get created successfully 

Scenario: User creates a duplicate account
Given User navigates to register account page
When User enters the details into below fields with duplicate email
|firstName   |shaik                     |
|secondName  |mastanvali                |
|email       |smastan5559@gmail.com |
|telephone   |1234567890                |
|password    |12345                     |
And User selects yes for newsletter
And User selects privacy policy
And User clicks on continue button
Then User should get a proper warning about dulicate email

Scenario: User creates an account without filling any details
Given User navigates to register account page
When User dont enter any details into fields
And User clicks on continue button
Then User should get proper warning message for every mandatory field