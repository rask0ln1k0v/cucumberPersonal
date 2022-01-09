
@cloudTables
Feature: DDT example with Cloudtables

  Scenario Outline: Adding multiple users to the table
    Given User is on cloudtables homepage
    When User clicks on New button
    When User enters "<firstname>" to firstname field
    And User enters "<lastname>" to lastname field
    And User enters "<position>" to position field
    And User enters "<salary>" to salary field
    And User clicks on create button
    Then User "<firstname>" and "<lastname>" should be created

    Examples:
      | firstname | lastname | position            | salary |
      | Suarez    | R        | SDET                | 115000 |
      | Cavani    | U        | Automation Engineer | 150000 |
      | Ronaldo   | S        | Developer           | 130000 |
      | Messi     | E        | UI Developer        | 180000 |
