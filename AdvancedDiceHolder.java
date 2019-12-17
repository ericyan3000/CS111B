import java.util.ArrayList;

public class AdvancedDiceHolder extends DiceHolder {
	public AdvancedDiceHolder(int[] values) {
		super(values[0], values[1], values[2], values[3], values[4]);
	}

	public int[] largestSet() {
		sort();
    ArrayList<Integer> uniqDice = uniq(diceArray);
    int repeatCounter = 0;
    int largestSetNumber = 0;
    for (int i = 0; i < uniqDice.size(); i++) {
      // how many times does each number appears
      int counter = count(diceArray, uniqDice.get(i));
      if (counter > repeatCounter) {
        repeatCounter = counter;
        largestSetNumber = uniqDice.get(i);
      }
    }
    
    int[] result = new int[repeatCounter];
    for (int i = 0; i < repeatCounter; i++) {
      result[i] = largestSetNumber;
    }
    return result;
	}

	public void sort() {
    boolean sorted = false;
    while (!sorted) {
      sorted = true;
      for (int i = 0; i < diceArray.length - 1; i++) {
        if (diceArray[i] > diceArray[i+1]) {
          int temp = diceArray[i+1];
          diceArray[i+1] = diceArray[i];
          diceArray[i] = temp;
          sorted = false;
        }
      }
    }
  }

  public ArrayList<Integer> uniq(int[] arr) {
    ArrayList<Integer> temp = new ArrayList<Integer>(5);
    temp.add(arr[0]);
    for (int i = 0; i < arr.length - 1; i++) {
      if (arr[i+1] != arr[i])
        temp.add(arr[i+1]);
    }
    return temp;
  }

  public int count(int[] arr, int n) {
    int counter  = 0;
    for (int i = 0; i < arr.length; i++) {
      if (arr[i] == n)
        counter++;
    }
    return counter;
  }
}