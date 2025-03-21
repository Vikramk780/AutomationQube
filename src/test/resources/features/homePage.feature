Feature: Home Page Functionality for OpenCart E-commerce Website

  As a user of the OpenCart website
  I want to be able to log in with my account
  So that I can perform some action of homepage


  Background:
    Given user has already logged in to application
      | username                          | password   |
      | kvikramautomationtesting@gmail.com | Test@1234  |


  Scenario: Navigating to the desktop page
    Given I click on the desktop button
    Then I should be redirected to the desktop page