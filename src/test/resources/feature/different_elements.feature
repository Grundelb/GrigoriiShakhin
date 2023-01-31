Feature: Different elements page
  @smoke
  Scenario: Different elements test
    Given I open JDI GitHub site
    And I login as user "Roman Iovlev"
    And I click on "Service" button in Header
    And I click on "Different Elements" button in Service dropdown
    When I select "Water" checkbox
    And I select "Wind" checkbox
    And I select radiobutton "Selen"
    And I click on dropdown and select "Yellow"
    Then Log rows should contain following values:
      | Water : condition changed to true |
      | Wind : condition changed to true  |
      | metal : value changed to  Selen   |
      | Colors : value changed to Yellow  |