Feature: HotelApp login Param
Description: This test is to check login functionality of the HotelApp.

Scenario: Login successful
Given user is on HotelApp homepage
When user enters username "vasuvespag"
And user enters password "vasu1234"
And user clicks on login button
Then login is successful