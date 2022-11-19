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
private void enumeration_recursion(Integer constraint_hour) {
  int hour_total = get_hour_total();
  if (route.size() == 5) {
    if (hour_total < constraint_hour) {
      print_result(hour_total);
    } else {
      System.out.print("[X]: ");
      print_result(hour_total);
    }
  } else {
    if (hour_total >= constraint_hour) {
      System.out.print("[backtracked]: ");
      print_result(hour_total);
      return;
    }
  }

  for (int i = 0; i < c_remained.length; i++) {
    if (c_remained[i] == null)
      continue;

    String c_next = c_remained[i];

    route.add(c_next);
    c_remained[i] = null;

    enumeration_recursion(constraint_hour);

    route.remove(c_next);
    c_remained[i] = c_next;
  }
}
```

1. 開始計算當前總時長
2. 如果路由走到底開始判斷是否合格並輸出
3. 反之判斷當前總時長是否超時，超時則結束遞迴
4. 進入迴圈
5. 如果國家已取出則跳過這圈迴圈
   反之繼續
6. 取得國家，添加到路由，並清空該國家
7. 展開遞迴
8. 遞迴結束，清調路由，並歸還國家

不會產生所有排列組合!

當下如果超時則結束遞迴並開始回朔

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