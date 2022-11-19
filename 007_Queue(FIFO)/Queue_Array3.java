public class Queue_Array3 {
  Integer[] ary;
  Integer[] queue;
  Integer i_front = null;
  Integer i_end = null;

  public Queue_Array3(Integer[] ary) {
    this.ary = ary;
  }

  public void build_queue() {
    queue = new Integer[ary.length];
    for (int i = 0; i < ary.length; i++) {
      offer(ary[i]);
    }
  }

  public void offer(Integer val) {
    if (size() == queue.length) {
      expand_space();
    }

    if (size() == 0) {
      i_front = 0;
      i_end = 0;
    } else {
      i_end = (i_end + 1) % queue.length;
    }

    queue[i_end] = val;
  }

  public Integer poll() {
    if (size() == 0) {
      return null;
    }

    Integer val = queue[i_front];
    queue[i_front] = null;

    if (size() == 1) {
      i_front = null;
      i_end = null;
    } else {
      i_front = (i_front + 1) % queue.length;
    }

    return val;
  }

  private void expand_space() {
    Integer[] queue_new = new Integer[queue.length * 2];

    int i = 0;
    while (true) {
      if (size() == 0) {
        break;
      }

      Integer val = poll();
      queue_new[i] = val;
      i++;
    }

    i_front = 0;
    i_end = i - 1;

    queue = queue_new;
  }

  private int size() {
    if (i_front == null && i_end == null) {
      return 0;
    }
    return (i_end - i_front + queue.length) % queue.length + 1;
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
