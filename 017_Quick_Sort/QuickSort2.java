public class QuickSort2 {

  static void quickSort(int[] arr, int low, int high) {
    if (low < high) {
      int array_partiton = partition(arr, low, high);

      quickSort(arr, low, array_partiton - 1);
      quickSort(arr, array_partiton + 1, high);
    }
  }

  // Lomuto partition scheme
  static int partition(int[] arr, int low, int high) {
    int pivot = arr[high];

    int x = low;

    for (int i = low; i < high; i++) {
      if (arr[i] <= pivot) {
        swap(arr, x, i);
        x++;
      }
    }

    swap(arr, x, high);

    return x;
  }

  static void swap(int[] arr, int x, int y) {
    int tmp = arr[x];
    arr[x] = arr[y];
    arr[y] = tmp;
  }

  public static void main(String[] args) {
    // int[] arr = { 5, 4, 3, 2, 1 };
    // int[] arr = { 7, 6, 5, 4, 3, 2, 1 };
    // int[] arr = { 1, 2, 3, 4, 5 };
    // int[] arr = { 5, 4, 3, 3, 3 };
    // int[] arr = { 3, 3, 3, 2, 1 };
    int[] arr = { 24, 2, 45, 20, 56, 75, 2, 56, 99, 53, 12 };
    // int[] arr = { 20, 10, 50, 30, 70, 60, 40 };
    QuickSort2.quickSort(arr, 0, arr.length - 1);

    System.out.print("排序完");
    for (int i : arr) {
      System.out.print(i + " ");
    }

  }
}
