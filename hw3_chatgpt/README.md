# HW3 — 使用 ChatGPT 產生的三個範例程式

作業要求：使用 ChatGPT 寫出三個範例程式，至少使用下列其中一個類別。

| 程式 | 使用的類別 | 內容 |
| --- | --- | --- |
| `Q1.java` | `java.io` + `java.lang.String` | 從鍵盤輸入車號、汽油量、車名，建立 `Car` 物件，示範加油與行駛（油耗）計算 |
| `Q2.java` | `java.util`（`ArrayList`、`Scanner`） | 水果販賣機：清單、購買、庫存不足檢查、最後統計各品項收入 |
| `Q3.java` | `java.io` + `java.util`（`HashMap`） | 讀取文字檔並統計每個英文單字出現的次數 |

## 執行方式

```bash
cd hw3_chatgpt
java Q1.java
java Q2.java
java Q3.java sample.txt
```

## 執行結果（實測）

Q1：

```
請輸入車號、汽油量、車名（用空白隔開）
1234 20.5 一號車
將車號設為1234，汽油量設為20.5
將車名設為一號車
車號是1234
汽油量是20.5
車名是一號車
加油10.5公升
行駛了30.0公里，消耗3.0公升汽油
車號是1234
汽油量是28.0
車名是一號車
```

Q3（sample.txt 共 3 行）：

```
fox：4次
the：4次
a：2次
quick：2次
dog：2次
...
```

## 修正與優化心得

ChatGPT 第一版的 `Q2.java` 只用 `Scanner.nextInt()` 直接取值，沒有做任何檢查，
測試時發現兩個問題：輸入負數數量的時候會變成「賣出 -3 個」，庫存反而增加、收入變負數；
輸入非數字或打完資料之後，會直接丟出 `NoSuchElementException` 中斷程式。
改成使用 `Scanner.hasNextInt()` 先檢查型別，遇到不合法輸入就 `continue` 回到選單，
並在 `sell()` 之前擋掉小於 1 的數量。原本的 `new Integer(n)`、`new Double(d)`
這種多餘的裝箱寫法也改成直接使用 `Integer.parseInt()` 與 `Double.parseDouble()`。
整體來說 ChatGPT 產生的程式碼結構正確、可讀性也不錯，但邊界條件的處理仍然需要自己
補上，這也是這次實際跑起來之後比較有感覺的地方。
