const swap = (arr: number[], x: number, y: number) => {
  const i = arr[x];
  arr[x] = arr[y];
  arr[y] = i;
};

const quicksort1 = (arr: number[], low: number, high: number) => {
  if (low >= high) {
    return;
  }

  const pivot = partition1(arr, low, high);

  quicksort1(arr, low, pivot - 1);
  quicksort1(arr, pivot + 1, high);
};

const partition1 = (arr: number[], low: number, high: number) => {
  const pivot = arr[low];

  let [l, r] = [low, high];

  while (l < r) {
    // 必須先從R開始，這樣才可以保證L最小，促使整體左邊最小
    while (l < r && arr[r] >= pivot) {
      r -= 1;
    }

    while (l < r && arr[l] <= pivot) {
      l += 1;
    }

    swap(arr, l, r);
  }

  // arr[R+1] >= arr[L] == arr[R] >= pivot >= arr[L-1]
  swap(arr, l, low);

  // arr[....L-1] >= pivot >= arr[R+1...]
  return l;
};

// --------------

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
