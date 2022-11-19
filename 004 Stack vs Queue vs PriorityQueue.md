
#### 實作方式

1. 基於Array都比較複雜
2. 基於Linked List都比較簡單


#### 基於Array

1. 需要注意擴展空間
2. 需要注意Read Pointer以及Write Pointer會是index
3. 需要自己寫資料結構的Size提供給內部方法判斷是否需要擴展空間和越界
4. Stack可以直接搬移到新的空間，
   Queue則不行要先Poll在儲存到新的空間
   並Reset Read Pointer 和 Write Pointer


#### 基於Linked List

1. 沒有甚麼需要注意的，記得要串接起來就對了


#### 共同點

1. 先計算Write Pointer 再儲存
2. 先紀錄值 再計算Read Pointer


#### Queue

1. 需要注意一開始的 Write Pointer 以及 Read Pointer 會重疊
   所以基於Array實作時候計算size結果要+1
2. 避免浪費空間基於Array實作時候Queue會形成環狀
   所以 Read Pointer 和 Write Pointer 計算時候都會需要 mod Array的長度


| 英文          | Stack    | Queue    | PriorityQueue |
| ------------- | -------- | -------- | ------------- |
| 中文          | 堆疊     | 佇列     | 優先權佇列    |
| 概念          | 先進後出 | 先進先出 | Heap          |
| 寫入          | push     | offer    | add           |
| 讀取          | pop      | poll     | poll          |
| 寫入 Big-O    | O(1)     | O(1)     | O(log(n))     |
| 讀取 Big-O    | O(1)     | O(1)     | O(log(n))     |
| 基於Array擴展 | O(n)     | O(n)     | O(n)          |
