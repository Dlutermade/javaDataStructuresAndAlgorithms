## 柱子
```java
static Stack<Integer> pillar_A = new Stack<>();
static Stack<Integer> pillar_B = new Stack<>();
static Stack<Integer> pillar_C = new Stack<>();
```

1. A柱
2. B柱
3. C柱

---

## 添加盤子到柱子
```java
pillar_A.add(5);
pillar_A.add(4);
pillar_A.add(3);
pillar_A.add(2);
pillar_A.add(1);
```

因為是Stack，所以1在上面5在下面
備註: 先進後出


## 河內塔分治法遞迴
```java
private static void hanoi(int layer, Stack<Integer> pillar_from, Stack<Integer> pillar_mid, Stack<Integer> pillar_to) {
  if (layer == 0)
    return;

  // base case : when layer == 1, it's our base case;

  /**
   * step01: move the above plate to the pillar_mid,
   * to clear the room for the plate below
   **/
  hanoi(layer - 1, pillar_from, pillar_to, pillar_mid);

  // step02: main target
  Integer plate = pillar_from.pop();
  pillar_to.push(plate);

  // step03: move the original above plate back
  hanoi(layer - 1, pillar_mid, pillar_from, pillar_to);

}
```

1. 將上面的盤子 起點to中繼站，經過 終點
2. 將下面的盤子 起點to終點
3. 將上面的盤子 中繼站to終點，經過 起點