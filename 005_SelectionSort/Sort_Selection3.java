public class Sort_Selection3 {
  public static void selection_sort(int[] nums) {
    for (int i_start = 0; i_start < nums.length; i_start++) {
      int i_min = i_start;
      // 回合方向 ->
      // 比較且尋找方向(當前回合值+1開始) ->
      for (int i_run = i_start + 1; i_run < nums.length; i_run++) {
        // 尋找最小值的index
        if (nums[i_min] > nums[i_run]) {
          i_min = i_run;
        }
      }

      swap(nums, i_start, i_min);
    }
  }

  public static void selection_sort_recursion(int[] nums) {
    int i_start = 0;
    selection_sort_recursion_help01(nums, i_start);
  }

  private static void selection_sort_recursion_help01(int[] nums, int i_start) {
    if (i_start >= nums.length) {
      return;
    }
    int i_min = i_start;
    int i_run = i_start + 1;

    i_min = selection_sort_recursion_help02(nums, i_min, i_run);
    swap(nums, i_start, i_min);

    selection_sort_recursion_help01(nums, i_start + 1);
  }

  private static int selection_sort_recursion_help02(int[] nums, int i_min, int i_run) {
    if (i_run >= nums.length) {
      return i_min;
    }

    if (nums[i_min] > nums[i_run]) {
      i_min = i_run;
    }

    return selection_sort_recursion_help02(nums, i_min, i_run + 1);
  }

  private static void swap(int[] nums, int i_left, int i_right) {
    int tmp = nums[i_left];
    nums[i_left] = nums[i_right];
    nums[i_right] = tmp;
  }

  public static void main(String[] args) {
    int[] a = { 10, 20, 50, 40 };
    selection_sort(a);

    for (int i : a) {
      System.out.println(i + " ");
    }
  }
}
