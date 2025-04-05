Feature: Bookstore Login and Book Search

  Background:
    Given User is on the login page
    And User enter "PratikPatil" and "Pratik@patil09"
    When User clicks on login button
    Then Username & Logout button should be visible

  Scenario: Search book and write details
    When User clicks on Book Store Application
    And User searches for "Learning JavaScript Design Patterns"
    Then Search results should include "Learning JavaScript Design Patterns"
    And Book details should be saved to a file
    When User clicks on Logout
    Then User should be redirected to login page
