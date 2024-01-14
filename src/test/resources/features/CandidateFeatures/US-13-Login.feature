Feature: [US_013]Candidate login feature
  User Story:
  On the CANDIDATE page, the user should be able to login as a CANDIDATE

  Background: For the scenarios in the feature file, user is expected to be on login page
    Given User navigates to Main page
    And Accepts Cookies

  Scenario: [TC_001] Login as a Candidate
    When Verifies that the Login button is visible in the Headers section.
    Then Verifies being redirected to the login page.

  @Vip
  Scenario: [ TC_005 --> US_013 ] Login as a Candidate
    When Clicks the Login button.
    And Enters a valid e-mail into the Email box.
    When Enters a valid password into the password box.
    And Clicks the Log In button.
    Then Verifies being on the dashboard page.

  Scenario: [TC_006 --> US_013 ]
    When Clicks the Login button.
    And Enters an invalid e-mail or and invalid password into the relevant boxes.
    When Clicks the Log In button.
    Then Verifies that error messages appear.