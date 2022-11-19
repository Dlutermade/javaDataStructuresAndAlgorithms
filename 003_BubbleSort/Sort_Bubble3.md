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

## 重點

因為泡沫排序法 **EachRound每回合最後一個值** 是 **絕對排序好的** ，所以可以
len = nums.length - round;

| 迴圈 | 方向 | 作用          | 起始值 | 終止值                  |
| ---- | ---- | ------------- | ------ | ----------------------- |
| 1    | =>   | 回合          | 0      | 陣列長度 - 1            |
| 2    | =>   | 搜尋+交換元素 | 1      | 陣列長度 - 上層迴圈 - 1 |

