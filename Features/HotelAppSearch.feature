Feature: HotelApp search
Description: This test is to check search functionality of the HotelApp.

Background: user is logged in
Given user is on HotelApp homepage
When user enters username
And user enters password
And user clicks on login button

Scenario: search hotel
When user selects location from dropdown
And user clicks on search button
Then list of hotels is displayed

Scenario: select hotel
When user selects location from dropdown
And user clicks on search button
And user selects radio button
And user clicks on continue button
Then book a hotel is displayed