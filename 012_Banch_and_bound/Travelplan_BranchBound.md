```java
String[] c_remained = { "NP", "IS", "CA", "UK", "US" }; // index 與 字串 映射表
Integer[][] hours =  {
  { 0, 14, 15, 17, 16 },
  { 14, 0, 24, 8, 36 },
  { 15, 24, 0, 34, 4 },
  { 17, 8, 34, 0, 30 },
  { 16, 36, 4, 30, 0 }, 
}; // 圖路徑的權重表
;

```

|     | NP  | IS  | CA  | UK  | US  |
| --- | --- | --- | --- | --- | --- |
| NP  | 0   | 14  | 15  | 17  | 16  |
| IS  | 14  | 0   | 24  | 8   | 36  |
| CA  | 15  | 24  | 0   | 34  | 4   |
| UK  | 17  | 8   | 34  | 0   | 30  |
| US  | 16  | 36  | 4   | 30  | 0   |


## 起動遞迴函數
```java
public void enumeration(Integer constraint_hour) {
  String c_start = "NP";
  route.add(c_start);
  c_remained[0] = null;

  enumeration_recursion(constraint_hour);
}
```

1. 紀錄起點到route
2. 將起點從國家陣列中清空

---

## 遞迴函數
```java
Integer hour_best = null;

private void enumeration_recursion(Integer constraint_hour) {
  int hour_total = get_hour_total();

  if (route.size() == 5) {
    if (hour_best == null || hour_total < hour_best) {
      hour_best = hour_total;
      print_result(hour_total);
    } else {
      System.out.print("[X]: ");
      print_result(hour_total);
    }
  } else {
    // bound check
    if (hour_best != null && hour_total >= hour_best) {
      System.out.print("[bounded]: ");
      print_result(hour_total);
      return;
    }
  }

  // branch strategy
  PriorityQueue<Country> pq = new PriorityQueue<>(c_remained.length, new myComp());

  // step01: sort child node by hours
  String c_start = route.get(route.size() - 1);
  for (int i = 0; i < c_remained.length; i++) {
    if (c_remained[i] == null) {
      continue;
    }

    String c_end = c_remained[i];
    Integer hour = get_hour(c_start, c_end);
    Country c = new Country(c_end, i, hour);

    pq.add(c);
  }

  /** step02: just pick any child to continue each round **/
  while (true) {
    if (pq.size() == 0) {
      break;
    }

    Country c = pq.poll();
    
    route.add(c.name);
    c_remained[c.index] = null;

    branchbound_recursion();

    route.remove(c.name);
    c_remained[c.index] = c.name;

  }
}
```

1. 設一個變數紀錄最小時長
2. 開始計算當前總時長
3. 如果路由走到底開始判斷是否為比紀錄的最小時長還短
4. 反之判斷當前總時長是否超過紀錄的最小時長，超時則結束遞迴
   ( Bound ) 
5. 使用PriorityQueue儲存剩餘的國家，pq的poll必然由小到大
6. 進入迴圈
7. 取得剩餘的國家，添加到路由，並清空該國家
8. 展開遞迴
9. 遞迴結束，清調路由，並歸還國家
   ( Branch )  

不會產生所有排列組合!

且保證**當下最小值**優先取出即( Branch )，當走完時候會比較**是否為總體最小時長**則是( Bound )



---

## 計算距離
```java
private int get_hour_total() {
  if (route.size() == 0)
    return 0;
  int hour_total = 0;
  String c_start = route.get(0);
  String c_end = null;
  for (int i = 1; i < route.size(); i++) {
    c_end = route.get(i);
    hour_total += get_hour(c_start, c_end);

    c_start = c_end;
  }

  return hour_total;
}
```

1. 從路由開始取得第一個節點，慢慢往下尋找下一個端點
2. 計算兩個位置時間
3. 回傳加總的時間