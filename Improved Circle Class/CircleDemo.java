public class CircleDemo {
  public static void main(String[] args) {
    Circle[] circleArray = new Circle[4];
    circleArray[0] = new Circle(new Point(2.0, 0.0), 10.0);
    circleArray[1] = new Circle(3.0, 5.0, 1.0);
    circleArray[2] = new Circle();
    circleArray[3] = new Circle(circleArray[2]);

    for (int i = 0; i < circleArray.length; i++) {
      System.out.println("Circle " + (i+1));
      System.out.println(circleArray[i] + "\n");
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

    System.out.println("\nTest #setCenter()");
    Circle testCircle = new Circle();
    System.out.println(testCircle);
    testCircle.setCenter(new Point(1.0, 1.1));
    System.out.println("After:\n" + testCircle);

    System.out.println("\nTest #copy constructor");
    Circle duplicateCircle = new Circle(testCircle);
    System.out.println("After duplicate:\n" + duplicateCircle);

    System.out.println("\nTest #equals");
    if (testCircle.equals(duplicateCircle))
      System.out.println("The duplicateCircle equals to the testCircle.");
    else
      System.out.println("The duplicate one does NOT equal to the test circle.");

  }
}