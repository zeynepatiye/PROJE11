Feature: Contact Information Update

  Background:
    Given The user navigates to the Para Bank home page
    When The user fills out the registration form with valid details
    And The user clicks on the REGISTER button

    Scenario: Successfull Inter Account Money Transfer
      Given User Navigates to Open New Account and Makes New Account
      And User navigates to Transfer Funds
      And User Transfers Money
      Then The user should see should see the transfer message "Transfer Complete"
