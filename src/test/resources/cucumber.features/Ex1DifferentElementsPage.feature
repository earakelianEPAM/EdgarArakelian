Feature: Different Elements Page logging feature

  Scenario: Different Elements Page. Selecting elements.


    Given I open JDI GitHub site
    And I login as user "Roman Iovlev"
    And I click on 'Service' button in Header
    And I click on 'Different Elements' button in Service dropdown

    When I select 'Water' checkbox on Different Elements Page
    And I select 'Wind' checkbox on Different Elements Page
    And I select 'Selen' radio button on Different Elements Page
    And I select 'Yellow' in dropdown on Different Elements Page

    Then The top log row should be containing 'Water: condition changed to true' text in log section
    And The top log row should be containing 'Wind: condition changed to true' text in log section
    And The top log row should be containing 'metal: value changed to Selen' text in log section
    And The top log row should be containing 'Colors: value changed to Yellow' text in log section