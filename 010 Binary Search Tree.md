## BST 二元搜尋樹

1. 是一種 Binary Tree
2. 節點 不能重複
3. 左小 右大
   Left Tree < Root Node < Right Tree


---

#### Search

1. 找比 Current Node 大，往右邊走，反之往右邊
2. 找不到回傳Null

---

#### Insert

1. 先Search，如果適合插入的位置是Null，直接插入

---

#### Delete

1. 要刪除的Node，Sub Node都是Null，把 Previous Node 直接刪除 (直接砍樹)
2. 要刪除的Node，Left Node != null，
   2. 上一個Node的 某一邊 Sub Node 
   3. 直接是 Current Node 的 Left Node
3. 要刪除的Node，Right Node != null，
   1. 上一個Node的 某一邊 Sub Node 
   2. 直接是 Current Node 的 Right Node
4. 要刪除的Node，ALL Sub Node != Null
   1. Right Tree 上移
      1. 先找出 Right Tree 最小值
      2. 與其交換
      3. 在 Right Tree 中刪除該Node 
   2. Left Tree 上移
      1. 先找出 Left Tree 最大值
      2. 與其交換
      3. 在 Left Tree 中刪除該Node 

某一邊 Sub Node是指 Current Node 跟 Previous Node 關係

---

| Name        | Search | Insert | Delete |
| ----------- | ------ | ------ | ------ |
| Best Big-O  | log(n) | log(n) | log(n) |
| worst Big-O | n      | n      | n      |

> Array 實作 Delete 難度很高

---

#### Vaildate BST

1. Root > Left Tree Max
   Get Max 
2. Root < Right Tree Min
   Get Min 

需要 traverse each Sub Tree 