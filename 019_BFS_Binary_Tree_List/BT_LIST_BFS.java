import java.util.LinkedList;
import java.util.Queue;

public class BT_List_BFS {
  class Node {
    Node left;
    Node right;
    int val;

    Node() {
    }

    Node(int val) {
      this.val = val;
    }

  }

  private Integer[] nums;
  private Node root;

  BT_List_BFS(Integer[] nums) {
    this.nums = nums;
  }

  public void buildTree() {
    if (this.nums.length < 0)
      return;
    if (this.nums[0] == null)
      return;

    // prepare Node instances
    Node[] nodes_tmp = new Node[this.nums.length];
    for (int i = 0; i < this.nums.length; i++) {
      if (this.nums[i] == null)
        continue;

      nodes_tmp[i] = new Node(this.nums[i]);
    }

    this.root = nodes_tmp[0];

    for (int i = 0; i < this.nums.length; i++) {
      int i_left = (i + 1) * 2 - 1;
      int i_right = (i + 1) * 2;

      Node node = nodes_tmp[i];

      if (node == null)
        continue;

      if (i_left < this.nums.length) {
        node.left = nodes_tmp[i_left];
      }

      if (i_right < this.nums.length) {
        node.right = nodes_tmp[i_right];
      }
    }
  }

  public void traverse_levelorder_bfs() {
    if (this.root == null)
      return;

    Queue<Node> q = new LinkedList<>();

    // initialization
    q.add(this.root);

    while (true) {
      if (q.size() == 0)
        break;

      Node node = q.poll();
      if (node == null)
        continue;

      System.out.print(node.val + " ");
      q.add(node.left);
      q.add(node.right);
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
    BT_List_BFS bt = new BT_List_BFS(nums);
    bt.buildTree();
    System.out.println();
    System.out.print("level-order: ");
    bt.traverse_levelorder_bfs();
  }
}
