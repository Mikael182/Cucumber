Feature: DuckDuckGo Search

  Scenario: user can search any keyword
    Given open browser with duckduckgo
    When a keyword selenium is provided in search field
    Then the first record should contain selenium
    And quit browser

  Scenario Outline: user can search any keywords
    Given open browser with duckduckgo
    When a keyword <keyword> is provided in search field
    Then the first record should contain <expectedKeyWord>
    And quit browser

    Examples:
      | keyword  | expectedKeyWord |
      | java     | java            |
      | cucumber | cucumber        |
      | michal   | michal          |
