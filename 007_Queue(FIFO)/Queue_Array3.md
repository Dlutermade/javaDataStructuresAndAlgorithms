```java
Integer[] ary;
Integer[] queue;
Integer i_front = null;
Integer i_end = null;
```

1. ary 是初始化帶入的資料
2. queue是底層容器
3. i_front是讀頭
4. i_end是寫頭

## offer
```java
public void offer(Integer val) {
  if (size() == queue.length) {
    expand_space();
  }

  if (size() == 0) {
    i_front = 0;
    i_end = 0;
  } else {
    i_end = (i_end + 1) % queue.length;
  }

  queue[i_end] = val;
}
```

1. 環狀寫頭，需要回歸原點
   所以 i_end = (i_end + 1) % queue.length;

---

## poll
```java
public Integer poll() {
  if (size() == 0) {
    return null;
  }

  Integer val = queue[i_front];
  queue[i_front] = null;

  if (size() == 1) {
    i_front = null;
    i_end = null;
  } else {
    i_front = (i_front + 1) % queue.length;
  }

  return val;
}
```

1. 環狀讀頭，需要回歸原點
   所以 i_front = (i_front + 1) % queue.length;

---

## size
```java
private int size() {
  if (i_front == null && i_end == null) {
    return 0;
  }
    return (i_end - i_front + queue.length) % queue.length + 1;
}
```

1. 環狀佇列可能發生 i_front大於i_end的情況因此需要 + queue.length % queue.length
2. 當讀頭和寫頭重疊時候，是一個元素所以需要+1

---

## expand_space
```java
private void expand_space() {
  Integer[] queue_new = new Integer[queue.length * 2];

  int i = 0;
  while (true) {
    if (size() == 0) {
      break;
    }

    Integer val = poll();
    queue_new[i] = val;
    i++;
  }

  i_front = 0;
  i_end = i - 1;

  queue = queue_new;
}
```

1. 擴展空間時候，必須清空原本的佇列，換到新的佇列上，再重新定義讀寫頭