Feature: Different elements page

Scenario Different elements test
Given I open JDI GitHub site
And I login as user "Roman Iovlev"
And I click on "Service" button in Header
And I click on "Different Elements" button in Service dropdown
When I select checkboxes "Water" and "Wind"
And I select radiobutton "Selen"
And I click on dropdown and select "Yellow"
Then Log rows should contain following values:
| Number | Element         | Description                      |
| 1       | Water         | : condition changed to true       |
| 2     | Wind            | : condition changed to true       |
| 3     | metal           | : value changed to  Selen         |
| 4     | Colors          | : value changed to Yellow         |