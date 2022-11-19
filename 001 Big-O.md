## Big-O

| O(1)       | O(log n) | O(n)     | O(nlogn)   | n^2         | 2^n          | n!           |
| ---------- | -------- | -------- | ---------- | ----------- | ------------ | ------------ |
| 一步到位   | 階層數   | 線性     | 線性+階層  | 線性+線性   | 定數細胞分裂 | 高速細胞分裂 |
|            |          |          | 超級分支   |             |              |
|            |          |          | 底數漸大   | 底數小      | 底數大=>小   |
|            |          |          | 階層小     | 底數漸大    | 階層一樣漸大 |
| index 搜尋 | 二元搜尋 | 陣列遍歷 | Merge Sort | Bubble Sort | 費氏數列     | 排列組合     |

---

## Array

| 動作              | 解釋                         | big-O | 備註                      |
| ----------------- | ---------------------------- | ----- | ------------------------- |
| Search (by value) | 一個一個查                   | O(n)  |                           |
| Search (by index) | 直接算出記憶體位置           | O(1)  |                           |
| Insert (by value) | 直接放最後面，低機率需要擴展 | O(1)  |                           |
| Insert (by index) | 可能需要擴展或是推動         |       | 推動即O(n)                |
| Insert (expand)   | 擴展動作稱為expand           | +O(n) |                           |
| Delete (by value) | 先搜尋再推移                 | O(n)  | 比by index更慢 但還是O(n) |
| Delete (by index) | 直接刪除再推移               | O(n)  |                           |


## Linked List

| 動作              | 解釋                                       | big-O | 備註 |
| ----------------- | ------------------------------------------ | ----- | ---- |
| Search (by value) | 訪問next指標直到查到                       | O(n)  |      |
| Insert (by value) | 最後一個Node的next指過去                   | O(1)  |      |
| Delete (by value) | 先搜尋到self再把prevNode的Next指向nextNode | O(n)  |      |


#### Array
1. 適合搜尋
2. 不適合插入

#### Linked List
1. 不適合搜尋
2. 適合需要大量插入

#### 共同點
1. 不適合刪除


**用位置搜尋多使用Array，新增或插入多則用LinkedList**
