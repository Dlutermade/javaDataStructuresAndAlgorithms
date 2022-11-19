public class Sort_Bubble3 {
  public static void bubble_sort(int[] nums) {
    for (int round = 0; round < nums.length; round++) {
      int len = nums.length - round; // improved version 改良版
      for (int i_run = 1; i_run < len; i_run++) {
        if (nums[i_run - 1] > nums[i_run]) {
          swap(nums, i_run - 1, i_run);
        }
      }
    }
  }

  public static void bubble_sort_recursion(int[] nums) {
    int round = 0;
    bubble_sort_recursion_help01(nums, round);

  }

  private static void bubble_sort_recursion_help01(int[] nums, int round) {
    // end condition
    if (round >= nums.length) {
      return;
    }

    // main logic
    int len = nums.length - round;
    int i_run = 1;
    bubble_sort_recursion_help02(nums, i_run, len);

    // data flow
    bubble_sort_recursion_help01(nums, round + 1);
  }

  private static void bubble_sort_recursion_help02(int[] nums, int i_run, int len) {
    if (i_run >= len) {
      return;
    }

    if (nums[i_run - 1] > nums[i_run]) {
      swap(nums, i_run - 1, i_run);
    }

    // data flow
    bubble_sort_recursion_help02(nums, i_run + 1, len);
  }

  private static void swap(int[] nums, int i_left, int i_right) {
    int tmp = nums[i_left];
    nums[i_left] = nums[i_right];
    nums[i_right] = tmp;
  }

  public static void main(String[] args) {
    int[] nums = new int[] { 8, 2, 6, 10, 4 };
    Sort_Bubble3.bubble_sort(nums);

    System.out.println();

  }
}
