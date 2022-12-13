public class BT_Array {
  private Integer[] nums;

  public BT_Array(Integer[] nums) {
    this.nums = nums;
  }

  public void traverse_preorder() {
    if (this.nums.length < 0)
      return;

    int i_root = 0;

    if (this.nums[i_root] == null)
      return;

    traverse_preorder(i_root);
  }

  private void traverse_preorder(int i) {
    if (i >= this.nums.length)
      return;

    int i_plsh_one = i + 1;
    int i_left = i_plsh_one * 2 - 1;
    int i_right = i_plsh_one * 2 + 1 - 1;

    if (this.nums[i] != null)
      System.out.print(this.nums[i] + " ");
    traverse_preorder(i_left);
    traverse_preorder(i_right);
  }

  public void traverse_inorder() {
    if (this.nums.length < 0)
      return;

    int i_root = 0;

    if (this.nums[i_root] == null)
      return;

    traverse_inorder(i_root);
  }

  private void traverse_inorder(int i) {
    if (i >= this.nums.length)
      return;

    int i_plsh_one = i + 1;
    int i_left = i_plsh_one * 2 - 1;
    int i_right = i_plsh_one * 2 + 1 - 1;

    traverse_inorder(i_left);
    if (this.nums[i] != null)
      System.out.print(this.nums[i] + " ");
    traverse_inorder(i_right);
  }

  public void traverse_postorder() {
    if (this.nums.length < 0)
      return;

    int i_root = 0;

    if (this.nums[i_root] == null)
      return;

    traverse_postorder(i_root);
  }

  private void traverse_postorder(int i) {
    if (i >= this.nums.length)
      return;

    int i_plsh_one = i + 1;
    int i_left = i_plsh_one * 2 - 1;
    int i_right = i_plsh_one * 2 + 1 - 1;

    traverse_postorder(i_left);
    traverse_postorder(i_right);
    if (this.nums[i] != null)
      System.out.print(this.nums[i] + " ");
  }

  // --------------
  public void traverse_preorderRight() {
    if (this.nums.length < 0)
      return;

    int i_root = 0;

    if (this.nums[i_root] == null)
      return;

    traverse_preorderRight(i_root);
  }

  private void traverse_preorderRight(int i) {
    if (i >= this.nums.length)
      return;

    int i_plsh_one = i + 1;
    int i_left = i_plsh_one * 2 - 1;
    int i_right = i_plsh_one * 2 + 1 - 1;

    if (this.nums[i] != null)
      System.out.print(this.nums[i] + " ");
    traverse_preorderRight(i_right);
    traverse_preorderRight(i_left);
  }

  public void traverse_inorderRight() {
    if (this.nums.length < 0)
      return;

    int i_root = 0;

    if (this.nums[i_root] == null)
      return;

    traverse_inorderRight(i_root);
  }

  private void traverse_inorderRight(int i) {
    if (i >= this.nums.length)
      return;

    int i_plsh_one = i + 1;
    int i_left = i_plsh_one * 2 - 1;
    int i_right = i_plsh_one * 2 + 1 - 1;

    traverse_inorderRight(i_right);
    if (this.nums[i] != null)
      System.out.print(this.nums[i] + " ");
    traverse_inorderRight(i_left);
  }

  public void traverse_postorderRight() {
    if (this.nums.length < 0)
      return;

    int i_root = 0;

    if (this.nums[i_root] == null)
      return;

    traverse_postorderRight(i_root);
  }

  private void traverse_postorderRight(int i) {
    if (i >= this.nums.length)
      return;

    int i_plsh_one = i + 1;
    int i_left = i_plsh_one * 2 - 1;
    int i_right = i_plsh_one * 2 + 1 - 1;

    traverse_postorderRight(i_right);
    traverse_postorderRight(i_left);
    if (this.nums[i] != null)
      System.out.print(this.nums[i] + " ");
  }

  public static void main(String[] args) {
    Integer[] nums = {
        5, 2, 6, 1, 4, null, 7, null, null, 3, null, null, null, null, null
    };
    /*---------5
     *----2---------6
     *--1---4-----n---7
     *-n-n-3-n---n-n-n-n
     */
    BT_Array bt = new BT_Array(nums);
    System.out.println();

    /** traverse (DFS left) **/
    System.out.println("Left\n");
    System.out.print("pre-order: ");
    bt.traverse_preorder();
    System.out.print("\nin-order: ");
    bt.traverse_inorder();
    System.out.print("\npost-order: ");
    bt.traverse_postorder();
    /** traverse (DFS Right) **/
    System.out.println("\nRight\n ");
    System.out.print("pre-order: ");
    bt.traverse_preorderRight();
    System.out.print("\nin-order: ");
    bt.traverse_inorderRight();
    System.out.print("\npost-order: ");
    bt.traverse_postorderRight();
  }

}
