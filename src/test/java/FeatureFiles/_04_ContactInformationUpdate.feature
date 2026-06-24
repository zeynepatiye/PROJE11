Feature: Contact Information Update

  Background:
    Given The user navigates to the Para Bank home page
    When The user fills out the registration form with valid details
    And The user clicks on the REGISTER button

  Scenario: Successful user information update
    Given User navigates to Update Contact Info
    And write username as Datatable
      | Sevgi |
      | Burak |
      | Yigit |
    And The user clicks on the Update button
    Then The user should see the update message "Profile Updated"