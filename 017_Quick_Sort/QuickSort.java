public class QuickSort {
  public static void quick_sort(int[] nums) {
    if (nums == null || nums.length == 0)
      return;

    quick_sort(nums, 0, nums.length - 1);
  }

  private static void quick_sort(int[] nums, int i_start, int i_end) {
    if (i_start >= i_end)
      return;

    int i_pivot_guess = get_pivot_index(i_start, i_end);

    int i_pivot_final = sort(nums, i_start, i_pivot_guess, i_end);

    quick_sort(nums, i_start, i_pivot_final - 1);
    quick_sort(nums, i_pivot_final + 1, i_end);

  }

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

  private static int get_pivot_index(int i_start, int i_end) {
    return (i_start + i_end) / 2; // 中位數
  }

  private static void swap(int[] nums, int i_left, int i_right) {
    int tmp = nums[i_left];
    nums[i_left] = nums[i_right];
    nums[i_right] = tmp;
  }

  public static void main(String[] args) {
    // int[] ary = { 5, 4, 3, 2, 1 };
    // int[] ary = { 7, 6, 5, 4, 3, 2, 1 };
    // int[] ary = { 1, 2, 3, 4, 5 };
    // int[] ary = { 5, 4, 3, 3, 3 };
    // int[] ary = { 3, 3, 3, 2, 1 };
    // int[] ary = { 24, 2, 45, 20, 56, 75, 2, 56, 99, 53, 12 };
    int[] ary = { 20, 10, 50, 30, 70, 60, 40 };
    QuickSort.quick_sort(ary);

    System.out.print("排序完");
    for (int i : ary) {
      System.out.print(i + " ");
    }

  }
}
