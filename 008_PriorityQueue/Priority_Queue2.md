```java
Integer[] nums = { 4, 3, 1, 5, 2 };
PriorityQueue<Integer> pq = new PriorityQueue<>();

for (Integer i : nums) {
  pq.add(i);
}

while (true) {
  if (pq.size() == 0) {
    break;
  }

  Integer num = pq.poll();
  System.out.print(num + " ");
}
```

## Priority_Queue
1. 預設由小到大排序 (指輸出順序)