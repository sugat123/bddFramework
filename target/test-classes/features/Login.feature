Feature: Login feature in demo qa

  Scenario Outline: Verify valid login credentials
    Given I navigate to demo qa login site
    And I enter username "<username>" and password "<password>"
    Examples:
    |username|password|
    | sugat01       | Test@123       |