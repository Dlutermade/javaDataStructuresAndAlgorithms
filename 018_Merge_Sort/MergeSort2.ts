const mergeSort1 = (arr: number[]) => {
  if (arr.length < 2) {
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
