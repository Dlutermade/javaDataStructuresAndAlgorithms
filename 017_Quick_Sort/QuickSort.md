#### 遞迴起始式

```java
public static void quick_sort(int[] nums) {
  if (nums == null || nums.length == 0)
    return;

  quick_sort(nums, 0, nums.length - 1);
}
```

---

#### 正式遞迴

```java
private static void quick_sort(int[] nums, int i_start, int i_end) {
  if (i_start == i_end) // 切割到只剩下一個元素
    return;
  if (i_start > i_end) // 上一層的陣列已經沒有多餘的元素去分出子陣列 (因為i_pivot_final-1 和 i_pivot_final+1 可能會導致 溢出)
    return;

  int i_pivot_guess = get_pivot_index(i_start, i_end);

  int i_pivot_final = sort(nums, i_start, i_pivot_guess, i_end);

  quick_sort(nums, i_start, i_pivot_final - 1);
  quick_sort(nums, i_pivot_final + 1, i_end);

}
```

1. 先判斷是否越界
2. 抓出 pivot 位置
3. 先排序再遞迴

--

#### 正式遞迴

```java
private static void quick_sort(int[] nums, int i_start, int i_end) {
  if (i_start == i_end) // 切割到只剩下一個元素
    return;
  if (i_start > i_end) // 上一層的陣列已經沒有多餘的元素去分出子陣列 (因為i_pivot_final-1 和 i_pivot_final+1 可能會導致 溢出)
    return;

  int i_pivot_guess = get_pivot_index(i_start, i_end);

  int i_pivot_final = sort(nums, i_start, i_pivot_guess, i_end);

  quick_sort(nums, i_start, i_pivot_final - 1);
  quick_sort(nums, i_pivot_final + 1, i_end);

}
```

#### 排序邏輯

```java
private static int sort(int[] nums, int i_start, int i_pivot_guess, int i_end) {
  int i_pivot_now = i_pivot_guess;

  // step01: swap pivot element with last element
  swap(nums, i_pivot_now, i_end);
  i_pivot_now = i_end;

  // step02: 定義指標
  int i_left = i_start;
  int i_right = i_end - 1;

  while (true) {
    // 尋找左右指標
    while (i_left != i_right && nums[i_left] <= nums[i_pivot_now]) {
      i_left++;
    }

    while (i_left != i_right && nums[i_right] >= nums[i_pivot_now]) {
      i_right--;
    }

    if (i_left == i_right)
      break;

    swap(nums, i_left, i_right); // leverage existing array space
  }

  int i_meeting_point = i_left;
  if (nums[i_meeting_point] >= nums[i_pivot_now]) {
    swap(nums, i_meeting_point, i_pivot_now);
    i_pivot_now = i_meeting_point;
  }

  return i_pivot_now;
}
```

1. 先把 pivot 交換至最右邊
2. 定義 left 和 right 指標
3. 開始線性尋找左右指標
   其條件為
   1. 指標不重疊
   2. left 不大於 pivot
   3. right 不小於 pivot
4. 尋找結果為
   指標重疊，離開迴圈
   指標不重疊，交換兩個指標元素並回去上一步繼續尋找
5. 因為迴圈結束，所以可以確保指標重疊，將 i_meeting_point 賦予 重疊的指標
6. 如果 i_meeting_point >= pivot 則意味 重疊的位置有大於等於 pivot
   進行交換
7. 反之則意味 pivot 好死不死適合的位置是最後一個位置

```java
while (true) {
  // 尋找左右指標
  while (i_left != i_right && nums[i_left] <= nums[i_pivot_now]) {
    i_left++;
  }

  while (i_left != i_right && nums[i_right] >= nums[i_pivot_now]) {
    i_right--;
  }

  if (i_left == i_right)
    break;

  swap(nums, i_left, i_right); // leverage existing array space
}
```

這個 while 過程，保證了指標重疊之前會不斷交換
所以 left 指標 左邊元素會小於等於 pivot 的 value，右邊元素會大於 pivot 的 value
