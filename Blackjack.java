import java.util.Scanner;
import java.util.Random;


public class Blackjack {
	public static void main(String[] args) {
		int firstCard, secondCard, nextCard, total = 0;
		char anotherGame = 'y', hit;
        Scanner input = new Scanner(System.in);
		Random rand = new Random();

		System.out.println("Welcome to Blackjack game.");

		while (anotherGame == 'y') {
			firstCard = rand.nextInt(10) + 1;
			secondCard = rand.nextInt(10) + 1;
			total = firstCard + secondCard;
			
            System.out.printf("Your hand is: %d and %d\nThe total is %d\n", firstCard, secondCard, total);
            System.out.println("Hit? (y/n): ");
            hit = input.nextLine().charAt(0);

            while (hit == 'y') {
                nextCard = rand.nextInt(10) + 1;
                total += nextCard;

                System.out.printf("The next card is %d\nThe total is %d\n", nextCard, total);
                
                if (total > 21) {
                    System.out.println("Busted!!");
                    break;
                } else if (total == 21) {
                    System.out.println("Blackjack!!");
                    break;
                } else {
                    System.out.println("Hit? (y/n): ");
                    hit = input.next().charAt(0);
                    input.nextLine();
                }
            }

            System.out.printf("Your total is %d. Would you like another game? (y/n): ", total);
            anotherGame = input.nextLine().charAt(0);
        }
	}
}