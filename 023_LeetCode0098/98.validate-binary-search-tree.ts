/*
 * @lc app=leetcode id=98 lang=typescript
 *
 * [98] Validate Binary Search Tree
 */

// @lc code=start

//  Definition for a binary tree node.
{
  class TreeNode {
    val: number;
    left: TreeNode | null;
    right: TreeNode | null;
    constructor(val?: number, left?: TreeNode | null, right?: TreeNode | null) {
      this.val = val === undefined ? 0 : val;
      this.left = left === undefined ? null : left;
      this.right = right === undefined ? null : right;
    }
  }

  function isValidBST(root: TreeNode | null): boolean {
    if (root === null) {
      return true;
    }

    if (root.left) {
      let leftMax = getMax(root.left);
      if (leftMax && leftMax.val >= root.val) {
        return false;
      }
    }

    if (root.right) {
      let rightMin = getMin(root.right);
      if (rightMin && rightMin.val <= root.val) {
        return false;
      }
    }

    return isValidBST(root.left) && isValidBST(root.right);
  }

  const getMax = (root: TreeNode | null) => {
    let prev = root;
    while (root) {
      prev = root;
      root = root.right;
    }
    return prev;
  };

  const getMin = (root: TreeNode | null) => {
    let prev = root;
    while (root) {
      prev = root;
      root = root.left;
    }
    return prev;
  };
}

// @lc code=end
