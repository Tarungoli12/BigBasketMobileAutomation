Feature: Sorting Functionality

  Background:
    Given user opens the app
    When user clicks start shopping button and sets location
    Then verify user is on home page
    When user search for "product.name"
    Then verify user is on products "product.name" page
    When user clicks on filter button

  Scenario Outline: Verify products are sorted as specified
    And selects the sorting type "<sorting type>"
    Then verify products are sorted as specified "<sorting type>"
    Examples:
      | sorting type        |
      | Price - Low to High |
      | Price - High to Low |


    Scenario: Verify products are sorted with discount
      And selects the sorting type "% Off - High to Low"
      Then verify products are sorted from high discount to low discount

