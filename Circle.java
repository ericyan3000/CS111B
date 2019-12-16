public class Circle {
  private Point center;
  private double radius, xValue, yValue;

  public Circle(Point point, double r) {
    this.center = new Point(point);
    this.xValue = point.getX();
    this.yValue = point.getY();
    this.radius = r;
  }

  public Circle(double xValue, double yValue, double r) {
    this.xValue = xValue;
    this.yValue = yValue;
    this.center = new Point(xValue, yValue);
    this.radius = r;
  }

  public Circle() {
    xValue = 0;
    yValue = 0;
    center = new Point(xValue, yValue);
    radius = 1;
  }

  public Circle(Circle c) {
    this(c.getCenter(), c.getRadius());
  }

  public Point getCenter() {
    return new Point(center);
  }

  public void setCenter(Point p) {
    this.center = new Point(p);
  }

  public void setRadius(double r) {
    this.radius = r;
  }

  public double getRadius() {
    return radius;
  }

  public void setX(double x) {
    this.xValue = x;
  }

  public double getX() {
    return xValue;
  }

  public void setY(double y) {
    this.yValue = y;
  }

  public double getY() {
    return yValue;
  }

  public double getArea() {
    return Math.PI * Math.pow(radius, 2);
  }

  public String toString() {
    return String.format("This circle has center of (%.2f, %.2f).\nThe radius is %.2f.\nThe area is %.2f.", center.getX(), center.getY(), radius, this.getArea());
  }

  public boolean equals(Circle c) {
    if (center.equals(c.getCenter()) && radius == c.getRadius()) 
      return true;
    else
      return false;
  }

  public boolean doesOverlap(Circle c) {
    return center.distance(c.getCenter()) <= radius + c.getRadius();
  }
}