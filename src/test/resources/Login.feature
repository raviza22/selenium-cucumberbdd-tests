Feature: Login functionality

  In order to use online travel portal
  As a valid user
  I want to login successfully


# Scenario Outline with Parameters

  Scenario Outline: Login Successfully
    Given I am on the login page
    When I enter valid <username> and <password>
    Then I should be taken to Account page
    Examples:
      | username | password |
      |"user@phptravels.com"|"demouser"|

# Scenario with DataTable usage in Step Def

#  Scenario: Login Successfully
#    Given I am on the login page
#    When I enter valid credentials
#      |user@phptravels.com|demouser|
#    Then I should be taken to Account page