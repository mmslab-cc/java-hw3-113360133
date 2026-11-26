public class p16 {
  public static void main (String[] args){
    int[] test = {80, 60};
    Car car1 = new Car(1234, 20.5);

    showArray(test);
    showCar(car1);

    test[0] = 0;
    car1.setCar(5678, 0.0);

    System.out.println("將陣列的第一個元素與車子的車號改成不同值之後");
    showArray(test);
    showCar(car1);
  }

  public static void showArray(int[] arr){
    for(int i = 0; i < arr.length; i++){
      System.out.println("arr[" + i + "] = " + arr[i]);
    }
  }

  public static void showCar(Car c){
    c.show();
  }
}

class Car {
  private int num;
  private double gas;

  public Car(int n, double g){
    num = n;
    gas = g;
    System.out.println("生產了車號為" + num + "，汽油量為" + gas + "的車子");
  }

  public void setCar(int n, double g){
    num = n;
    gas = g;
    System.out.println("將車號設為" + num + "，將汽油量設為" + gas);
  }

  public void show(){
    System.out.println("車號是" + num);
    System.out.println("汽油量是" + gas);
  }
}
