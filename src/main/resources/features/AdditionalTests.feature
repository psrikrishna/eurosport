
Feature: Use able to watch the Videos from Eurosport
  As a Eurosport customer
  I want to watch my favourite sports videos streams
  So that I can enjoy and follow my favourite sports


  Scenario: Ensure main Tennis events are displayed in menu

    Given I am Eurosport Customer
    And On Videos Hub Page
    When I select to watch the videos from Tennis Section
    And the following top events are displayed
      | Roland-Garros   |
      | Australian Open |
      | Wimbledon       |
      | US Open         |
      | Being Serena    |
      | ATP Calendar    |
      | ATP Rankings    |
      | WTA Calendar    |
      |WTA Rankings     |