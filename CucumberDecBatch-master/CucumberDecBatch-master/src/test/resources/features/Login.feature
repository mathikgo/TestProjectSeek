@Sethu
Feature: Login into the Leaftaps Application Positive

Scenario Outline: Login Positive Case
And Enter the credentials
|userName|password|
|DemoSalesManager|crmsfa|
#And I enter the username as <uName>
#And I enter the password as <pwd>
When I click on the Login Button
Then I should see the Login successful
And Close the Browser

Examples:
|uName|pwd|
|DemoSalesManager|crmsfa|

Scenario: Login Negative Case
And Enter the credentials
|userName|password|
|DemoSalesManager|crmsfa|
#And I enter the username as DemoSalesManager1
#And I enter the password as crmsfa1
When I click on the Login Button
But Login should be failed