#yagizorhan.
  # considering user already have an account
Feature: Sign-in function test case

  @positive
  Scenario: User should be able to login with valid credentials
    Given user navigates to BBC website and clicks sign in
    And User logs in
    Then user should be on the home page

  @negative
  Scenario: User should not be able to log in with unvalid credentials
    Given user navigates to BBC website and clicks sign in
    And User enters unvalid credentials
   Then User should see error message

    @second
    Scenario: User should be able to change their postcode
      Given user navigates to BBC website and clicks sign in
      And User logs in
      And user navigates to your account page and clicks settings
      And user changes their postcode
      Then new postcode should appear
