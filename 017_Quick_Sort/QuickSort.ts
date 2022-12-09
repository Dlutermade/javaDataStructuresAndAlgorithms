const swap = (arr: number[], x: number, y: number) => {
  const i = arr[x];
  arr[x] = arr[y];
  arr[y] = i;
};

const partition = (arr: number[], low: number, high: number) => {
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

  // arr[R+1]  >= arr[L] == arr[R] >= pivot >= arr[L-1]
  swap(arr, l, low);

  // arr[....L-1] >= pivot >= arr[R+1...]
  return l;
};

const quicksort = (arr: number[], low: number, high: number) => {
  if (low >= high) {
    return;
  }

  const pivot = partition(arr, low, high);

  quicksort(arr, low, pivot - 1);
  quicksort(arr, pivot + 1, high);
};
