import java.util.Scanner;
import java.util.ArrayList;

public class Player {
  private String name;
  private Point currentGuess;
  private Board board;
  private ArrayList<Point> pastGuesses;

  // Constructor
  public Player(String name, Board board) {
    this.name = name;
    this.board = board;
    int max_guess = (board.getMaxCol() + 1) * (board.getMaxRow() + 1);
    this.pastGuesses = new ArrayList<Point>(max_guess);
  }

  // Getting coordinate from player, validating before return
  public Point makeGuess() {
    Scanner input = new Scanner(System.in);
    Point entry;

    do {
      System.out.print("Enter a coordinate: ");
      int xValue = input.nextInt();
      int yValue = input.nextInt();
      entry = new Point(xValue, yValue);

      if (!isValidCoordinate(entry))
        System.out.println("Coordinate is out of bound. Game board is " + board.getMaxCol() + "x" + board.getMaxRow() + ": ");

      if (hasPastGuess(entry))
        System.out.println("Coordinate is already tried before.");

    } while (!isValidCoordinate(entry));

    pastGuesses.add(entry);

    return entry;
    
  }

  // check for valid coordinate entry
  public boolean isValidCoordinate(Point p) {
    return p.getX() <= board.getMaxCol() && p.getY() <= board.getMaxRow() && !hasPastGuess(p);
  }

  // check if a point in a the guess arraylist
  public boolean hasPastGuess(Point p) {
    for (int i = 0; i < pastGuesses.size(); i++) {
            if (pastGuesses.get(i).equals(p))
                return true;
        }
        return false;
  }

  public void showAllGuesses() {
    System.out.print("Past guess: ");
    for (int i = 0; i < pastGuesses.size(); i++) {
      System.out.print(pastGuesses.get(i).toString() + " ");
    }
    System.out.println("");
  }
}