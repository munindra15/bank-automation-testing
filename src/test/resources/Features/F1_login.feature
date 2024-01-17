@ZEROBANK_SIGNIN
Feature: I want to login into the Zero Bank portal page

  Background: User should be on the SignIn page
    Given User launches the Zero Bank Home page
    And User clicks the SignIn button on the Navbar

  @ZeroBank_login_valid_credential
  Scenario: User should be logged in with valid username and password
    Given User is on the signIn page
    When User enters valid login and password
    And User clicks the Sign In button
    Then User goes back when Browser error occurs
    And User should navigate to the Home page
    Then User logout from account


  @ZeroBank_login_invalid_credential
  Scenario: User should be logged in with invalid username and password
    Given User is on the signIn page
    When User enters invalid login and password
    And User clicks the Sign In button
    Then Wrong credentials error displayed

  @ZeroBank_login_invalid_username_and_valid_password
  Scenario: User should be logged in with invalid username and valid password
    Given \User is on the signIn page
    When User Enters invalid username
    And User Enters valid Password
    And User clicks the Sign In button
    Then Wrong credentials error displayed

  @ZeroBank_login_valid_username_and_invalid_password
  Scenario: User should be logged in with valid username and invalid password
    Given User is on the signIn page
    When User enters valid username
    When User enters invalid password
    And User clicks the Sign In button
    Then Wrong credentials error displayed