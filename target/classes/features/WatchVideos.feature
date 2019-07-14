
Feature: Use able to watch the Videos from Eurosport
  As a Eurosport customer
  I want to watch my favourite sports videos streams
  So that I can enjoy and follow my favourite sports

  Scenario: User is able to watch Tennis sports streaming

    Given I am Eurosport Customer
    And On Videos Hub Page
    When I select to watch the videos from Tennis Section
    Then the selected video is playing
    And the following player controls are displayed
      | Play     |
      | Pause    |
      | Maximize |