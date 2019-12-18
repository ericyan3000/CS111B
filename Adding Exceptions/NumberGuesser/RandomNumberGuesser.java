import java.util.Random;

public class RandomNumberGuesser extends NumberGuesser {
	private boolean newLimit = true;

	public RandomNumberGuesser() {
		super();
	}

	public RandomNumberGuesser(int low, int high) {
		super(low, high);
	}

	public int getCurrentGuess() {
		if (newLimit) {
			Random random = new Random();
    		System.out.println("Low is " + low + " and high is " + high);
    		int range = high - low + 1;
    		this.currentGuess = random.nextInt(range) + low;
    		newLimit = false;
    	}
    	return currentGuess;
	}
		

   	public void higher() {
   		int tempLow = low;
   		super.higher();
   		if (tempLow != low) 
   			newLimit = true;
   		//System.out.println("Lower is updated to " + low);
  	}

  	public void lower() {
  		int tempHigh = high;
    	super.lower();
		if (tempHigh != high)
		 	newLimit = true;
    	//System.out.println("Higher is updated to" + high);
  	}

  	public void reset() {
  		super.reset();
  		newLimit = true;
  	}

}