import java.util.Arrays;

public class DiceHolderDemo {
	public static void main(String[] args) {
		int arr[] = {2, 3, 3, 3, 0};
		AdvancedDiceHolder dices = new AdvancedDiceHolder(arr);

		System.out.println(Arrays.toString(dices.largestSet()));
	}
}