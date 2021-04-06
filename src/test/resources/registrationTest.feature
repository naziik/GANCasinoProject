Feature: Registration Test for GAN app

  Scenario Outline: Testing registration page fields
    Given user navigates to Gan home page
    When user click JOIN NOW button
    When user select "<title>" from dropDown
    When user enters its "<firstName>" and "<surName>"
    When user check the checkBox in I accept the Terms and Conditions and certify that I am over the age of 18
    Then user submit by clicking JOIN NOW
    Then user validates message "This field is required" under the date of birth box
    Examples:
      | title | firstName | surName        |
      | Miss  | Nazgul    | Kozhemberdieva |