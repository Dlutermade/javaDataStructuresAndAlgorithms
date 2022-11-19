```java
public static void selection_sort(int[] nums) {
  for (int i_start = 0; i_start < nums.length; i_start++) {
    int i_min = i_start;
    for (int i_run = i_start + 1; i_run < nums.length; i_run++) {
      if (nums[i_min] > nums[i_run]) {
        i_min = i_run;
      }
    }
    swap(nums, i_start, i_min);
  }
}
```


## 重點

選擇排序法是透過 **先記錄當前位置**，開始尋找該位置的**最佳值所在的位置**，最後才交換

| 迴圈 | 方向 | 作用                  | 起始值     | 終止值       |
| ---- | ---- | --------------------- | ---------- | ------------ |
| 1    | =>   | 陣列元素位置+交換元素 | 0          | 陣列長度 - 1 |
| 2    | =>   | 搜尋+交換位置         | 元素位置+1 | 陣列長度 - 1 |

