// Enable GOD_MODE in Board.java for easier testing process.
// Game board dimension is set by MAX_COL and MAX_ROW.
// Number of ships could be set by MAX_SHIP.

import java.util.ArrayList;
import java.util.Random;

public class Board {
  private static int MAX_COL = 9;
  private static int MAX_ROW = 9;
  private static int MAX_SHIP = 1;
  private static boolean GOD_MODE = true;
  private ArrayList<Ship> ships = new ArrayList<Ship>(MAX_SHIP);
  private Player playerOne;

  public Board() {
    //System.out.println("GOD_MODE is " + Boolean. toString(GOD_MODE));

    // initialize ships arraylist
    //System.out.println("Inside board constructor.");
    for (int i = 0; i < MAX_SHIP; i++) {
      Random random = new Random();
      // randome ship parameters
      Ship ship;
      do {
        int xValue = random.nextInt(MAX_ROW);
        int yValue = random.nextInt(MAX_COL);
        boolean isVertical = random.nextInt(2) == 0 ? true : false;
        int length = random.nextInt(4) + 2;
        ship = new Ship(new Point(xValue, yValue), isVertical, length);
      // checking if the new ship is out of bound of board or collides with other exiting ships
      } while (ship.isOutOfBound(MAX_ROW, MAX_COL) || !ship.isCompatible(ships));

      ships.add(ship);
    }
  }

  public int getMaxRow() {
    return MAX_ROW;
  }

  public int getMaxCol() {
    return MAX_COL;
  }

  public void addPlayer(Player player) {
    this.playerOne = player;
  }

  public void displayBoard() {
    // transver each coordinate points
    for (int row = MAX_ROW; row >= 0; row--) {
      System.out.print(row + " ");
      for (int col = 0; col <= MAX_COL; col++) {
        Point tempPoint = new Point(col, row);
        boolean isDisplayed = false;
        
        //check if this point is past guess
        if (playerOne.hasPastGuess(tempPoint)) {
        
        // each point need to tranverse the ships arraylist to see if it's hit or sunk
          for (int i = 0; i < ships.size(); i++) {
            
            // if the point in on ship(i)
            if (ships.get(i).containsPoint(tempPoint)) {
              // if sunk
              if (ships.get(i).isSunk()) {
                System.out.print("S ");
                isDisplayed = true;
                break;
              }
              // if just hit
              else if(ships.get(i).isHitAtPoint(tempPoint)) {
                System.out.print("X ");
                isDisplayed = true;
                break;
              }
            }
          }
          if (!isDisplayed) {
            System.out.print(". ");
            isDisplayed = true;
          }
        }
        // reveal ship if GOD_MODE == true
        else if (GOD_MODE) {
          for (int i = 0; i < ships.size(); i++) {
            if (ships.get(i).containsPoint(tempPoint)) {
              System.out.print("O ");
              isDisplayed = true;
              break;
            }
          }
        }
        
        // print ~ for anything else
        if (!isDisplayed)
          System.out.print("~ ");
      }
      System.out.println("");
    }
    System.out.print("  ");
    for (int i = 0; i <= MAX_COL; i++) {
      System.out.print(i + " ");
    }
    System.out.printf("\n\n");
  }

  public boolean isAllShipsSunk() {
    return shipsSunk() == ships.size();
  }

  public void makeShot(Point p) {
    for (int i = 0; i < ships.size(); i++) {
      ships.get(i).shotFiredAtPoint(p);
    }
  }

  public int shipsAlive() {
    int counter = 0;
    for (int i = 0; i < ships.size(); i++) {
      if (!ships.get(i).isSunk())
        counter++;
    }
    return counter;
  }

  public int shipsSunk() {
    int counter = 0;
    for (int i = 0; i < ships.size(); i++) {
      if (ships.get(i).isSunk())
        counter++;
    }
    return counter;
  }

  public void reset() {
    
  }
  
}