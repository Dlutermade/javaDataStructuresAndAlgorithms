#### 遞迴起始式

```java
static void quickSort(int[] arr, int low, int high) {
  if (low < high) {
    int array_partiton = partition(arr, low, high);

    quickSort(arr, low, array_partiton - 1);
    quickSort(arr, array_partiton + 1, high);
  }
}
```

---
 
#### partition 切割 

Lomuto partition scheme 效能比較差

保障 x+1 以下的 index 都比 pivot 小

```java
static int partition(int[] arr, int low, int high) {
  int pivot = arr[high];

  int x = low - 1;

  for (int i = low; i < high; i++) {
    if (arr[i] <= pivot) {
      x++;
      swap(arr, x, i);
    }
  }

  swap(arr, x + 1, high);

  return x + 1;
}
```
