Feature: User create new address

  Scenario: New address is created
    Given user open store mainPage
    When User go to loginPage and provide Michal01@com.pl and Michal01
    And go to address tab fill fields Test01, Tadeusz, Test, Skośna1, Poznan, 61-009
    Then check if address is created
    And end test