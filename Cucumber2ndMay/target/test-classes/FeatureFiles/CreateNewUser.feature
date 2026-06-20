@sanity

Feature: Creation of New User

  Scenario Outline: Creation of new User data
    Given user sends API request to create user to server
    And user sends payload data along with request
    When user hits the server with "<endpoint>" along with payload data
    Then validate user creation is done successfully with corresponding status code as "<status_code>"

    Examples: 
      | endpoint  | status_code |
      | api/users |         201 |
