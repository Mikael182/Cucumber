Feature: User create new address

  Scenario: user create new address
    Given user open hotel mainPage
    When User go to login and provide Michal01@com.pl and Michal01
    And go to address fill fields Tadeusz,Test,ZUS,Skosna 8,62-100,Poznan,690876512,Tadek 8
    Then address is created
    And close