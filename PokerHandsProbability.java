/*
input: array (user input)
output: boolean (multiple boolean)

algorithm:
  
  1. greeting
  2. initialize array, assign each element by askForCard() * 5
  3. sort the array
  4. run checks one by one
  5. ouput result.


  askForCard() 
    while (true) {
      prompt user to enter a number from 2-9
      if input >= 2 and input <= 9, return input
      else print invalid input.
    }

  printHand(int[])
    print the given array as poker hand.

  bubbleSort() -> sort and return an array
    boolean swap
    do { 
      swap = false
      loop through the array up to size - 2 {
        if arr[i] < arr[i+1], swap them; swap = true;
      } while (swap)    
    }

  containsFourOfaKind(int[] hand)
    either first four or last four are the same

  containsFullHouse
    XXYYY or XXXYY

  containsStraight
    X, X+1, X+2, X+3, X+4

  containsThreeOfaKind
    XXXYZ, XYYYZ, XYZZZ

  containsTwoPair
    remove duplicate -> 3 element left

  containsPair
    remove duplicate -> 4 element left

*/

import java.util.Scanner;
import java.util.Random;
import java.util.InputMismatchException;

public class PokerHandsProbability {
  public static void main (String[] args) {
    //System.out.println("Enter five numeric cards, no face cards. Use 2 - 9.");
    
    int counter = 0;
    final long maxCount = 1000000;
    int[] occurance = new int[7];

    do {
      int[] hands = new int[5];
      for (int i = 0; i < hands.length; i++) {
        //System.out.print("Card " + (i+1) + ": ");
        hands[i] = randCardValue();
      }

      sortHands(hands);
      //printHands(hands);

      if (containsFourOfaKind(hands))
        occurance[0]++;
      else if (containsFullHouse(hands))
        occurance[1]++;
      else if (containsStraight(hands))
        occurance[2]++;
      else if (containsThreeOfaKind(hands)) 
        occurance[3]++;
      else if (containsTwoPair(hands))
        occurance[4]++;
      else if (containsPair(hands))
        occurance[5]++;
      else
        occurance[6]++;

      counter ++;
    } while (counter < maxCount);

    for (int i = 0; i < occurance.length; i++) {
      System.out.printf("%.2f%%; ", (occurance[i]*100.0/maxCount));
    }
    System.out.println("\n");
  }

  public static int askForCard() {
    Scanner input = new Scanner(System.in);
    int card = 0;
    boolean valid = false;
    do {
        if (input.hasNextInt()) {
          //System.out.print("has next int now");
          card = input.nextInt();
        }
        else {
          System.out.print("Input should be a integer between 2 and 9. Please try again: ");
          input.next();
          continue;
        }

        if (card <= 9 && card >= 2) {
          //System.out.print("The card is " + card);
          valid = true;
        }
      
      if (!valid) 
        System.out.print("Input should be a integer between 2 and 9. Please try again: ");
    } while (!valid);
    return card;
  }

  public static int randCardValue() {

    Random rand = new Random();

    return rand.nextInt(8) + 2;

  }

  public static void sortHands(int[] hands) {
    boolean sorted = false;
    while (!sorted) {
      sorted = true;
      for (int i = 0; i < hands.length - 1; i++) {
        if (hands[i] > hands[i+1]) {
          int temp = hands[i+1];
          hands[i+1] = hands[i];
          hands[i] = temp;
          sorted = false;
        }
      }
    }
  }

  public static void printHands(int[] hands) {
    System.out.print("Your hand is: ");
    for (int i = 0; i < hands.length; i++) {
      System.out.print(hands[i] + " ");
    }
    System.out.print("\n");
  }

  public static boolean containsFourOfaKind(int[] hands) {
    if ((hands[0] == hands[1] && hands[2] == hands[3] && hands[0] == hands[2])
          || (hands[4] == hands[1] && hands[2] == hands[3] && hands[4] == hands[2]))
      return true;
    else
      return false;
  }

  public static boolean containsFullHouse(int[] hands) {
    if ((hands[0] == hands[1] && hands[2] == hands[0] && hands[3] == hands[4])
          || (hands[3] == hands[4] && hands[2] == hands[3] && hands[0] == hands[1]))
      return true;
    else
      return false;
  }

  public static boolean containsStraight(int[] hands) {
    for (int i = 0; i < hands.length - 1; i++) {
      if (hands[i] != hands[i+1] - 1)
        return false;
    }
    return true;
  }

  public static boolean containsThreeOfaKind(int[] hands) {
    if ((hands[0] == hands[1] && hands[2] == hands[1])
          || (hands[1] == hands[2] && hands[2] == hands[3])
          || (hands[4] == hands[2] && hands[2] == hands[3]))
      return true;
    else
      return false;
  }

  public static boolean containsTwoPair(int[] hands) {
    int count = uniqCount(hands);
    return (count == 3) ? true : false;
  }

  public static boolean containsPair(int[] hands) {
    int count = uniqCount(hands);
    return (count == 4) ? true : false;
  }

  public static int uniqCount(int[] arr) {
    int count = 1;
    for (int i = 0; i<arr.length-1; i++) {
      if (arr[i] != arr[i+1])
        count++;
    }
    return count;
  }

}
