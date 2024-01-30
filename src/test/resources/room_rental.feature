Feature: Room Rental
  This application is to simulate renting a room from an Airbnb.
  It takes a simple User with a username, a room, and then creates a rental that uses both objects.

  @RegressionTesting
  @SingleScenarioTesting
  Scenario: Rent a single room
    Given I am an existing user with the name "Bryan"
    When I rent a "Cliffhanger" in "SPRING" for 3
    Then my bill is 600


  Scenario Outline: Rent a room
    Given I am an existing user with the name <Name>
    When I rent a <Room> in <Season> for <Days>
    Then my bill is <Amount>

    Examples:
      | Name           | Room          | Season   | Days |  Amount   |
      | "Bryan Hansen" | "Cliffhanger" | "SPRING" |    3 |   600.0   |
      | "Sara Hansen"  | "Slickrock"   | "FALL"   |    5 |   781.25  |
