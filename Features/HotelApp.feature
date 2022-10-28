Feature: HotelApp login
Description: This test is to check login functionality of the HotelApp.

Scenario: Login successful
Given user is on HotelApp homepage
When user enters username
And user enters password
And user clicks on login button
Then login is successful