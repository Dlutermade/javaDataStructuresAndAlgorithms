public class Stack_Array2 {
  Integer[] ary;
  Integer[] stack;
  Integer i_top = null; // LIFO

  public Stack_Array2(Integer[] ary) {
    this.ary = ary;
  }

  public void build_stack() {
    stack = new Integer[ary.length];
    for (int i = 0; i < ary.length; i++) {
      push(ary[i]);
    }
  }

  private int size() {
    if (i_top == null) {
      return 0;
    }
    return i_top + 1;
  }

  public void push(Integer val) {
    if (size() == stack.length) {
      expand_space();
    }

    if (size() == 0) {
      i_top = 0;
    } else {
      i_top++;
    }

    stack[i_top] = val;
  }

  public Integer pop() {
    if (size() == 0) {
      return null;
    }

    Integer val = stack[i_top];
    stack[i_top] = null;

    if (size() == 1) {
      i_top = null;
    } else {
      i_top--;
    }

    return val;
  }

  private void expand_space() {
    Integer[] stack_new = new Integer[stack.length * 2];
    for (int i = 0; i < stack.length; i++) {
      stack_new[i] = stack[i];
    }

    stack = stack_new;
  }

  public static void main(String[] args) {
    Integer[] nums = { 1, 2, 3, 4, 5 };
    Stack_Array2 stack_array = new Stack_Array2(nums);
    stack_array.build_stack();

    // full - extend the storage size
    stack_array.push(6);

    Integer num = stack_array.pop();
    num = stack_array.pop();
    num = stack_array.pop();
    num = stack_array.pop();
    num = stack_array.pop();
    num = stack_array.pop();

    // empty
    num = stack_array.pop();

    System.out.println(num);
  }
}
