Feature:
  I want to be able to integration test Spring endpoints

  Scenario:
    Given I have a Rest Spring Endpoint
    When I call the room endpoint by name for rooms
    Then Cliffhanger is the result from the server