public class Stack_List2 {
  static class Node {
    Integer val;
    Node next;

    public Node(Integer val) {
      this.val = val;
    }
  }

  Integer[] ary;
  Node node_top;

  public Stack_List2(Integer[] ary) {
    this.ary = ary;
  }

  public void build_stack() {
    for (int i = 0; i < ary.length; i++) {
      push(ary[i]);
    }
  }

  public void push(Integer val) {
    if (node_top == null) {
      node_top = new Node(val);
    } else {
      Node node_new = new Node(val);
      node_new.next = node_top;
      node_top = node_new;
    }
  }

  public Integer pop() {
    if (node_top == null) {
      return null;
    }

    Node node = node_top;
    node_top = node_top.next;

    return node.val;
  }
}
