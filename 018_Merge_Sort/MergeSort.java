/**
 * MergeSort
 */
public class MergeSort {
  public static void merge_sort(int[] nums) {
    if (nums == null || nums.length == 0)
      return;

    merge_sort(nums, 0, nums.length - 1);
  }

  private static void merge_sort(int[] nums, int i_start, int i_end) {
    if (i_start == i_end)
      return;

    int i_mid = (i_start + i_end) / 2;

    merge_sort(nums, i_start, i_mid);
    merge_sort(nums, i_mid + 1, i_end);

    sort(nums, i_start, i_mid, i_end);
  }

  private static void sort(int[] nums, int i_start, int i_mid, int i_end) {
    int[] nums_tmp = new int[nums.length];
    int i_nums_tmp = i_start;

    int i_left_ary = i_start;
    int i_right_ary = i_mid + 1;

    while (true) {
      if (i_nums_tmp > i_end)
        break;

      Integer left = null;
      Integer right = null;

      if (i_left_ary <= i_mid)
        left = nums[i_left_ary];

      if (i_right_ary <= i_end)
        right = nums[i_right_ary];

      if (left != null && right != null) {
        if (left <= right) {
          nums_tmp[i_nums_tmp] = left;
          i_left_ary++;
        } else if (left > right) {
          nums_tmp[i_nums_tmp] = right;
          i_right_ary++;
        }
      } else if (left != null) {
        nums_tmp[i_nums_tmp] = left;
        i_left_ary++;
      } else if (right != null) {
        nums_tmp[i_nums_tmp] = right;
        i_right_ary++;
      }

      i_nums_tmp++;
    }

    for (int i = i_start; i <= i_end; i++) {
      nums[i] = nums_tmp[i];
    }

  }

  public static void main(String[] args) {
    // int[] ary = { 5, 4, 3, 2, 1 };
    // int[] ary = { 1, 2, 3, 4, 5 };
    // int[] ary = { 5, 4, 3, 3, 3 };
    // int[] ary = { 3, 3, 3, 2, 1 };
    int[] ary = { 24, 2, 45, 20, 56, 75, 2, 56, 99, 53, 12 };
    MergeSort.merge_sort(ary);

    System.out.print("排序完");
    for (int i : ary) {
      System.out.print(i + " ");
    }

  }

}