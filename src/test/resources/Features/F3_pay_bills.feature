@ZEROBANK_PAY_BILLS
Feature: I want to pay bills from my account

  Background: User should be logged in the system
    Given User launches the Zero Bank Home page
    And User clicks the SignIn button on the Navbar
    When User enters valid login and password
    And User clicks the Sign In button
    Then User goes back when Browser error occurs
    And User should navigate to the Home page

  @ZeroBank_pay_bill_to_saved_payee_from_different_account
  Scenario Outline: Test that the user can pay bills to already existing payee from differet accounts
    Given User is on Online Banking page
    And User clicks on Pay Bills link
    And User is on the Pay Saved Payee page
    When User selects "<saved_payee>" from Payee dropdown list
    And User selects "<from_account_name>" from Account dropdown list
    Then User enters amount in the Payee Amount input
    And User enters "<date>" in the Date input
    And User enters description in the Payee Description box
    Then User clicks on the Pay button
    And Successfully paid to payee message is displayed
    And User logout from account
    Examples:
      | saved_payee     | from_account_name | date       |
      | Sprint          | savings           | 2024-01-15 |
      | Apple           | Checking          | 2024-01-16 |
      | Bank of America | savings           | 2024-01-10 |
      | Wells Fargo     | Loan              | 2024-01-14 |
      | Sprint          | Credit Card       | 2024-01-12 |
      | Apple           | Brokerage         | 2024-02-15 |


  @ZeroBank_pay_bill_add_new_payee
  Scenario: Test that the user can add new payee
    Given User is on Online Banking page
    And User clicks on Pay Bills link
    Then User clicks on the Add New Payee link
    And User is on the Add New Payee page
    Then User enters "Walmart" in the Payee Name input
    And User enters "Walmart Fairway, Kitchener" in the Payee Address box
    And User enters "4512895645239854" in the account input
    And User enters "Walmart EMI" in the Payee Details input
    Then User clicks on the Add button
    And Successfully new Payee message is displayed
    Then User logout from account


  @ZeroBank_pay_bill_purchase_foreign_currency_cash
  Scenario Outline: Test that the user can purchase foreign currency cash
    Given User is on Online Banking page
    And User clicks on Pay Bills link
    Then User clicks on the Purchase Foreign Currency link
    And User is on the Purchase Foreign Currency page
    Then User selects "<Currency>" from the list
    And User enters Amount in the Foreign Currency amount input
    And User selects "<Selling_Currency>" by clicking radio button
    Then User clicks on the Calculate Costs
    And User clicks on the Purchase button
    And Successfully Foreign Currency Cash Purchase message is displayed
    Then User logout from account
    Examples:
      | Currency      | Selling_Currency  |
      | Australia     | USD               |
      | Australia     | Selected Currency |
      | Canada        | USD               |
      | Canada        | Selected Currency |
      | Switzerland   | USD               |
      | Switzerland   | Selected Currency |
      | China         | USD               |
      | China         | Selected Currency |
      | Denmark       | USD               |
      | Denmark       | Selected Currency |
      | Eurozone      | USD               |
      | Eurozone      | Selected Currency |
      | Great Britain | USD               |
      | Great Britain | Selected Currency |
      | Hong Kong     | USD               |
      | Hong Kong     | Selected Currency |
      | Japan         | USD               |
      | Japan         | Selected Currency |
      | Mexico        | USD               |
      | Mexico        | Selected Currency |
      | Norway        | USD               |
      | Norway        | Selected Currency |
      | New Zealand   | USD               |
      | New Zealand   | Selected Currency |
      | Sweden        | USD               |
      | Sweden        | Selected Currency |
      | Singapore     | USD               |
      | Singapore     | Selected Currency |
      | Thailand      | USD               |
      | Thailand      | Selected Currency |
