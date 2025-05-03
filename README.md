# Project: Guess the Number

This project contains the code for a Java program to play "Guess the Number," which can be run from the project's `GuessTheNumber` class.

## Key Features
* **Random Number Generation**: The program generates a random number between a predefined minimum and maximum range. This range is set by the user.
* **User Input**: The program prompts the user to enter their guesses and validates the input to ensure it's a valid integer within the specified range.
* **Feedback**: After each guess, the program provides feedback to the user, indicating whether the guess is too high or too low. It should also keep track of the number of attempts.
* **Win/Lose Conditions**: The game continues until the user correctly guesses the number or exceeds the maximum allowed attempts, after which it displays a win or lose message accordingly.
* **Play Again**: After the game ends, the program asks the user if they want to play again. If they choose to play again, a new random number is generated, and the game starts over.
* **User-Friendly Interface**: The program implements a user-friendly text-based interface with clear instructions and messages to guide the player through the game.
## Optional Enhancements Implemented
* **Difficulty Levels**: The program implements different difficulty levels that change the number of attempts allowed, making the game more challenging for advanced players.
* **High Score Tracking**: The program keeps track of high scores (fewest attempts to guess correctly) and displays them at the end of each game.