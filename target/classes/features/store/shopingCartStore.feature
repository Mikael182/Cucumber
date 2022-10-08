Feature: By new products

  Scenario: User make new order
    Given Main page is open
    When user is loged in his account with Michal01@com.pl and Michal01
    Then user will create new order
    And check if order is created and take screenshot
    Then test is finished
