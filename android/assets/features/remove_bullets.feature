Feature:Reduce bullet counter when player shots

  Scenario:In a play game
    Given The match isn't finished
    And The player has <x> shots remaining
    When The player touch the screen with two fingers
    Then The bullet counter is <y>
    And A bullet appears on screen

  Examples: Values
  | x | y |
  | 5 | 4 |
  | 4 | 3 |
  | 3 | 2 |
  | 2 | 1 |


