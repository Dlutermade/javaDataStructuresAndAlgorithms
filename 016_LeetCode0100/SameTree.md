## 同一棵樹

判斷兩個二元樹是否相同

#### 關鍵點

同時遍歷兩棵樹

```java
isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
```

節點的終點

```java
if (p == null && q == null) {
  return true;
}
```

兩棵樹節點不同了，或是兩個值不同

```java
if (p == null || q == null || p.val != q.val) {
  return false;
}
```

---

```java
public boolean isSameTree(TreeNode p, TreeNode q) {
  if (p == null && q == null) {
    return true;
  }

  if (p == null || q == null || p.val != q.val) {
    return false;
  }

  return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
}
```
