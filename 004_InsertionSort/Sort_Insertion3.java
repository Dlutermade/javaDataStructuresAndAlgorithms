public class Sort_Insertion3 {
  public static void insertion_sort(int[] nums) {
    for (int i_start = 0; i_start < nums.length; i_start++) {
      for (int i_run = i_start - 1; i_run >= 0; i_run--) {
        if (nums[i_run + 1] < nums[i_run]) {
          swap(nums, i_run + 1, i_run);
        } else {
          break;
        }
      }
    }
  }

  public static void insertion_sort_recursion(int[] nums) {
    int i_start = 0;
    insertion_sort_recursion_help01(nums, i_start);
  }

  private static void insertion_sort_recursion_help01(int[] nums, int i_start) {
    if (i_start >= nums.length) {
      return;
    }

    int i_run = i_start - 1;
    insertion_sort_recursion_help02(nums, i_run);

    insertion_sort_recursion_help01(nums, i_start + 1);
  }

  private static void insertion_sort_recursion_help02(int[] nums, int i_run) {
    if (i_run < 0) {
      return;
    }

    if (nums[i_run + 1] < nums[i_run]) {
      swap(nums, i_run + 1, i_run);
      insertion_sort_recursion_help02(nums, i_run - 1);
    }
  }

  private static void swap(int[] nums, int i_left, int i_right) {
    int tmp = nums[i_left];
    nums[i_left] = nums[i_right];
    nums[i_right] = tmp;
  }

  public static void main(String[] args) {
    int[] a = { 10, 20, 50, 40 };
    insertion_sort(a);

    for (int i : a) {
      System.out.println(i + " ");
    }
  }
}
