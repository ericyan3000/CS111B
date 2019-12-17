import java.util.Scanner;

public class test {
    public static void main(String[] args) {
      int[] array = new int[] {1, 2, 3, 2, 3};
    //    changeFirstLast(array);
      AdvancedDiceHolder test = new AdvancedDiceHolder(array);
      int[] result = test.largestSet();
      for (int i = 0; i < result.length; i++) {
        System.out.println(result[i]);
      }
        
    }
    
    public static double getScore(int student) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter test grade for student " + student + " :");
        return input.nextDouble();
    }

    public static String determineGrade(double score) {
      switch ((int) score/10) {
        case 10:
        case 9: 
          return "A";
        case 8:
          return "B";
        case 7:
          return "C";
        case 6:
          return "D";
        default: 
          return "F";
      }
    }

    public static void changeFirstLast(Integer[] arr) {
      if (arr.length == 0)
        throw new IllegalArgumentException();
      else
        arr[0] = 0;
        arr[arr.length - 1] = 0;
    }

    public static double getCircleRaidusAverage(MyCircle[] circles) {
      double total = 0;
      int counter = 0;
      for (int i = 0; i < circles.length; i++) {
        if (circles[i].getRadius() >= 0) {
          total += circles[i].getRadius();
          counter++;
        }
        else
          circles[i].setRadius(0.0);
      }
      return (total / circles.length);
    }
 
}

