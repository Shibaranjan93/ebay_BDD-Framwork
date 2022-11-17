Feature: User verify string  result in search bar

  Background: 
    Given user is on ebay home page

  Scenario: Verify any search string in the search bar
    When user enter string in Search Bar as "MacBook"
    And user change the Search category as "Computers/Tablets & Networking"
    And user click on Search
    Then user verify the page completely
    And user verify the first result name matches with the search string as "Macbook"
