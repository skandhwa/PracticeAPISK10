@sanity

Feature: Create New User Go rest

  Scenario Outline: New User Creation Go rest
    Given user hits the go rest website
    And user enters the auth token
    And user send the credentails data
    When user hits the go rest site with "<endpoint>"
   # Then verify that new user is created and validates "<status_code>"

    Examples: 
      | endpoint        | status_code |
      | public/v2/users |         201 |
