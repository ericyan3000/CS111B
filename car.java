public class Car {
  public static void main(String[] args) {
    Car myCar = new RealCar(2018, "volvo", 0);
    myCar.accelerate();
    System.out.println(myCar.getSpeed());
    myCar.accelerate();
    System.out.println(myCar.getSpeed());
    myCar.accelerate();
    System.out.println(myCar.getSpeed());
    myCar.accelerate();
    System.out.println(myCar.getSpeed());
    myCar.accelerate();
    System.out.println(myCar.getSpeed());
    myCar.brake();
    System.out.println(myCar.getSpeed());
    myCar.brake();
    System.out.println(myCar.getSpeed());
    myCar.brake();
    System.out.println(myCar.getSpeed());
    myCar.brake();
    System.out.println(myCar.getSpeed());
    myCar.brake();
    System.out.println(myCar.getSpeed());
  }
}

class RealCar {
  private int yearModel = 0;
  private String make = "";
  private int speed = 0;

  public RealCar(int year, String make, int speed) {
    this.yearModel = year;
    this.make = make;
    this.speed = speed;
  }

  public int getYear() {
    return yearModel;
  }

  public void setYear(int year) {
    this.yearModel = year;
  }

  public String getMake() {
    return make;
  }

  public void setMake(String make) {
    this.make = make;
  }

  public void setSpeed(int speed) {
    this.speed = speed;
  }

  public int getSpeed() {
    return speed;
  }

  public void accelerate() {
    speed += 5;
  }

  public void brake() {
    speed -= 5;
  }
}
