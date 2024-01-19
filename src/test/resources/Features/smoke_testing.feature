@ZEROBANK_SMOKE_TESTING

Feature: As a User, I want to make sure that all major functionalities are working fine

  @SmokeTest @Login_feature @Navigation_feature @Logout_feature
  Scenario: Test the user is able to login and test the primary navigation feature of the application.
    Given User launches the Zero Bank Home page
    And User clicks the SignIn button on the Navbar
    When User enters valid login and password
    And User clicks the Sign In button
    Then User goes back when Browser error occurs
    And User should navigate to the Home page
    Then User clicks on Online Banking page
    And User is on Online Banking page
    Then User clicks on Feedback page
    And User is on Feedback page