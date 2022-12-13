#### 正式遞迴

```java
private static void merge_sort(int[] nums, int i_start, int i_end) {
  if (i_start == i_end)
    return;

  int i_mid = (i_start + i_end) / 2;

  merge_sort(nums, i_start, i_mid);
  merge_sort(nums, i_mid + 1, i_end);

  sort(nums, i_start, i_mid, i_end);
}
```

---

1. 先判斷是否只有一個元素
2. 先分支
3. 再排序

---

#### 開始排序

```java
private static void sort(int[] nums, int i_start, int i_mid, int i_end) {
  int[] nums_tmp = new int[nums.length];
  int i_nums_tmp = i_start;

  int i_left_ary = i_start;
  int i_right_ary = i_mid + 1;

  while (true) {
    if (i_nums_tmp > i_end)
      break;

    Integer left = null;
    Integer right = null;

    if (i_left_ary <= i_mid)
      left = nums[i_left_ary];

    if (i_right_ary <= i_end)
      right = nums[i_right_ary];

    if (left != null && right != null) {
      if (left <= right) {
        nums_tmp[i_nums_tmp] = left;
        i_left_ary++;
      } else if (left > right) {
        nums_tmp[i_nums_tmp] = right;
        i_right_ary++;
      }
    } else if (left != null) {
      nums_tmp[i_nums_tmp] = left;
      i_left_ary++;
    } else if (right != null) {
      nums_tmp[i_nums_tmp] = right;
      i_right_ary++;
    }

    i_nums_tmp++;
  }

  for (int i = i_start; i <= i_end; i++) {
    nums[i] = nums_tmp[i];
  }

}
```

---

#### 第一步驟，初始化

```java
int[] nums_tmp = new int[nums.length];
int i_nums_tmp = i_start;

int i_left_ary = i_start;
int i_right_ary = i_mid + 1;
```

1. 建立暫時陣列儲存元素
2. 變數1 暫時陣列的起點
3. 變數2 左邊陣列的起點
4. 變數3 右邊陣列的起點

---

#### 第二步驟 開始搬動到暫時陣列

```java
while (true) {
  if (i_nums_tmp > i_end)
    break;

  Integer left = null;
  Integer right = null;

  if (i_left_ary <= i_mid)
    left = nums[i_left_ary];

  if (i_right_ary <= i_end)
    right = nums[i_right_ary];

  if (left != null && right != null) {
    if (left <= right) {
      nums_tmp[i_nums_tmp] = left;
      i_left_ary++;
    } else if (left > right) {
      nums_tmp[i_nums_tmp] = right;
      i_right_ary++;
    }
  } else if (left != null) {
    nums_tmp[i_nums_tmp] = left;
    i_left_ary++;
  } else if (right != null) {
    nums_tmp[i_nums_tmp] = right;
    i_right_ary++;
  }

  i_nums_tmp++;
}
```

1. 先抓取左右陣列的值
2. 比較然後給予到該陣列
3. 如果只有一邊有值，則取該邊的值


#### 第三步驟 放回去原始陣列

```java
for (int i = i_start; i <= i_end; i++) {
  nums[i] = nums_tmp[i];
}
```