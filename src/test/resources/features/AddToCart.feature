Feature: Cart Functionality

  Scenario: Verify product added successfully
    Given user opens the app
    Then verify user successfully opens the app
    When user clicks on login button
    And click on continue button
    Then verify user is on home page
    When user search for "Tea"
    Then verify user is on products page
    When user clicks on first product
    Then verify user is on product description page
    When user clicks on add to cart button
    Then verify product is added into cart successfully