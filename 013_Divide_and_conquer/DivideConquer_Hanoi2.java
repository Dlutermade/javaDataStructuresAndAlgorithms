import java.util.Stack;

public class DivideConquer_Hanoi2 {
  static Stack<Integer> pillar_A = new Stack<>();
  static Stack<Integer> pillar_B = new Stack<>();
  static Stack<Integer> pillar_C = new Stack<>();

  public static void main(String[] args) {
    // initialization

    pillar_A.add(5);
    pillar_A.add(4);
    pillar_A.add(3);
    pillar_A.add(2);
    pillar_A.add(1);

    int layer = pillar_A.size();

    // divide & Conquer
    hanoi(layer, pillar_A, pillar_B, pillar_C);
  }

  private static void hanoi(int layer, Stack<Integer> pillar_from, Stack<Integer> pillar_mid,
      Stack<Integer> pillar_to) {
    if (layer == 0)
      return;

    // base case : when layer == 1, it's our base case;

    /**
     * step01: move the above plate to the pillar_mid,
     * to clear the room for the plate below
     **/
    hanoi(layer - 1, pillar_from, pillar_to, pillar_mid);

    // step02: main target
    Integer plate = pillar_from.pop();
    pillar_to.push(plate);

    // step03: move the original above plate back
    hanoi(layer - 1, pillar_mid, pillar_from, pillar_to);

  }

}
