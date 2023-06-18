#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
# (Comments)
#Sample Feature Definition Template@RegressionTesting
Feature: Performing one sample scenario
 I want to Excetute test case 01
 
Background:
Given User is on landing Page
 
@tag1
Scenario Outline: Login to App and go to Admin and PIM
Given User is logged in with <username> and <password>
When User click on Admin Page
And Search for Particular Admin
Then User click on PIM page
And Search for PIM User
Examples:
	|username	|password|
	|Admin		|admin123|
	


