```java
Integer[] ary;
Node node_top;
```

1. ary 是初始化帶入的資料
2. node_top是Stack的頂層節點

## Push
```java
public void push(Integer val) {
  if (node_top == null) {
    node_top = new Node(val);
  } else {
    Node node_new = new Node(val);
    node_new.next = node_top;
    node_top = node_new;
  }
}
```
1. 當沒有頂層節點時候，頂層結點直接是新的value
2. 反之 創建一個新的Node並把自己的下一個值 = 頂層結點
   在讓 頂層結點 = 自己節點 

---

## Pop
```java
public Integer pop() {
  if (node_top == null) {
    return null;
  }

  Node node = node_top;
  node_top = node_top.next;

  return node.val;
}
```

1. 如果沒有頂層結點，回傳Null
2. 儲存頂層結點，將頂層結點 = 頂層結點的下一個值
3. return 剛剛儲存起來的節點