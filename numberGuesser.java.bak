/*
  getRandomMidpoint(low, up) -> random midpoint int
    randomize a number between up and low
  getUserResponseToGuess(int) -> char ('c', 'h', 'l')
    print the guess
    get user response
  shouldPlayAgain() -> boolean 
    prompt for response
    get response
    return true of false 


  initialize low 1, up 100, guess, response
  prompt for guess
  do {
    update low = guess if response == 'h'
    update high =guess if response == 'l'
    guess = getRandomMidpoint(low, high)
    response = getUserResponseToGuess(guess)
  } while (response != 'c')
*/

import java.util.Scanner;
import java.util.Random;

public class numberGuesser {
  public static void main(String[] args) {
    do {
      playOneGame();
    } while (shouldPlayAgain());
  }

  public static void playOneGame() {
    int low = 1;
    int high = 100;
    int guess = 0;
    char response = 'a';

    System.out.println("Guess a number between 1 and 100.");

    do {
      if (response == 'h') 
        low = guess + 1;
      else if (response == 'l') 
        high = guess - 1;

      guess = getRandomMidpoint(low, high);
      response = getUserResponseToGuess(guess);

    } while (response != 'c');

    System.out.print("Great! ");
  }

  public static int getRandomMidpoint(int low, int high) {
    Random random = new Random();
    int range = high - low + 1;
    int number = random.nextInt(range) + low;
    return number;
  }

  public static char getUserResponseToGuess(int guess) {
    Scanner input = new Scanner(System.in);
    System.out.print("Is it " + guess + "?  (h/l/c):");
    char response = input.next().charAt(0);
    return response;
  }

  public static boolean shouldPlayAgain() {
    Scanner input = new Scanner(System.in);
    
    do {
      System.out.print("Do you want to play again? (y/n): ");
      char play = input.next().charAt(0);
      if (play == 'y')
        return true;
      else if (play == 'n')
        return false;
    } while (true);
  }
}

