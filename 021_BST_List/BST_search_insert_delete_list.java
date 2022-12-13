public class BST_search_insert_delete_list {
  public static class BST_Node {
    public BST_Node left;
    public BST_Node right;
    public int val;

    public BST_Node(int val) {
      this.val = val;
    }
  }

  private int[] nums;
  private BST_Node root;

  public BST_search_insert_delete_list(int[] nums) {
    this.nums = nums;
  }

  public void buildTree() {
    for (int i = 0; i < this.nums.length; i++) {
      add(this.nums[i]);
    }
  }

  // insert
  private void add(int val) {
    BST_Node root_after_add = add(this.root, val);
    if (this.root != root_after_add) {
      this.root = root_after_add;
    }
  }

  private BST_Node add(BST_Node node, int val) {
    if (node == null) {
      return new BST_Node(val);
    }

    if (node.val == val) { // 已經存在該元素，所以新增失敗
      System.out.print("\nnode:" + val + " already exists. skip insert."); // traverse stop
    } else if (val < node.val) {
      BST_Node node_child = add(node.left, val);
      if (node.left != node_child) { // 往左邊新增成功，成功則不會是原本的值
        node.left = node_child;
      }

    } else if (val > node.val) {
      BST_Node node_child = add(node.right, val);
      if (node.right != node_child) { // 往右邊新增成功
        node.right = node_child;
      }
    }

    return node;
  }

  // delete

  public void delete(int val) {
    if (this.root == null)
      return;

    BST_Node root_after_delete = delete(this.root, val);
    if (this.root != root_after_delete) {
      this.root = root_after_delete;
    }
  }

  private BST_Node delete(BST_Node node, int val) {
    if (node == null)
      return null;

    if (val == node.val) {
      // main logic
      if (node.left == null && node.right == null) {
        return null;
      } else if (node.left != null && node.right == null) {
        return node.left;
      } else if (node.left == null && node.right != null) {
        return node.right;
      } else {
        BST_Node node_righttree_min = get_min(node.right);

        swap_node_val(node, node_righttree_min);

        BST_Node node_child = delete(node.right, val);
        if (node.right != node_child) {
          node.right = node_child;
        }
      }
    } else if (val < node.val) { // search
      BST_Node node_child = delete(node.left, val);
      if (node.left != node_child) {
        node.left = node_child;
      }
    } else if (val > node.val) { // search
      BST_Node node_child = delete(node.left, val);
      if (node.right != node_child) {
        node.right = node_child;
      }
    }

    return node;
  }

  private void swap_node_val(BST_Node left, BST_Node right) {
    int tmp = left.val;
    left.val = right.val;
    right.val = tmp;
  }

  private BST_Node get_min(BST_Node root) {
    BST_Node node = root;

    while (true) {
      if (node.left == null)
        break;
      node = node.left;
    }

    return node;
  }

  public BST_Node search(int val) {
    if (this.root == null)
      return null;

    return search(this.root, val);
  }

  private BST_Node search(BST_Node node, int val) {
    if (node == null)
      return null;

    BST_Node result = null;

    if (val == node.val) {
      result = node;
    } else if (val < node.val) {
      result = search(node.left, val);
    } else if (val > node.val) {
      result = search(node.right, val);
    }

    return result;
  }

  public static void main(String[] args) {
    int[] nums = { 5, 2, 6, 1, 4, 7, 3 };
    BST_search_insert_delete_list bst = new BST_search_insert_delete_list(nums);
    bst.buildTree();
  }
}
