public class Queue_List2 {
  static class Node {
    Integer val;
    Node next;

    public Node(Integer val) {
      this.val = val;
    }

    Integer[] nums;
    Node node_front = null;
    Node node_end = null;

    public void Queue_List2(Integer[] nums) {
      this.nums = nums;
    }

    public void build_queue() {
      for (int i = 0; i < nums.length; i++) {
        offer(nums[i]);
      }
    }

    public void offer(Integer val) {
      if (node_front == null) {
        node_front = new Node(val);
        node_end = node_front;
      } else {
        Node node_new = new Node(val);
        node_end.next = node_new;
        node_end = node_new;
      }
    }

    public Integer poll() {
      if (node_front == null) {
        return null;
      }

      Node node = node_front;
      node_front = node_front.next;

      if (node_front == null) {
        node_end = null;
      }

      return node.val;
    }

  }
}
