## 快速排序

Quick Sort

---

## 實作方式兩種

| 版本     | Hoare                          | Lomuto                                       |
| -------- | ------------------------------ | -------------------------------------------- |
| Partiton | 先尋找再交換                   | 不斷交換                                     |
| 機制     | 左右指標尋找不合理元素進行交換 | 兩個同方向指標遇到不合理元素再下一圈錯位交換 |
| 保障機制 | 切成兩個區塊                   | 切成兩個區塊                                 |
| Divide   | pivot不排序                    | pivot不排序                                  |