Feature: Verify screen size, Price and Item location filters tags are applied

  Background: 
    Given user is on ebay home page

  Scenario: Check filter tags are applied
    When user navigate to Shop By Category
    And user navigate to Electronics
    And user click on CellPhones & accesories
    And user click Cell Phones & Smartphones in the left hand side navigation section
    And user click on See All Shop by brand
    And user applied three filter as "screen size, Price and Item location"
    Then user verify the filter tags are "screen size, Price and Item location"
