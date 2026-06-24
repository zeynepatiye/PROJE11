Feature: ParaBank Register Functionality

  Scenario: Successful user registration and message verification
    Given The user navigates to the Para Bank home page
    When The user fills out the registration form with valid details
    And The user clicks on the REGISTER button
    Then The user should see the success message "Your account was created successfully. You are now logged in."