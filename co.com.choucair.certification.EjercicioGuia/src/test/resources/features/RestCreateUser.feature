Feature: Create a user on Regres.in
  I want to create a user

  Scenario: User creation
    When you create a user
      | name   | job  |
      | Victor | java |
    Then I should see the user created

