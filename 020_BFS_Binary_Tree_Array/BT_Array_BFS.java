import java.util.LinkedList;
import java.util.Queue;

public class BT_Array_BFS {
  private Integer[] nums;

  public BT_Array_BFS(Integer[] nums) {
    this.nums = nums;
  }

  public void traverse_levelorder_bfs() {
    if (this.nums.length < 0)
      return;

    Queue<Integer> q = new LinkedList<>();

    int i_root = 0;
    q.add(i_root);

    while (true) {
      if (q.size() == 0)
        break;

      Integer i = q.poll();
      if (i >= this.nums.length || this.nums[i] == null)
        continue;

      System.out.print(this.nums[i] + " ");

      q.add((i + 1) * 2 - 1); // left
      q.add((i + 1) * 2); // right
    }
  }

  public static void main(String[] args) {
    Integer[] nums = {
        5, 2, 6, 1, 4, null, 7, null, null, 3, null, null, null, null, null
    };
    /*---------5
     *----2---------6
     *--1---4-----n---7
     *-n-n-3-n---n-n-n-n
     */
    BT_Array_BFS bt = new BT_Array_BFS(nums);
    System.out.println();
    System.out.print("level-order: ");
    bt.traverse_levelorder_bfs();
  }
}
