import java.util.ArrayList;
import java.util.Scanner;

public class Q2 {
  public static void main(String[] args) {
    ArrayList<Fruit> list = new ArrayList<Fruit>();
    list.add(new Fruit("蘋果", 30, 20));
    list.add(new Fruit("香蕉", 15, 50));
    list.add(new Fruit("芒果", 80, 8));
    list.add(new Fruit("西瓜", 250, 3));

    Scanner sc = new Scanner(System.in);

    while (true) {
      System.out.println("---- 水果清單 ----");
      for (int i = 0; i < list.size(); i++) {
        System.out.print(i + "：");
        list.get(i).show();
      }
      System.out.println("請輸入編號購買（輸入 -1 結束）：");

      if (sc.hasNextInt() == false) {
        System.out.println("請輸入數字");
        sc.next();
        continue;
      }

      int index = sc.nextInt();
      if (index == -1) {
        break;
      }

      if (index < 0 || index >= list.size()) {
        System.out.println("沒有這個編號");
        continue;
      }

      System.out.println("要買幾個？");
      if (sc.hasNextInt() == false) {
        System.out.println("請輸入數字");
        sc.next();
        continue;
      }
      int n = sc.nextInt();
      if (n < 1) {
        System.out.println("數量必須大於 0");
        continue;
      }

      Fruit f = list.get(index);
      if (f.sell(n) == false) {
        System.out.println("庫存不足，目前只剩" + f.getStock() + "個");
      }
    }

    System.out.println("---- 今日收入 ----");
    int total = 0;
    for (Fruit f : list) {
      System.out.println(f.getName() + " 賣出" + f.getSold() + "個，收入" +
          f.getPrice() * f.getSold() + "元");
      total = total + f.getPrice() * f.getSold();
    }
    System.out.println("合計：" + total + "元");
  }
}

class Fruit {
  private String name;
  private int price;
  private int stock;
  private int sold;

  public Fruit(String nm, int p, int s) {
    name = nm;
    price = p;
    stock = s;
    sold = 0;
  }

  public boolean sell(int n) {
    if (n > stock) {
      return false;
    }
    stock = stock - n;
    sold = sold + n;
    System.out.println("賣出" + name + n + "個，金額" + (price * n) + "元");
    return true;
  }

  public String getName() {
    return name;
  }

  public int getPrice() {
    return price;
  }

  public int getStock() {
    return stock;
  }

  public int getSold() {
    return sold;
  }

  public void show() {
    System.out.println(name + " 單價" + price + "元 庫存" + stock + "個");
  }
}
