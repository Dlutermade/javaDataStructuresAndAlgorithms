## offer
```java
public void offer(Integer val) {
  if (node_front == null) {
    node_front = new Node(val);
    node_end = node_front;
  } else {
    Node node_new = new Node(val);
    node_end.next = node_new;
    node_end = node_new;
  }
}
```

1. 新增的時候如果讀頭是null代表讀頭以及寫頭需要初始化
2. 反之新增元素給寫頭，並把寫頭 = 自己

---

## offer
```java
public Integer poll() {
  if (node_front == null) {
    return null;
  }

  Node node = node_front;
  node_front = node_front.next;

  if (node_front == null) {
    node_end = null;
  }

  return node.val;
}
```

1. 讀頭 = 下一個元素