import java.util.ArrayList;

public class Ship {
	public ArrayList<Point> deck = new ArrayList<Point>();
	private ArrayList<Point> deckHit = new ArrayList<Point>();

	public Ship(Point origin, boolean isVertical, int length) {
        deck.add(origin);
        int counter = 1;
        do {
            if (isVertical)
                deck.add(new Point(origin.getX(), origin.getY() + counter));
            else
                deck.add(new Point(origin.getX() + counter, origin.getY()));
            counter++; 
        } while (counter < length) ;
	}

	public boolean containsPoint(Point p) {
		for (int i = 0; i < deck.size(); i++) {
            if (deck.get(i).equals(p))
                return true;
        }
        return false;
	}

	public boolean collidesWith(Ship s) {
        for (int i = 0; i < deck.size(); i++) {
            if (s.containsPoint(deck.get(i)))
                return true;
        }
        return false;
	}

    public void shotFiredAtPoint(Point p) {
        if (this.containsPoint(p))
            deckHit.add(p);
    }

    public boolean isHitAtPoint(Point p) {
        for (int i = 0; i < deckHit.size(); i++) {
            if (deckHit.get(i).equals(p))
                return true;
        }
        return false;
    }

    public int hitCount() {
        return deckHit.size();
    }

    public int shipSize() {
        return deck.size();
    }

    public boolean isOutOfBound(int max_row, int max_col) {
        //System.out.println("1");
        for (int i = 0; i < deck.size(); i++) {
            Point tempPoint = deck.get(i);
            if (tempPoint.getX() > max_row || tempPoint.getY() > max_col)
                return true;
        }
        return false;
    }

    public boolean isCompatible(ArrayList<Ship> ships) {
        //System.out.println("2");
        for (int i = 0; i < ships.size(); i++) {
            if (this.collidesWith(ships.get(i)))
                return false;
        }
        return true;
    }

    public boolean isSunk() {
        return hitCount() == deck.size();
    }
}