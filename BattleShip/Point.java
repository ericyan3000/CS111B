

public class Point
{
  private int x;
  private int y;

  public Point(int xValue, int yValue)
  {
    x = xValue;
    y = yValue;
  }

  public Point(Point p) {
    this(p.x, p.y);
  }

  public void setX(int xValue)
  {
    x = xValue;
  }

  public int getX()
  {
    return x;
  }

  public void setY(int xValue)
  {
    y = xValue;
  }

  public int getY()
  {
    return y;
  }

  public boolean equals(Point otherPoint)
  {
    return (this.x == otherPoint.x) && (this.y == otherPoint.y);
  }

  public String toString() {
    return "(" + x + ", " + y + ")";
  }

  public boolean isSameRow(Point other) {
    return this.y == other.getY();
  }

  public boolean isSameCol(Point other) {
    return this.x == other.getX();
  }
}