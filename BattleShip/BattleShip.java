public class BattleShip {
  public static void main(String[] args) {
    
    // initialize a game board and player
    Board game = new Board();
    Player person = new Player("Eric", game);
    game.addPlayer(person);
  
    do {
      Point test = person.makeGuess();
      System.out.println(test.toString());
      person.showAllGuesses();
      game.displayBoard();
    } while (!game.isAllShipsSunk());
  }
}