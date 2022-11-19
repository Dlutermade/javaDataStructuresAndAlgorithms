#### 泡沫排序法
```java
public static void bubble_sort(int[] nums) {
  for (int round = 0; round < nums.length; round++) {
    int len = nums.length - round;
    for (int i_run = 1; i_run < len; i_run++) {
      if (nums[i_run - 1] > nums[i_run]) {
        swap(nums, i_run - 1, i_run);
      }
    }
  }
}
```

#### 插入排序法
```java
public static void insertion_sort(int[] nums) {
  for (int i_start = 0; i_start < nums.length; i_start++) {
    for (int i_run = i_start - 1; i_run >= 0; i_run--) {
      if (nums[i_run + 1] < nums[i_run]) {
        swap(nums, i_run + 1, i_run);
      } else {
        break;
      }
    }
  }
}
```

#### 選擇排序法
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


| 排序法    | 迴圈 | 方向 | 作用                  | 起始值     | 終止值                  |
| --------- | ---- | ---- | --------------------- | ---------- | ----------------------- |
| Bubble    | 1    | =>   | 回合                  | 0          | 陣列長度 - 1            |
| Bubble    | 2    | =>   | 搜尋+交換元素         | 1          | 陣列長度 - 上層迴圈 - 1 |
| Insertion | 1    | =>   | 陣列元素位置          | 0          | 陣列長度 - 1            |
| Insertion | 2    | <=   | 搜尋+交換元素         | 元素位置-1 | 0                       |
| Selection | 1    | =>   | 陣列元素位置+交換元素 | 0          | 陣列長度 - 1            |
| Selection | 2    | =>   | 搜尋+交換位置         | 元素位置+1 | 陣列長度 - 1            |

1. 泡沫排序法核心思想，只要**一直比較交換**，就可以**排序好該回合最後的值**
2. 插入排序法核心思想，**先排序好一部分**，未知的元素**比較排序好的最後一個值**即可知道，是否需要排序，**如果需要排序則開始逆向泡沫**
3. 選擇排序法核心思想，紀錄當前位置，開始往後尋找當前位置的最佳值，**尋找結束才排序**