Feature:
  I want to be able to integration test Spring endpoints

  Scenario:
    Given I have a Spring Endpoint
    When I call the endpoint by name for rooms
    Then Cliffhanger should return from the server