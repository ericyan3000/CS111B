public class MyCircle {
  private double radius, x, y;

  public MyCircle(double r, double x, double y) {
    this.radius = r;
    this.x = x;
    this.y = y;
  }

  public void setRadius(double r) {
    this.radius = r;
  }

  public double getRadius() {
    return radius;
  }

  public void setX(double x) {
    this.x = x;
  }

  public double getX() {
    return x;
  }

  public void setY(double y) {
    this.y = y;
  }

  public double getY() {
    return y;
  }

  public double getArea() {
    return Math.PI * Math.pow(radius, 2);
  }

  public boolean doesOverlap(MyCircle otherCircle) {
    double distance = Math.sqrt(Math.pow((y - otherCircle.getY()),2) 
      + Math.pow((x - otherCircle.getX()),2));
    return distance < radius + otherCircle.getRadius();
  }
}