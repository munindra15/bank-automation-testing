@ZEROBANK_TRANSFER_FUNDS
Feature: I want to transfer funds within my accounts

  Background: User should be logged in the system
    Given User launches the Zero Bank Home page
    And User clicks the SignIn button on the Navbar
    When User enters valid login and password
    And User clicks the Sign In button
    Then User goes back when Browser error occurs
    And User should navigate to the Home page

  @ZeroBank_transfer_funds_from_single_account_to_Checking_account
  Scenario Outline: Test that the user can transfer funds within their multiple accounts
    Given User is on Online Banking page
    And User clicks on Transfer Funds page
    When User selects "<from_account_name>" in from account dropdown
    And User selects "<to_account_name>" in to account dropdown
    Then User enters amount in the Amount input
    And User enters description in the Description box
    Then User clicks on the Continue button
    And Verify money transfer page is displayed
    Then User clicks on the Submit button
    And Successfully transfer message is displayed
    Then User logout from account
    Examples:
      | from_account_name | to_account_name |
      | 1000              | checking        |
      | 1000              | 1548            |
      | 1000              | loan            |
      | 1000              | credit card     |
      | 1000              | brokerage       |
      | 1548              | checking        |
      | 1548              | savings 1000    |
      | 1548              | loan            |
      | 1548              | credit card     |
      | 1548              | brokerage       |
      | checking          | 1000            |
      | checking          | 1548            |
      | checking          | loan            |
      | checking          | credit card     |
      | checking          | brokerage       |
      | loan              | 1000            |
      | loan              | 1548            |
      | loan              | checking        |
      | loan              | credit card     |
      | loan              | brokerage       |
      | credit card       | 1000            |
      | credit card       | 1548            |
      | credit card       | checking        |
      | credit card       | loan            |
      | credit card       | brokerage       |
      | brokerage         | 1000            |
      | brokerage         | 1548            |
      | brokerage         | checking        |
      | brokerage         | loan            |
      | brokerage         | credit card     |

