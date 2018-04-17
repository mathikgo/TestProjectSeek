Feature: Test Create Lead functionality

Background:
Given I enter the username as DemoSalesManager
And I enter the password as crmsfa
And I click on the Login Button
And Click CRM/SFA
And Click Create Lead Link


Scenario Outline: Create Lead with only mandate fields
And Enter Company name <cName>
And Enter First name <fname>
And Enter Last name <mname>
When I click on Create Lead button
Then Lead should be created successfully

Examples:
|cName|fname|mname|
|TCS|Sethu Mathavan|Subramanaian|