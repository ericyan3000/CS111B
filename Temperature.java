import java.util.Scanner;

public class Temperature{
  private double ftemp;

  public Temperature(double temp) {
    ftemp = temp;
  }

  public void setFahrenheit(double temp) {
    ftemp = temp;
  }

  public double getFahrenheit() {
    return ftemp;
  }

  public double getCelsius() {
    return (5.0 / 9 ) * (ftemp - 32);
  }

  public double getKelvin() {
    return (5.0 / 9 ) * (ftemp - 32) + 273;
  }

  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    double ftemp;

    System.out.print("Enter a Fahrenheit temperature: ");
    ftemp = input.nextDouble();
    Temperature my_temp = new Temperature(ftemp);
    System.out.print("The temperatrue in Celsius is " + my_temp.getCelsius() + "\n");
    System.out.print("The temperatrue in Celsius is " + my_temp.getKelvin() + "\n");
  }

}