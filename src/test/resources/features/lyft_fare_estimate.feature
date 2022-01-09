@lyft
Feature: Searching Lyft fare details
  As a rider, I should be able to enter pickup
  and drop off locations so that I can see the estimated fare.

  Scenario: Fare estimate using City
    Given User is lyft fare estimate page
    When User enters "Brooklyn, NY, USA" to pickup address
    And User enters "Manhattan, New York, NY, USA" to drop address
    And User clicks on get estimate
    Then User should see estimated prices

  Scenario: Fare estimate using full address
    Given User is lyft fare estimate page
    When User enters "33 E 17th St, New York, NY 10003" to pickup address
    And User enters "1484 3rd Ave, New York, NY 10028" to drop address
    And User clicks on get estimate
    Then User should see estimated prices

  Scenario: Fare estimate using empty should show error
    Given User is lyft fare estimate page
    When User enters "" to pickup address
    And User enters "" to drop address
    And User clicks on get estimate
    Then User should see error message


