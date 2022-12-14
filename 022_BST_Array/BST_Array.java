public class BST_Array {
  public Integer[] nums;
  public Integer[] bst;

  public BST_Array(Integer[] nums) {
    this.nums = nums;
  }

  public void build_tree() {
    bst = new Integer[nums.length];
    for (int i = 0; i < bst.length; i++) {
      add(nums[i]);
    }
  }

  private void add(Integer val) {
    int i_root = 0;
    add(i_root, val);
  }

  private void add(int i_node, Integer val) {
    if (i_node >= bst.length) {
      expand_space();
    }

    if (bst[i_node] == null) {
      bst[i_node] = val;
      return;
    }

    if (val == bst[i_node]) {
      System.out.print("\nnode:" + val + " already exists. skip insert."); // traverse stop
    } else if (val < bst[i_node]) {
      add((i_node + 1) * 2 - 1, val);
    } else if (val > bst[i_node]) {
      add((i_node + 1) * 2, val);
    }
  }

  private void expand_space() {
    Integer[] bst_new = new Integer[bst.length * 3];
    for (int i = 0; i < bst_new.length; i++) {
      bst_new[i] = bst[i];
    }

    this.bst = bst_new;
  }

  public Integer search(Integer val) {
    int i_root = 0;

    if (bst[i_root] == null)
      return null;

    return search(i_root, val);
  }

  /**
   * attention: we can NOT implement delete in array for BST
   * why: it's too complex to maintain
   * example: delete one node, "all" of its child nodes have to be moved left
   * example: {5,X,6,1,4,7,3,9,11,19,13,21}
   */
  public void delete(int val) {
  }

  private Integer search(int i_node, Integer val) {
    if (i_node >= bst.length)
      return null;

    if (bst[i_node] == null)
      return null;

    Integer result = null;

    if (val == bst[i_node]) {
      result = i_node;
    } else if (val < bst[i_node]) {
      result = search((i_node + 1) * 2 - 1);
    } else if (val > bst[i_node]) {
      result = search((i_node + 1) * 2);
    }

    return result;
  }
}
