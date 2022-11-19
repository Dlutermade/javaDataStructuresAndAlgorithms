```java

// 判斷新增的元素index是否會溢界，會的話 擴展Array
if (i_end + 1 == array.length)
  expand_space();

// 判斷新增的元素位置是否會越界，會的話 結束函數
// 越界包含跳過一個元素即 [0, empty, newValue]
if (i_add > i_end + 1 || i_add < 0)
  return;

// 從最後一個元素開始 each往後move
for (int i = i_end; i >= i_add; i--) {
  array[i + 1] = array[i];
  array[i] = null;
}
```