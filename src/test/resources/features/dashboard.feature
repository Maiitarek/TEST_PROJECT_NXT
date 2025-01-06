Feature: Admin Dashboard Automation

  Scenario: Login to the dashboard
    Given I open the Admin login page
    When I login with username "testinguser" and password "Y60MqBDTbxH"
    Then I should see the dashboard
    And I click on event


  Scenario Outline: Verify all pages for errors
#    Given I am on the Admin dashboard
    And I click on any "<URL>"
    Examples:
      | URL          |
      | content      |
      | registration |
      | planning     |
      | reports      |
      | explore      |
      | itinerary    |
      | sendupdates  |
      | packages     |
      | sessions     |
      | attendees    |
      | applications |
      | usersreports |

  Scenario: Add an attendee with a trip
    Given I am on the Attendees page and I add new User
    When I add user to a trip
