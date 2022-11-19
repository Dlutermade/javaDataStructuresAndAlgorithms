public class List_Impl3 {

  static class Node {
    Integer val;
    Node next;

    public Node(int val) {
      this.val = val;
    }
  }

  private Node start;
  private Node end;

  public List_Impl3() {
  }

  public void add(int val) {
    if (start == null) {
      start = new Node(val);
      end = start;
    } else {
      end.next = new Node(val);
      end = end.next;
    }
  }

  public Integer search(int val) {
    if (start == null)
      return null;

    Node node = start;
    while (true) {
      if (node == null)
        break;

      if (node.val == val) {
        return node.val;
      }

      node = node.next;
    }

    return null;
  }

  public void remove(int val) {
    /** step01: search **/
    Node node = start;
    Node node_target = null;
    Node node_prev = null;

    while (true) {
      if (node == null)
        break;

      if (node.val == val) {
        node_target = node;
        break;
      }

      node_prev = node;
      node = node.next;
    }

    /** step02:delete **/
    if (node_target == null)
      return;

    if (node_target == start) {
      start = start.next;
    } else if (node_target == end) {
      node_prev.next = null;
      end = node_prev;
    } else {
      node_prev.next = node_target.next;
    }
  }

  public static void main(String[] args) {
    /** initialize **/
    List_Impl3 mylist = new List_Impl3();

    /** add O(1) - start **/
    mylist.add(9);

    /** add O(1) **/
    mylist.add(11);
    mylist.add(2);
    mylist.add(98);
    mylist.add(35);

    /** search O(n) **/
    int val = mylist.search(98);

    /** remove O(n) **/
    mylist.remove(2);
    mylist.remove(9); // remove start
    mylist.remove(35); // remove end

  }

}
