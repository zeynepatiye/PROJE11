Feature: Para Bank Login Functionality

  Background:
    Given The user navigates to the Para Bank home page

  # Case 1: login olunamadığı için, register ile login olundu.
  Scenario: Successful Login and Logout (Case 1)
    When The user fills out the registration form with valid details
    And The user clicks on the REGISTER button
    Then User should see logout.
    When User clicks Logout

  # Case 2: Geçersiz username ve password ile giriş denemeleri
  Scenario Outline: Invalid Login Tests with Various Combinations (Case 2)
    When The user fills out the registration form with username "<username>" and password "<password>"
    And The user clicks on the REGISTER button
    Then User should see the error message "<result>"


    Examples:
      | username      | password   | result                             |
      |               | 123456test | Username is required.              |
      | fakerUsername |            | Password is required.              |

    # Burda login olunamadığı için,registerda username ve password yerine boşluk bırakılarak ,
    # register olunması engellendi ve doğrulama alındı.