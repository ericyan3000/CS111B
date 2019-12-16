import java.util.*;

public class ConwayMain {
	
	static Scanner input = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		ConwayWorld world = new ConwayWorld();
		
		// Add some live conway cells, in a horizontal line		
		for (int i = 0; i < 8; i++) {
			ConwayCell c = new ConwayCell(5, 5 + i, world);
			c.setIsAlive(true);
			world.replaceCell(c);
		}
		
		// Add an always-alive cells
		AbstractCell a = new AlwaysAliveCell(12, 12, world);
		world.replaceCell(a);
			
		// Add an never-alive cells
		AbstractCell n = new NeverAliveCell(17, 17, world);
		world.replaceCell(n);

		// Add an Blinker Cell
		AbstractCell b = new BlinkerCell(1, 5, world);
		world.replaceCell(b);

		// Add a set of self-defined MyCell
		for (int i = 1; i < 4; i++) {
			for (int j = 17; j < 20; j++) {
				AbstractCell m = new MyCell(j, i, world);
				m.setIsAlive(true);
				world.replaceCell(m);
			}
		}
			
		// Go!	
		do {
			world.display();
			world.advanceToNextGeneration();
			
			System.out.print("Another? (y/n): ");
		} while (input.nextLine().charAt(0) == 'y');
	}
}