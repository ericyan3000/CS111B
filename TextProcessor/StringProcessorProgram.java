import java.util.Scanner;

public class StringProcessorProgram {
  public static void main(String[] args) {
    do {
      StringProcessor sentence = new StringProcessor(getUserInput());
      showOutput(sentence);


    } while (playAgain());
  }

  public static boolean playAgain() {
    Scanner input = new Scanner(System.in);
    
    do {
      System.out.print("Do you want to enter another? (y/n): ");
      char play = input.next().charAt(0);
      if (play == 'y')
        return true;
      else if (play == 'n')
        return false;
    } while (true);
  }

  public static String getUserInput() {
    Scanner input = new Scanner(System.in);
    System.out.print("Enter a line of text: ");
    String sentence = input.nextLine();
    return sentence;
  }

  public static void showOutput(StringProcessor sentence) {
    System.out.println("words: " + sentence.wordCount());
    System.out.println("uppercase: " + sentence.uppercaseCount());
    System.out.println("digits: " + sentence.digitCount());
    System.out.println("digit words: " + sentence.digitWord());
    System.out.println("line with whitespace removed: \"" + sentence.getNoSpaceString() + "\"");
    System.out.println("line with vowel replaced: \"" + sentence.getNoVowelString() + "\"");
    System.out.println("line with digit words replaced: \"" + sentence.getNoDigitWordString() + "\"");
  }
}