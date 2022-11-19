```java
Integer[] ary;
Integer[] stack;
Integer i_top = null; // LIFO
```

1. ary 是初始化帶入的資料
2. stack是底層容器
3. i_top是Stack指標

## Push
```java
public void push(Integer val) {
  if (size() == stack.length) {
    expand_space();
  }

  if (size() == 0) {
    i_top = 0;
  } else {
    i_top++;
  }

  stack[i_top] = val;
}
```
1. 當空間不足，時候擴展空間
2. 當尺寸為0時候，指標即為0，( 建構Stack時候
   反之 指標增加
3. 儲存該值

---

## Pop
```java
public Integer pop() {
  if (size() == 0) {
    return null;
  }

  Integer val = stack[i_top];
  stack[i_top] = null;

  if (size() == 1) {
    i_top = null;
  } else {
    i_top--;
  }

  return val;
}
```

1. 如果沒有空間，回傳Null
2. **儲存指標所在的值**，並將該位置賦值null
3. 如果size為1 則讓指標等於null
   反之則單純把指標位置-1