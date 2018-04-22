Feature:The ball hit a wall

  Scenario:In a play game
    Given The ball is in motion
    When The ball touches one side of the screen
    Then The ball should appear on the oposite side of the screen, with same angle
