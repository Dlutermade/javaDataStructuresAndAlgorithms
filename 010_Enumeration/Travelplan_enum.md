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
  if (route.size() == 5) {
    int hour_total = get_hour_total();
    if (hour_total < constraint_hour) {
      print_result(hour_total);
    } else {
      System.out.println("[X]:");
      print_result(hour_total);
    }
    return;
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

1. 如果遞迴條件結束則開始計算總時長
   開始判斷印出是否合格
2. 反之進入迴圈
3. 如果國家已取出則跳過這圈迴圈
   反之繼續
4. 取得國家，添加到路由，並清空該國家
5. 展開遞迴
6. 遞迴結束，清調路由，並歸還國家

會產生所有排列組合!

即枚舉出所有排列組合再透過條件印出合格解!