
public class VaildateBinarySearchTree {
  public class TreeNode {

    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
      this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
      this.val = val;
      this.left = left;
      this.right = right;
    }
  }

  public boolean isValidBST(TreeNode root) {
    if (root == null)
      return true;
    return isValidBST_helper(root);
  }

  private boolean isValidBST_helper(TreeNode node) {
    if (node == null)
      return true;

    // main logic
    // find right-tree min
    if (node.right != null) {
      TreeNode node_right = getMin(node.right);
      if (node.val >= node_right.val) {
        return false;
      }
    }

    if (node.left != null) {
      TreeNode node_left = getMax(node.left);
      if (node.val <= node_left.val) {
        return false;
      }
    }

    return isValidBST_helper(node.left) && isValidBST_helper(node.right);
  }

  private TreeNode getMax(TreeNode root) {
    if (root == null)
      return null;

    while (true) {
      if (root.right == null)
        break;

      root = root.right;
    }

    return root;
  }

  private TreeNode getMin(TreeNode root) {
    if (root == null)
      return null;

    while (true) {
      if (root.left == null)
        break;

      root = root.left;
    }

    return root;
  }
}
