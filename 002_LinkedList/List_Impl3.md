```java
 public void add(int val) {
    if (start == null) {
      // 開始即最後一個元素
      start = new Node(val);
      end = start;
    } else {
      // 最後一個元素 連結 新元素
      // 最後一個元素 變更 為自己所連結元素
      end.next = new Node(val);
      end = end.next;
    }
  }

```

## remove 需要紀錄上一個搜尋迴圈的結點

```java
while (true) {
  if (node == null)
    break;

  if (node.val == val) {
    node_target = node;
    break;
  }

  node_prev = node;
  node = node.next;
}
```

## 正式刪除時候

1. node_target如果是null代表沒找到
2. A => B => C  要變成 B => C
  即 start = start.next
3. A => B => C 要變成 A => B
  即 node_prev.next = null, end = node_prev
4. A => B => C 要變成 A => C
  即 node_prev.next = node_target
  變 node_prev.next = node_target.next

```java
if (node_target == null)
  return;

if (node_target == start) {
  start = start.next;
} else if (node_target == end) {
  node_prev.next = null;
  end = node_prev;
} else {
  node_prev.next = node_target.next;
}

```
