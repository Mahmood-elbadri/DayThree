Feature: Check the quantity

  Scenario: check the quantity and update it
    Given navigate to the site
    And click on mobile menu
    When in the menu click add sony to cart
    And change the quantity value to 1000 and update it
    And verify the error msg
    Then click empty card
    And verify card is empty