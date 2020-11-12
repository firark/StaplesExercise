Feature: Google search

  Scenario: Seeking website of Staples in Gdansk
    Given Open the browser
    And I am taken to Google Homepage
    When I enter text to search "Staples Solutions Gdansk"
    And Submit the search with Enter
    Then I am taken to results page
    And Staples Solutions page is displayed as one of the results.
    Then I quit the browser

  Scenario: Using Feeling Lucky button to get to first result of "Staples Solutions Gdansk" search.
    Given Open the browser
    And I am taken to Google Homepage
    When I enter text to search "Staples Solutions Gdansk"
    And Submit the search with I'm Feeling Lucky button
    Then I am taken to staplespolska.pl Landing page
    Then I quit the browser

  Scenario: Finding no results with long, non-existent word search.
    Given Open the browser
    And I am taken to Google Homepage
    When I enter text to search "StaplesSolutionsGdanskPolskaSearchWithNoResultsThisTime"
    And Submit the search with Enter
    Then I am taken to results page
    But There are no results for that search
    Then I quit the browser