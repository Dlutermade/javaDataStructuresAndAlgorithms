import java.util.Comparator;
import java.util.PriorityQueue;

public class Greedy_Maze_Cost_B {
  Integer[][] maze; // cost lookup table
  PriorityQueue<Node> pq; // explored nodes (sort by cost)
  Integer[][] maze_bset; // unexplored nodes (null) + confirmed nodes
  Integer[][] direction = {
      { -1, 0 },
      { 1, 0 },
      { 0, -1 },
      { 0, 1 }
  };

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

  public Greedy_Maze_Cost_B(Integer[][] maze) {
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
          Node el = new Node(now.row + i[0], now.col + i[1]);
          el.cost = now.cost + maze[now.row][now.col];
          pq.add(el);
        }
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
