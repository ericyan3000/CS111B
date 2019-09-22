import java.util.Scanner;

public class test {
    public static void main(String[] args) {
        
        for (int i = 0; i<10; i++) {
          int rand = (int)(Math.random() * 10 + 1);
          System.out.println(rand);

        }
        // double s1 = getScore(1);
        // double s2 = getScore(2);
        // double s3 = getScore(3);
        // double s4 = getScore(4);
        // double s5 = getScore(5);

        // String g1 = determineGrade(s1);
        // String g2 = determineGrade(s2);
        // String g3 = determineGrade(s3);
        // String g4 = determineGrade(s4);
        // String g5 = determineGrade(s5);

        // double average = calcAverage(s1, s2, s3, s4, s5);

        // System.out.print("Student 1: " + g1 + "\n");
        // System.out.print("Student 2: " + g2 + "\n");
        // System.out.print("Student 3: " + g3 + "\n");
        // System.out.print("Student 4: " + g4 + "\n");
        // System.out.print("Student 5: " + g5 + "\n");
        // System.out.printf("The average grade was: %.2f%n", average);
        
        
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

    public static double calcAverage(double s1, double s2, double s3, double s4, double s5) {
      double average = (s1 + s2 + s3 + s4 + s5 ) / 5;
      return average;
    }
}

