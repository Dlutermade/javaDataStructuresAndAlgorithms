## 過程

#### 規則

1. A、B、C三個柱子
2. 整個 A to C
3. 上面的盤子不能比下面盤子還要大

---

## base case

1. 只有一個盤子
2. A to C

---

## sub-problem

1. 兩個盤子
2. 上面 A to B
3. 下面 A to C
4. 上面 B to C

---

## bigger-problem

1. 四個盤子
2. 上面三個視為一體
3. 下面一個視為單體
4. 上面 A to B
5. 下面 A to C
6. 上面 B to C


## bigger-problem 上面盤子拆解-1

1. 三個盤子
2. 改為 A to B
3. 上面兩個視為一體
4. 下面一個視為單體
5. 上面 A to C
6. 下面 A to B
7. 上面 C to B

## bigger-problem 上面盤子拆解-2

1. 兩個盤子
2. 改為 A to C
3. 上面一個視為單體
4. 下面一個視為單體
5. 上面 A to B
6. 下面 A to C
7. 上面 B to C

## bigger-problem 上面盤子拆解-3-1

1. 一個盤子 上面的
2. A to B
3. 等待下面盤子拆解
4. B to C

## bigger-problem 下面盤子拆解-3-2

1. 一個盤子 下面的
2. A to C