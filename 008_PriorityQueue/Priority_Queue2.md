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
2. 本質上是Heap


## 自訂義排序類別
```java
static class MyComp implements Comparator<Person> {

  @Override
  public int compare(Person p1, Person p2) {
    return p1.peepee_wait_time - p2.peepee_wait_time;
  }
}
```

## 自訂義比較物件
```java
new Comparator<Person> (){

  @Override
  public int compare(Person p1, Person p2) {
    return p1.peepee_wait_time - p2.peepee_wait_time;
  }
}
```

## java compare 等價方式
```java
p1.peepee_wait_time.compareTo(p2.peepee_wait_time) // -1, 0, 1
p1.peepee_wait_time - p2.peepee_wait_time;
```