import java.util.Scanner;

public class GuessingProgram {
  public static void main(String[] args) {
    do {
      playOneGame();
    } while (shouldPlayAgain());
  }

  public static void playOneGame() {
    final int MIN = 1;
    final int MAX = 100;
    NumberGuesser guess = new NumberGuesser(MIN, MAX);
    char response = 'a';

    System.out.println("Guess a number between " + MIN + " and " + MAX + ".");

    do {
      if (response == 'h') 
        guess.higher();
      else if (response == 'l') 
        guess.lower();

      response = getUserResponseToGuess(guess.getCurrentGuess());

    } while (response != 'c');

    System.out.print("Great! ");
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

