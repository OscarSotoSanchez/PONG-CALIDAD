Feature:End game when player shots more than 5 times

  Scenario:In a play game
    Given The match isn't finished
    When The player touch the screen with two fingers
    And There is only 1 bullet remaining
    Then The game ends


