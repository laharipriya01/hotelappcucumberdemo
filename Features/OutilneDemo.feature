Feature: HotelApp login
Description: This test is to check login functionality of the HotelApp.

Scenario Outline: Login successful
Given user is on HotelApp homepage
When user enters username as <"<username>">
And user enters password as <"<password>">
And user clicks on login button
Then login is successful

Examples:
| username | password |
| vasuvespag | vasu1234 |
| aryan1207 | Aryan@120799 |