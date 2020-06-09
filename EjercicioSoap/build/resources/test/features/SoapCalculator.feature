Feature: Add two numbers on dneonline service
  I as a user want to add two numbers

  Scenario: Add two numbers
    When you add two numbers
        | 2 | 4 |
    Then I should see the response of server is 200