```java
Integer[][] maze; // 成本查找表
PriorityQueue<Node> pq; // 探索節點 根據成本排序
Integer[][] maze_bset; // 未探索節點 (null) + 已確認節點
Integer[][] direction = {
    { -1, 0 },
    { 1, 0 },
    { 0, -1 },
    { 0, 1 }
}; // 尋找方向
```

---

## 走迷宮

```java
public int go_maze(int row_start, int col_start, int row_target, int col_target) {
  Node start = new Node(row_start, col_start);
  start.cost = this.maze[row_start][col_start];
  Node target = new Node(row_target, col_target);

  return go_maze(start, target);
}
```

1. 起點沒有成本，可以直接是自己

---

## 走迷宮 (Overload)

```java
public int go_maze(Node start, Node target) {
  // initialization
  pq.add(start);

  while (true) {

    if (pq.size() == 0) {
      break;
    }
    /** pick the node with lowest cost **/
    Node now = pq.poll();

    // 因為pq保證成本最小的優先，所以如果maze_bset[][]有值則不用繼續產生
    if (maze_bset[now.row][now.col] != null) {
      continue;
    }

    // confirm its min cost
    maze_bset[now.row][now.col] = now.cost;

    /** explore next node **/
    for (Integer[] i : direction) {
      if (now.row + i[0] < 0 ||
          now.row + i[0] >= maze.length ||
          now.col + i[1] < 0 ||
          now.col + i[1] >= maze.length) {
        Node el = new Node(now.row - 1, now.col);
        el.cost = now.cost + maze[now.row][now.col];
        pq.add(el);
      }
    }

  }

  return this.maze_bset[target.row][target.col];
}
```

1. 初始化走迷宮先將pq帶入起點Node
2. 開始迴圈
3. 開始poll pq裡面最低成本Node
4. 如果已經有當前位置的最小值這圈跳過
5. 將 最低成本Node的位置 賦予 取得的最低成本Node
6. 增加往四個方向走的成本結點進pq
7. 迴圈結束 回傳 目標位置的最短路徑

---

## 貪婪規則
1. 從A點開始向外擴散，且最低成本路徑優先
2. 只考慮當前節點跟下一個節點的最短路徑，即局部最短路徑，而不考慮整體最短路徑

不適合放在有負數成本的路徑上