import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Q1 {
  public static void main(String[] args) throws IOException {
    System.out.println("請輸入車號、汽油量、車名（用空白隔開）");

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String str = br.readLine();
    String[] data = str.split(" ");

    Car car1 = new Car();
    car1.setCar(Integer.parseInt(data[0]), Double.parseDouble(data[1]));
    car1.setName(data[2]);
    car1.show();

    car1.refuel(10.5);
    car1.run(30.0);
    car1.show();
  }
}

class Car {
  private int num;
  private double gas;
  private String name;

  public Car() {
    num = 0;
    gas = 0.0;
    name = "沒有名稱";
    System.out.println("生產了車子");
  }

  public void setCar(int n, double g) {
    num = n;
    gas = g;
    System.out.println("將車號設為" + num + "，汽油量設為" + gas);
  }

  public void setName(String nm) {
    name = nm;
    System.out.println("將車名設為" + name);
  }

  public void refuel(double g) {
    gas = gas + g;
    System.out.println("加油" + g + "公升");
  }

  public void run(double distance) {
    double use = distance / 10.0;
    if (use > gas) {
      System.out.println("汽油不足，無法行駛" + distance + "公里");
      return;
    }
    gas = gas - use;
    System.out.println("行駛了" + distance + "公里，消耗" + use + "公升汽油");
  }

  public void show() {
    System.out.println("車號是" + num);
    System.out.println("汽油量是" + gas);
    System.out.println("車名是" + name);
  }
}
