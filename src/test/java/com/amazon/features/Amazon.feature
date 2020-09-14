
Feature: Verify user is able to search products

Background: User login the application
Given User login the application
@amazontext
Scenario Outline: Verify user should see the amazon text and search

When User should enter Keyword "<Keyword>" in the search box
Then User should click on search button
Then User should see "mobile" in the result
Examples:
|Keyword|
|mobiles|
|laptops|
