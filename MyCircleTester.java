public class MyCircleTester {
  public static void main(String[] args) {
    Circle[] circleArray = new Circle[3];
    circleArray[0] = new Circle(2.0, 0.0, 0.0);
    circleArray[1] = new Circle(3.0, 5.0, -1.0);
    circleArray[2] = new Circle(6.0, -3, 2.0);

    for (int i = 0; i < circleArray.length; i++) {
      System.out.printf("Circle %d's center is at (%.1f, %.1f), radius is %.1f\n",i+1, circleArray[i].getX(), circleArray[i].getY(), circleArray[i].getRadius());
      System.out.printf("Circle %d has an area of %.2f\n", i+1, circleArray[i].getArea());
    }

    System.out.println();

    for (int i = 0; i < circleArray.length; i++) {
      for (int j = i+1; j < circleArray.length; j++) {
        if (circleArray[i].doesOverlap(circleArray[j]))
          System.out.printf("Circle %d overlaps with circle %d.\n", i+1, j+1);
        else
          System.out.printf("Circle %d does not overlap with circle %d.\n", i+1, j+1);
      }
    }
  }
}