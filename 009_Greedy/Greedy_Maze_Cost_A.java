import java.util.Comparator;
import java.util.PriorityQueue;

public class Greedy_Maze_Cost_A {
  Integer[][] maze; // cost lookup table
  PriorityQueue<Node> pq; // explored nodes (sort by cost)
  Integer[][] maze_bset; // unexplored nodes (null) + confirmed nodes

  static class Node {
    Integer row;
    Integer col;
    Integer cost;

    public Node(Integer row, Integer col) {
      this.row = row;
      this.col = col;
    }

  }

  static class MyComp implements Comparator<Node> {
    @Override
    public int compare(Node node1, Node node2) {
      return node1.cost - node2.cost;
    }
  }

  public Greedy_Maze_Cost_A(Integer[][] maze) {
    this.maze = maze;
    this.pq = new PriorityQueue<>(20, new MyComp());
    this.maze_bset = new Integer[this.maze.length][this.maze[0].length];
  }

  public int go_maze(int row_start, int col_start, int row_target, int col_target) {
    Node start = new Node(row_start, col_start);
    start.cost = this.maze[row_start][col_start];
    Node target = new Node(row_target, col_target);

    return go_maze(start, target);
  }

  public int go_maze(Node start, Node target) {
    // initialization
    pq.add(start);

    while (true) {

      if (pq.size() == 0) {
        break;
      }
      /** pick the node with lowest cost **/
      Node now = pq.poll();

      // 因為pq保證成本最小的優先，所以可以確定裡面的成本都會是最小的
      if (this.maze_bset[now.row][now.col] != null) {
        continue;
      }

      // confirm its min cost
      this.maze_bset[now.row][now.col] = now.cost;

      /** explore next node **/
      if (now.row - 1 >= 0) {
        Node up = new Node(now.row - 1, now.col);
        up.cost = now.cost + this.maze[now.row][now.col];
        pq.add(up);
      }
      if (now.row + 1 < maze.length) {
        Node down = new Node(now.row + 1, now.col);
        down.cost = now.cost + this.maze[now.row][now.col];
        pq.add(down);
      }
      if (now.col - 1 >= 0) {
        Node left = new Node(now.row, now.col - 1);
        left.cost = now.cost + this.maze[now.row][now.col];
        pq.add(left);
      }
      if (now.col + 1 >= maze[0].length) {
        Node right = new Node(now.row, now.col + 1);
        right.cost = now.cost + this.maze[now.row][now.col];
        pq.add(right);
      }
    }

    return this.maze_bset[target.row][target.col];
  }

  public static void main(String[] args) {
    Integer[][] maze = {
        { 1, 3, 1, 2, 9 },
        { 7, 3, 4, 9, 9 },
        { 1, 7, 5, 5, 3 },
        { 2, 3, 4, 2, 5 }
    };

    Greedy_Maze_Cost_A gmc = new Greedy_Maze_Cost_A(maze);

    int row_start = 0;
    int col_start = 0;
    int row_target = 3;
    int col_target = 4;

    int cost_min = gmc.go_maze(row_start, col_start, row_target, col_target);

    System.out.println(cost_min);
  }
}