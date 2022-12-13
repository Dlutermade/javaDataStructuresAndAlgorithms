const mergeSort = (arr: number[], low: number, high: number) => {
  if (low === high) return;

  const mid = Math.floor((low + high) / 2);

  mergeSort(arr, low, mid);
  mergeSort(arr, mid + 1, high);

  merge(arr, low, mid, high);
};

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

  while (rightPointer <= high) {
    arr[pointer] = res[rightPointer - low];
    rightPointer += 1;
    pointer += 1;
  }
};
