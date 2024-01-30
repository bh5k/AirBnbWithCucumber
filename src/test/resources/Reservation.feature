Feature:
  I want to test reservations

  Scenario Outline:
    Given the following rooms are available to rent
      | Room Name   | Rate   |
      | Cliffhanger | 100    |
      | Slickrock   | 125    |

    When I book a <Room> in <Season> for <Days>
    Then my bill total is <Amount>

    Examples:
      | Name           | Room          | Season   | Days |  Amount   |
      | "Bryan Hansen" | "Cliffhanger" | "SPRING" |    3 |   600.0   |
      | "Sara Hansen"  | "Slickrock"   | "FALL"   |    5 |   781.25  |