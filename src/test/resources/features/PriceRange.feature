Feature: Price Range Functionality

  Scenario Outline: Verify products displayed in specified price range
    Given user opens the app
    When user clicks start shopping button and sets location
    Then verify user is on home page
    When user search for "rice"
    Then verify user is on products "rice" page
    When user clicks on filter button
    And selects the price range "<lowest price>" "<highest price>"
    Then verify products displayed are in specified price range "<lowest price>" "<highest price>"

    Examples:
      | lowest price | highest price |
      | 21           | 50            |
      | 51           | 100           |
      | 101          | 200           |
      | 201          | 500           |

