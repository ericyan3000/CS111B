import java.util.Scanner;

// Zexi Yan

public class Asterisks {
  public static void main(String[] args) {
    int count;
    String response = "y";
    Scanner input = new Scanner(System.in);

    while (!(response.equals("n"))) {
      System.out.print("How many asterisks?: ");
      count = input.nextInt();
      input.nextLine();

      for (int i=0; i<count; i++) {
        System.out.print("*");
      }
      System.out.print("\n");

      System.out.print("Go again? (y/n): ");
      response = input.nextLine();
    }
    
  }
}