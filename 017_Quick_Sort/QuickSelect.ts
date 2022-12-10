{
  const swap = (arr: number[], x: number, y: number) => {
    [arr[x], arr[y]] = [arr[y], arr[x]];
  };

  const partition = (arr: number[], start: number, end: number) => {
    const pivot = arr[start];

    let [l, r] = [start, end];

    while (l < r) {
      while (l < r && arr[r] >= pivot) {
        r -= 1;
      }
      while (l < r && arr[r] <= pivot) {
        l += 1;
      }

      swap(arr, l, r);
    }

    swap(arr, l, start);
    return l;
  };

  // target 是原始陣列中第幾小元素的index
  const quickSelect = (
    arr: number[],
    start: number,
    end: number,
    target: number
  ) => {
    if (start === end) {
      return arr[start];
    }

    while (1) {
      const p = partition(arr, start, end);
      if (p === target) {
        return arr[p];
      } else if (p < target) {
        start = p + 1;
      } else {
        end = p - 1;
      }
    }
  };

  const arr = [10, 20, 3, 8, 4, 6, 1, 7, 2];

  quickSelect([...arr], 0, arr.length - 1, 2);
}
