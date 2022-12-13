class TreeNode {
  public left: TreeNode | null = null;
  public right: TreeNode | null = null;

  constructor(public value: number) {}
}

class BinarySearchTree {
  public root: TreeNode | null = null;

  public search(value: number) {
    let currentNode = this.root;

    while (currentNode) {
      if (value === currentNode.value) {
        return currentNode;
      } else if (value < currentNode.value) {
        currentNode = currentNode.left;
      } else {
        currentNode = currentNode.right;
      }
    }

    return null;
  }

  public insert(value: number) {
    const node = new TreeNode(value);

    if (this.root === null) {
      this.root = node;
    } else {
      let currentNode = this.root;

      while (currentNode) {
        if (value === currentNode.value) {
          console.log("重複了");
          break;
        } else if (value < currentNode.value) {
          if (currentNode.left === null) {
            currentNode.left = node;
            return;
          }

          currentNode = currentNode.left;
        } else {
          if (currentNode.right === null) {
            currentNode.right = node;
            return;
          }

          currentNode = currentNode.right;
        }
      }
    }
  }

  public delete(value: number) {
    this.root = this.deleteRecursively(this.root, value);
  }

  public deleteRecursively(node: TreeNode | null, value: number) {
    if (node === null) {
      return null;
    }

    if (value === node.value) {
      node = this.deleteNode(node);
    } else if (value < node.value) {
      node.left = this.deleteRecursively(node.left, value);
    } else {
      node.right = this.deleteRecursively(node.right, value);
    }

    return node;
  }

  public deleteNode(root: TreeNode) {
    if (root.left === null && root.right === null) {
      return null;
    } else if (root.left && root.right) {
      const successorNode = this.getMax(root.left);
      const successorValue = successorNode.value;

      const node = this.deleteRecursively(root, successorValue) as TreeNode;

      node.value = successorValue;

      return node;
    } else if (root.left) {
      return root.left;
    } else {
      return root.right;
    }
  }

  private getMax(node: TreeNode) {
    let currentNode: TreeNode = node;

    // 找最大值
    while (currentNode) {
      if (currentNode.right === null) {
        break;
      }

      currentNode = currentNode.right;
    }

    return currentNode;
  }
}
