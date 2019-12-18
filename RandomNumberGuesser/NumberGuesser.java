public class NumberGuesser {
  protected int currentGuess;
  protected int high;
  protected int low;
  protected int highOrigin;
  protected int lowOrigin;

  public NumberGuesser() {
    this.high = 100;
    this.low = 1;
    this.highOrigin = high;
    this.lowOrigin = low;
    //this.currentGuess = 50;
  }

  public NumberGuesser(int low, int high) {
    this.high = high;
    this.low = low;
    this.highOrigin = high;
    this.lowOrigin = low;
    //this.currentGuess = (high + low) / 2 ;
  }

  public void higher() {

    if (currentGuess == high) {
      System.out.println("You have hit the maximum, something is wrong. Let's try again.");
    }
    else
      this.low = currentGuess + 1;
    //System.out.println("Lower is updated to " + low);
  }

  public void lower() {
    if (currentGuess == low) {
      System.out.println("You have hit the minimum, something is wrong. Let's try again.");
    }
    else
      this.high = currentGuess - 1;
    //System.out.println("Higher is updated to" + high);
  }

  public int getCurrentGuess() {
    this.currentGuess = (high + low) / 2;
    currentGuess = currentGuess < 1 ? 1 : currentGuess;
    //System.out.println("Current guess is " + currentGuess);
    return currentGuess;
  }

  public int getMIN() {
    return this.lowOrigin;
  }

  public int getMAX() {
    return this.highOrigin;
  }

  public void reset() {
    this.high = highOrigin;
    this.low = lowOrigin;
    //System.out.println("I'm reset");
    //this.currentGuess = (high + low) / 2 ;
  }


}