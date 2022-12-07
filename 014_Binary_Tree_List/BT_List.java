public class BT_List {
  class Node {
    Node left;
    Node right;
    int val;

    Node() {
    }

    Node(int val) {
      this.val = val;
    }

  }

  private Integer[] nums;
  private Node root;

  BT_List(Integer[] nums) {
    this.nums = nums;
  }

  public void buildTree() {
    if (this.nums.length < 0)
      return;
    if (this.nums[0] == null)
      return;

    // prepare Node instances
    Node[] nodes_tmp = new Node[this.nums.length];
    for (int i = 0; i < this.nums.length; i++) {
      if (this.nums[i] == null)
        continue;

      nodes_tmp[i] = new Node(this.nums[i]);
    }

    this.root = nodes_tmp[0];

    for (int i = 0; i < this.nums.length; i++) {
      int i_left = (i + 1) * 2 - 1;
      int i_right = (i + 1) * 2;

      Node node = nodes_tmp[i];

      if (node == null)
        continue;

      if (i_left < this.nums.length) {
        node.left = nodes_tmp[i_left];
      }

      if (i_right < this.nums.length) {
        node.right = nodes_tmp[i_right];
      }
    }
  }

  public void traverse_preorder() {
    if (this.root == null)
      return;
    traverse_preorder(this.root);
  }

  public void traverse_preorder(Node node) {
    if (node == null)
      return;

    System.out.print(node.val + " ");
    traverse_preorder(node.left);
    traverse_preorder(node.right);
  }

  public void traverse_inorder() {
    if (this.root == null)
      return;
    traverse_inorder(this.root);
  }

  public void traverse_inorder(Node node) {
    if (node == null)
      return;

    traverse_inorder(node.left);
    System.out.print(node.val + " ");
    traverse_inorder(node.right);
  }

  public void traverse_postorder() {
    if (this.root == null)
      return;
    traverse_postorder(this.root);
  }

  public void traverse_postorder(Node node) {
    if (node == null)
      return;

    traverse_postorder(node.left);
    traverse_postorder(node.right);
    System.out.print(node.val + " ");
  }

  // --------------

  public void traverse_preorderRight() {
    if (this.root == null)
      return;
    traverse_preorderRight(this.root);
  }

  public void traverse_preorderRight(Node node) {
    if (node == null)
      return;

    System.out.print(node.val + " ");
    traverse_preorderRight(node.right);
    traverse_preorderRight(node.left);
  }

  public void traverse_inorderRight() {
    if (this.root == null)
      return;
    traverse_inorderRight(this.root);
  }

  public void traverse_inorderRight(Node node) {
    if (node == null)
      return;

    traverse_inorderRight(node.right);
    System.out.print(node.val + " ");
    traverse_inorderRight(node.left);

  }

  public void traverse_postorderRight() {
    if (this.root == null)
      return;
    traverse_postorderRight(this.root);
  }

  public void traverse_postorderRight(Node node) {
    if (node == null)
      return;

    traverse_postorderRight(node.right);
    traverse_postorderRight(node.left);
    System.out.print(node.val + " ");
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
    BT_List bt = new BT_List(nums);
    bt.buildTree();
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
    System.out.println("Right\n");
    System.out.print("pre-order: ");
    bt.traverse_preorderRight();
    System.out.print("\nin-order: ");
    bt.traverse_inorderRight();
    System.out.print("\npost-order: ");
    bt.traverse_postorderRight();
  }

}
