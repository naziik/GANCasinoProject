Feature: FIRSTNAME_LASTNAME_MG

  @PasswordCriteria
  Scenario Outline: New User / Valid Password
    Given The main registration form
    When A user fills the password field
    Then The validator should allow a minimum length of 6
    And The user registers a new user with a valid password at least 6 characters which should contains
      | "\\p{Punct}" |
      | [^A-Z]       |
      | [^a-z]       |
      | [^0-9]       |
    And User should try fill "<Password>" and with examples
    Examples:
      | Password    |
      | ABCD123ef   |
      | @#%%123ef   |
      | sadkksiqmm  |
      | ABSDBOPPOWQ |
      | 110239844   |
      | BD#$7       |
    And User should see error message
    And Password should be encrypted and store to database