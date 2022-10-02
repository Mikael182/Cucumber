Feature: Hotel user registration

  Scenario: new user register
    Given user open hotel main page
    When User go to login page
    And populate form with Jan,Kowalski,JanKow01 and use register button
    Then account is created
    And close browser

  Scenario Outline: new user register
    Given user open hotel main page
    When User go to login page
    And populate form with <firstname>,<lastname>,<password> and use register button
    Then account is created
    And close browser

    Examples:
      | firstname | lastname  | password   |
      | Michal    | Jablonski | Jablon123! |
      | Dariusz   | Wierzba   | Dario123!  |
      | Marcin    | Dlugi     | Dlugi123!  |
      | Dorota    | Paslega   | Pas123!    |