// Enable GOD_MODE in Board.java for easier testing process.

import java.util.Scanner;

public class BattleShip {
  public static void main(String[] args) {
    
    // initialize a game board and player
    Board game = new Board();
    Player person = new Player("Eric", game);
    game.addPlayer(person);
    

    do {
      do {
        welcomeMessage(game);
        Point guess = person.makeGuess();
        //System.out.println(test.toString());
        //person.showAllGuesses();
        game.makeShot(guess);
        game.displayBoard();
      } while (!game.isAllShipsSunk());
    } while (isAnotherGame(person));

  }

  public static void welcomeMessage(Board game) {
    System.out.println("Welcome to Battle Ship Game\n");
    System.out.println(game.shipsAlive() + " ships hidden, " + game.shipsSunk() + " ships sunk");
    game.displayBoard();
  }

  public static boolean isAnotherGame(Player person) {
    Scanner input = new Scanner(System.in);
    System.out.println("It took " + person.totalMove() + " moves to hit all ships.");
    System.out.println("Would you like another game(Y/N): ");
    char response = input.next().charAt(0);
    return response == 'y' || response == 'Y';
  }
}