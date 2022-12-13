#### 搜尋

```java
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
```

1. if target == current value : found the target
2. if target < current value : -> goto node.left
3. if target > current value : -> goto node.right

---

#### 插入 ( 新增 )

```java
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
```

1. 先同搜尋方式，直到找到 empty 位置 然後 create node，並 return ( 回傳給上一個函數，讓previous node接骨 )
2. 不同之處 遇到相同元素 結束，因為不允許創建重複元素

---

#### Delete

```java
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
  } else if (val < node.val) { // Search 
    BST_Node node_child = delete(node.left, val);
    if (node.left != node_child) {
      node.left = node_child; // Insert
    }
  } else if (val > node.val) { // Search
    BST_Node node_child = delete(node.left, val);
    if (node.right != node_child) {
      node.right = node_child; // Insert
    }
  }

  return node;
}
```

1. 先搜尋，因為會 Change Tree，所以當 Value Not Equal 時候 Possible (可能) Insert
2. 有四種可能性
   1. left and right is null      -> return null
   2. left not null               -> retrun left
   3. right not null              -> retrun right
   4. left and right in not null  -> swap right tree smallest node, from right tree delete the value

---

#### Get Min

```java
private BST_Node get_min(BST_Node root) {
  BST_Node node = root;

  while (true) {
    if (node.left == null)
      break;
    node = node.left;
  }

  return node;
}
```

1. 往左邊走到底

#### swap value

```java
private void swap_node_val(BST_Node left, BST_Node right) {
  int tmp = left.val;
  left.val = right.val;
  right.val = tmp;
}
```