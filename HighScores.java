/*
input: two arrayList
output: sorted arrayList

algorithm
  1. Since two arrayList are seperated, they needs to be sorted simutaneously 
  with the same index i
  2. using bubble sort algorithm
    a. loop the score list
    b. if the socre is bigger than next one, swap score
    c. also swap the names at the same position
*/


import java.util.*;
import java.util.regex.Pattern;

public class HighScores {

  public static void main(String[] args) {
      ArrayList<String> names = new ArrayList<>();
      ArrayList<Integer> scores = new ArrayList<>();

      initialize(names, scores);
      sort(names, scores);
      display(names, scores);

  }

  public static void initialize(ArrayList<String> names, ArrayList<Integer> scores) {
    Scanner input = new Scanner(System.in);
    String name = new String("");
    int score = 0;
    
    for (int i = 0; i < 5; i++) {
      System.out.print("Enter the name for score #" + (i+1) + ": ");
      do {
        if (input.hasNext(Pattern.compile("[a-zA-Z]+"))){
          name = input.next();
          break;
        }
        else {
          System.out.print("Please enter a valid name: ");
          input.next();
        }
      } while (true);
      names.add(i, name);

      System.out.print("Enter the score for " + name + ": ");
      do {
        if (input.hasNextInt()){
          score = input.nextInt();
          if (score >= 0)
            break;  
          else 
            System.out.print("Please enter a valid positive integer score: ");
        }
        else {
          System.out.print("Please enter a valid positive integer score: ");
          input.next();
        }
      } while (true);
      scores.add(i, score);
    }
  }

  public static void sort(ArrayList<String> names, ArrayList<Integer> scores) {
    boolean sorted = true;
    do {
      sorted = true;
      for (int i = 0; i < scores.size() - 1; i++) {
        if (scores.get(i) < scores.get(i+1)) {
          swap(names, scores, i, i+1);
          sorted = false;
        }
      }
    } while (!sorted);
  }

  public static void swap(ArrayList<String> names, ArrayList<Integer> scores, int i1, int i2) {
    String tempName = names.get(i1);
    int tempScore = scores.get(i1);

    scores.set(i1, scores.get(i2));
    names.set(i1, names.get(i2));

    names.set(i2, tempName);
    scores.set(i2, tempScore);
  }

  public static void display(ArrayList<String> names, ArrayList<Integer> scores) {
    System.out.println("Top Scorers:");
    for (int i = 0; i < names.size(); i++) {
      System.out.print(names.get(i) + ": " + scores.get(i) + "\n");
    }
  }


}