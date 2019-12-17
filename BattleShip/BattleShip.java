// Enable GOD_MODE in Board.java for easier testing process.

import java.util.Scanner;

public class BattleShip {
  public static void main(String[] args) {
    
    // initialize a game board and player
    welcomeMessage();
    
    do {
      Board game = new Board();
      Player person = new Player("Eric", game);
      game.addPlayer(person);

      do {
        updateMessage(game);
        Point guess = person.makeGuess();
        //System.out.println(test.toString());
        //person.showAllGuesses();
        game.makeShot(guess);
        game.displayBoard();
      } while (!game.isAllShipsSunk());
      displayResult(person);
    } while (isAnotherGame());

  }

  public static void welcomeMessage() {
    System.out.println("Welcome to Battle Ship Game\n");
  }

  public static void updateMessage(Board game) {
    System.out.println(game.shipsAlive() + " ships hidden, " + game.shipsSunk() + " ships sunk");
    game.displayBoard();
  }

  public static void displayResult(Player person) {
    System.out.println("It took " + person.totalMove() + " moves to hit all ships.");
  }

  public static boolean isAnotherGame() {
    Scanner input = new Scanner(System.in);
    System.out.println("Would you like another game(Y/N): ");
    char response = input.next().charAt(0);
    return response == 'y' || response == 'Y';
  }
}