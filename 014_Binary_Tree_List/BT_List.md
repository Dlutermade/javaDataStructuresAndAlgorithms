## Node 節點

```java
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
```

## 二元樹類別成員

```java
private Integer[] nums; // 存放原始線性數據
private Node root; // 根節點
```

## 建構二元樹

```java

public void buildTree() {
  // 判別長度是否符合預期且有根節點
  if (this.nums.length < 0)
    return;
  if (this.nums[0] == null)
    return;

  // 從原始整數Array轉換成NodeArray
  Node[] nodes_tmp = new Node[this.nums.length];
  for (int i = 0; i < this.nums.length; i++) {
    if (this.nums[i] == null)
      continue;

    nodes_tmp[i] = new Node(this.nums[i]);
  }

  // 定義根節點
  this.root = nodes_tmp[0];

  // 將節點之間進行鏈結
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
```

---

## Pre-Order 先印

```java
public void traverse_preorder(Node node) {
  if (node == null)
    return;

  System.out.println(node.val + " ");
  traverse_preorder(node.left);
  traverse_preorder(node.right);
}
```

## In-Order 單方向走完 再印

```java
public void traverse_inorder(Node node) {
  if (node == null)
    return;

  traverse_inorder(node.left);
  System.out.println(node.val + " ");
  traverse_inorder(node.right);
}
```

## Post-Order 雙方向走完 再印

```java
public void traverse_inorder(Node node) {
  if (node == null)
    return;

  traverse_postorder(node.left);
  traverse_postorder(node.right);
  System.out.println(node.val + " ");
}
```