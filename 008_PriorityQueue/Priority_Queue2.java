import java.util.Comparator;
import java.util.PriorityQueue;

public class Priority_Queue2 {

  static class Person {

    Integer age;
    Integer peepee_wait_time;

    public Person(Integer age, Integer peepee_wait_time) {
      this.age = age;
      this.peepee_wait_time = peepee_wait_time;
    }
  }

  static class MyComp implements Comparator<Person> {

    @Override
    public int compare(Person p1, Person p2) {
      // p1.peepee_wait_time.compareTo(p2.peepee_wait_time)
      return p1.peepee_wait_time - p2.peepee_wait_time;
    }
  }

  public static void main(String[] args) {
    Integer[] nums = { 4, 3, 1, 5, 2 };
    PriorityQueue<Integer> pq = new PriorityQueue<>();

    for (Integer i : nums) {
      pq.add(i);
    }

    while (true) {
      if (pq.size() == 0) {
        break;
      }

      Integer num = pq.poll();
      System.out.print(num + " ");
    }

    // custom
    Person[] ppl = {
      new Person(19, 60),
      new Person(28, 45),
      new Person(48, 32),
      new Person(60, 19),
      new Person(33, 200),
    };

    PriorityQueue<Person> pq_ppl = new PriorityQueue<>(ppl.length, new MyComp());
    for (Person i : ppl) {
      pq_ppl.add(i);
    }

    while (true) {
      if (pq_ppl.size() == 0) {
        break;
      }

      Person p = pq_ppl.poll();
      System.out.print(p.peepee_wait_time + " ");
    }

    System.out.println();
  }
}
