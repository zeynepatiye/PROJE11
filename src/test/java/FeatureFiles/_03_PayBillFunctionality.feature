Feature: Bill Pay Functionality

  Background:
    Given The user navigates to the Para Bank home page
    When The user fills out the registration form with valid details
    And The user clicks on the REGISTER button

  Scenario Outline: User should be able to pay different types of bills successfully
    And the user navigates to the "Bill Pay" page
    When the user pays the bill with details "<PayeeName>", "<Address>", "<City>", "<State>", "<ZipCode>", "<Phone>", "<Account>", "<Amount>"
    Then the system should verify that the bill has been paid successfully with message "Bill Payment Complete"

    Examples:
      | PayeeName           | Address         | City      | State       | ZipCode | Phone      | Account | Amount |
      | Electricity Company | 101 Electricity | Istanbul  | Turkiye     | 10001   | 5551112233 | 998877  | 85     |
      | Water Company       | 202 Water       | Rotterdam | Netherlands | 20002   | 5554445566 | 445566  | 45     |
      | Gas Company         | 303 Gas         | Bangkok   | Tayland     | 30003   | 5557778899 | 112233  | 120    |