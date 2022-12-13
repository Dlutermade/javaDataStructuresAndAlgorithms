## 合併排序 vs 快速排序

| name     | Merge Sort           | Quick Sort         |
| -------- | -------------------- | ------------------ |
| 概念     | 先分支再排序         | 先排序再分支       |
| 遍歷方式 | Post Order           | Pre Order          |
| 切割變數 | Mid                  | Pivot              |
| 分支之一 | low ~ mid            | low ~ pivot - 1    |
| 分支之二 | mid + 1 ~ high       | pivot + 1 ~ high   |
| 切割方式 | ( left + right ) / 2 | 客製化             |
| 排序名稱 | Merge                | Partition          |
| Big-O    | log(n) * n           | n * n ~ log(n) * n |


Merge Sort Merge

```ts
const merge = (arr: number[], low: number, mid: number, high: number) => {
  const res = arr.slice(low, high + 1);

  let pointer = low;

  let leftPointer = low;
  let rightPointer = mid + 1;

  while (leftPointer <= mid && rightPointer <= high) {
    const leftVal = res[leftPointer - low];
    const rightVal = res[rightPointer - low];

    if (leftVal <= rightVal) {
      arr[pointer] = leftVal;
      leftPointer += 1;
    } else {
      arr[pointer] = rightVal;
      rightPointer += 1;
    }

    pointer += 1;
  }

  while (leftPointer <= mid) {
    arr[pointer] = res[leftPointer - low];
    leftPointer += 1;
    pointer += 1;
  }

  while (rightPointer <= mid) {
    arr[pointer] = res[rightPointer - low];
    rightPointer += 1;
    pointer += 1;
  }
};
```

```ts
const mergeSort1 = (arr: number[]) => {
  if (arr.length <= 1) {
    return arr;
  }

  const mid = Math.floor(arr.length / 2);

  const leftArr = mergeSort1(arr.slice(0, mid));
  const rightArr = mergeSort1(arr.slice(mid));

  return merge1(leftArr, rightArr);
};

const merge1 = (leftArr: number[], rightArr: number[]) => {
  const mergeArr: number[] = [];
  let leftPointer = 0;
  let rightPointer = 0;

  while (leftPointer < leftArr.length && rightPointer < rightArr.length) {
    if (leftArr[leftPointer] < rightArr[rightPointer]) {
      mergeArr.push(leftArr[leftPointer]);
      leftPointer += 1;
    } else {
      mergeArr.push(leftArr[rightPointer]);
      rightPointer += 1;
    }
  }

  return mergeArr
    .concat(leftArr.slice(leftPointer))
    .concat(rightArr.slice(rightPointer));
};
```

Quick Sort 主要兩種 Partition

```ts
const partition1 = (arr: number[], low: number, high: number) => {
  const pivot = arr[low];

  let [l, r] = [low, high];

  while (l < r) {
    while (l < r && arr[r] >= pivot) {
      r -= 1;
    }

    while (l < r && arr[l] <= pivot) {
      l += 1;
    }

    swap(arr, l, r);
  }

  swap(arr, l, low);

  return l;
};

const partition2 = (arr: number[], low: number, high: number) => {
  const pivot = arr[high];

  let x = low;

  for (let i = low; i < high; i++) {
    if (arr[i] <= pivot) {
      swap(arr, x, i);
      x += 1;
    }
  }

  swap(arr, x, high);

  return x;
};
```