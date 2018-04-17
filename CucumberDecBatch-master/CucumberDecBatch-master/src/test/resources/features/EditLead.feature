Feature: Test Edit Lead functionality

Background:
And I enter the username as DemoSalesManager
And I enter the password as crmsfa
And Click CRM/SFA
And Click Leads Link
And Click Find Leads
And Enter first name as Sethu Mathavan
And Click Find leads button
And Click on first resulting lead
And Click Edit button


Scenario Outline: Edit Lead (Positive)
And Enter Company name <cName>
When Click Update button
Then Confirm the changed name appears

Examples:
|cName|
|Wipro|