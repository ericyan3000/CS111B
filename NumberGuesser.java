public class NumberGuesser {
  private int currentGuess;
  private int high;
  private int low;
  private int highOrigin;
  private int lowOrigin;

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
    this.low = currentGuess + 1;
    //System.out.println("Lower is updated to " + low);
  }

  public void lower() {
    this.high = currentGuess - 1;
    //System.out.println("Higher is updated to" + high);
  }

  public int getCurrentGuess() {
    this.currentGuess = (high + low) / 2;
    currentGuess = currentGuess < 1 ? 1 : currentGuess;
    //System.out.println("Current guess is " + currentGuess);
    return currentGuess;
  }

  public void reset() {
    this.high = highOrigin;
    this.low = lowOrigin;
    //System.out.println("I'm reset");
    //this.currentGuess = (high + low) / 2 ;
  }

}