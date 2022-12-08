public class Queue_Array4 {
  int[] ary;
  int[] queue;
  int front = 0;
  int back = 0;

  public Queue_Array4(int[] ary) {
    this.ary = ary;
  }

  public void build_queue() {
    queue = new int[ary.length * 2];

    for (int i = 1; i <= ary.length; i++) {
      queue[i] = ary[i];
    }

    back = ary.length - 1;
  }

  public void push(int x) {
    if (size() + 1 == queue.length) {
      expand_space();
    }

    back = (back + 1) % queue.length;

    queue[back] = x;
  }

  public int pop() {
    if (size() == 0) {
      return 0;
    }

    front = (front + 1) % queue.length;
    int i = queue[front];

    return i;
  }

  private void expand_space() {
    int[] newQueue = new int[queue.length * 2];

    int j = front, size = size();
    for (int i = 1; i <= size; i++) {
      newQueue[i] = queue[++j % queue.length];
    }

    front = 0;
    back = size;

    queue = newQueue;
  }

  private int size() {
    return (back - front + queue.length) % queue.length;
  }

  public static void main(String[] args) {
    Integer[] nums = new Integer[] { 1, 2, 3, 4, 5 };
    Queue_Array3 queue_array = new Queue_Array3(nums);
    queue_array.build_queue();

    // full - extend the storage size
    queue_array.offer(6);

    Integer val = queue_array.poll();
    val = queue_array.poll();
    val = queue_array.poll();
    val = queue_array.poll();
    val = queue_array.poll();
    val = queue_array.poll();

    // empty
    val = queue_array.poll();

    // circular queue - i_end test
    queue_array.offer(11);
    queue_array.offer(12);
    queue_array.offer(13);
    queue_array.offer(14);
    queue_array.offer(15);
    val = queue_array.poll();
    val = queue_array.poll();
    val = queue_array.poll();
    val = queue_array.poll();

    for (int i = 0; i < 80; i++) {
      queue_array.offer(30 + i);
    }

    System.out.println();
  }

}
