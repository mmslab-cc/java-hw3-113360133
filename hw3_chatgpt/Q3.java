import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Q3 {
  public static void main(String[] args) {
    if (args.length != 1) {
      System.out.println("請指定正確的檔案名稱");
      System.exit(1);
    }

    HashMap<String, Integer> count = new HashMap<String, Integer>();

    try {
      BufferedReader br = new BufferedReader(new FileReader(args[0]));
      String str;

      while ((str = br.readLine()) != null) {
        str = str.replace(",", "").replace(".", "").toLowerCase();
        String[] words = str.split(" ");

        for (String w : words) {
          if (w.equals("")) {
            continue;
          }
          if (count.containsKey(w)) {
            count.put(w, count.get(w) + 1);
          } else {
            count.put(w, 1);
          }
        }
      }

      br.close();
    } catch (IOException e) {
      System.out.println("輸出入錯誤：" + e);
      return;
    }

    System.out.println("---- 各單字出現次數 ----");
    for (Map.Entry<String, Integer> e : count.entrySet()) {
      System.out.println(e.getKey() + "：" + e.getValue() + "次");
    }
  }
}
