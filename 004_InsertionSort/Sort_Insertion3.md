```java
public static void insertion_sort(int[] nums) {
  for (int i_start = 0; i_start < nums.length; i_start++) {
    for (int i_run = i_start - 1; i_run >= 0; i_run--) {
      if (nums[i_run + 1] < nums[i_run]) {
        swap(nums, i_run + 1, i_run);
      } else {
        // 因為反方向是前面回合已經排序的，所以可以跳過不必要的檢查
        break;
      }
    }
  }
}
```

```java
public static void insertion_sort(int[] nums) {
  for (int i_start = 0; i_start < nums.length; i_start++) {
    for (int i_run = i_start; i_run > 0; i_run--) {
      if (nums[i_run] < nums[i_run - 1]) {
        swap(nums, i_run, i_run - 1);
      } else {
        // 因為反方向是前面回合已經排序的，所以可以跳過不必要的檢查
        break;
      }
    }
  }
}
```

## 重點

因為插入排序法保證 **陣列元素位置前面** 的元素 **已排序**，是基於內層迴圈跟外層迴圈呈現 **反方向** ，所以假設跟 **前x個元素比較不成立** ，即跟 **前x+a個元素比較也不成立** ，因此沒必要繼續比較。

| 迴圈 | 方向 | 作用          | 起始值     | 終止值       |
| ---- | ---- | ------------- | ---------- | ------------ |
| 1    | =>   | 陣列元素位置  | 0          | 陣列長度 - 1 |
| 2    | <=   | 搜尋+交換元素 | 元素位置-1 | 0            |

