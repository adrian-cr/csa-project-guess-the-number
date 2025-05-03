package org.cognizant.csa;

import java.util.Random;
import java.util.Scanner;

import static java.util.Arrays.asList;

public class GuessTheNumber {
  public static void main(String[] args) {
    /* Global variable setup: */
    
    int bestScore = 0;
    /* Game environment execution: */
    executionLoop:
    while (true) {
      Scanner sc = new Scanner(System.in);
      /* Introductory message: */
      System.out.println("\nWelcome to \"THE NUMBER\", a guessing game!");
      /* Game configuration setup: */
      System.out.println(
        "\n" +
        
        "Please select game's difficulty:\n\n" +
                
        "* Easy (Unlimited attempts) [enter \"E\"]\n" +
        "* Medium (20 attempts) [enter \"M\"]\n" +
        "* Hard (10 attempts) [enter \"H\"]\n\n" +

        "(Enter \"EXIT\" to exit the program.)"
      );
      String difficulty = sc.nextLine().toUpperCase();
      if (difficulty.equals("EXIT")) break executionLoop;
      if (!asList("E", "M", "H").contains(difficulty)) {
        System.out.println("*****Please enter a valid difficulty value*****\n".toUpperCase());
        continue;
      }
      String mode = difficulty.equals("E")? "easy" : difficulty.equals("M")? "medium" : "hard";
      System.out.print("You have selected " + mode.toUpperCase() + " mode\n\n");
      
      /* Range check */
      boolean rangeValid = false;
      int rangeStart;
      int rangeEnd;
      do {
        System.out.print("Please enter the range start number: ");
        rangeStart = sc.nextInt();
        System.out.print("Please enter the range end number: ");
        rangeEnd = sc.nextInt();
        rangeValid = rangeEnd-rangeStart>0? true : false;
        if (rangeValid) break;
        System.out.println("\n*****Please enter a valid range*****\n".toUpperCase());
        
      } while (!rangeValid);
      
      
      /* Configuration summary: */
      System.out.println("\n" + "You have chosen to play in " + mode.toUpperCase() + " mode\nfor a range from " + rangeStart + " to " + rangeEnd + ". Let's play!\n\n" + "------------------ THE NUMBER ------------------");
      
      /* In-game variable setup */
      int winningNumber = new Random().nextInt(rangeEnd-rangeStart+1) + rangeStart;
      int attemptsLeft = mode.equals("hard")? 10 : mode.equals("medium")? 20 : 0;
      int score = 0;
      boolean win = false;
      
      /* Game execution */
      gameLoop:
      while (mode.equals("easy")? true : attemptsLeft>0) {
        /* Score increase: */
        score++;
        
        /* Guess input: */
        System.out.print("Please enter your guess" + (!mode.equals("easy")? " (" + attemptsLeft + " attempts left): " : ": "));
        int userNumber = sc.nextInt();
        
        /* Equality check: */
        if (userNumber==winningNumber) {
          win = true;
          break gameLoop;
        }//if
        
        /* Outcome display: */
        System.out.println("Sorry, the number is " + (userNumber>winningNumber? "SMALLER":"BIGGER") + " than " + userNumber + ".\n");
        attemptsLeft--;
        
      }//while - gameLoop
      
      /*Best score check: */
      bestScore = bestScore==0? score : bestScore>score? score : bestScore;
      
      /* Results display: */
      System.out.println(win? "\nCongratulations! You've guessed THE NUMBER (" + winningNumber + ")! :)".toUpperCase() : "\nSorry, you lost. THE NUMBER was " + winningNumber + "! :( Maybe next time?");
      System.out.println("\nYour score is: " + score);
      System.out.println("Your best score is: " + bestScore);
      System.out.println("\n---------------------------------\n");
      
      /* New game check: */
      System.out.println("(Enter any key to start a new game. Enter \"exit\" to exit.)");
      String newGame = sc.next().toUpperCase();
        if (newGame.equals("EXIT")) break executionLoop;
    }//while - executionLoop
    
    /* Closing message: */
    System.out.println("\nThanks for playing. Goodbye! :)");
  }//main()
}//Main