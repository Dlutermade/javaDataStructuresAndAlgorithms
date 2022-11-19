import java.util.ArrayList;
import java.util.List;

public class Travelplan_enum {
  Integer[][] hours;
  String[] c_remained = { "NP", "IS", "CA", "UK", "US" };

  private void build_hour_table() {
    // NP: 0 (North Pole)
    // IS: 1
    // CA: 2
    // UK: 3
    // US: 4

    this.hours = new Integer[5][5];

    hours[0][0] = 0; // NP -> NP
    hours[0][1] = 14; // NP -> IS
    hours[0][2] = 15; // NP -> CA
    hours[0][3] = 17; // NP -> UK
    hours[0][4] = 16; // NP -> US

    hours[1][0] = 14; // IS -> NP
    hours[1][1] = 0; // IS -> IS
    hours[1][2] = 24; // IS -> CA
    hours[1][3] = 8; // IS -> UK
    hours[1][4] = 36; // IS -> US

    hours[2][0] = 15; // CA -> NP
    hours[2][1] = 24; // CA -> IS
    hours[2][2] = 0; // CA -> CA
    hours[2][3] = 34; // CA -> UK
    hours[2][4] = 4; // CA -> US

    hours[3][0] = 17; // UK -> NP
    hours[3][1] = 8; // UK -> IS
    hours[3][2] = 34; // UK -> CA
    hours[3][3] = 0; // UK -> UK
    hours[3][4] = 30; // UK -> US

    hours[4][0] = 16; // US -> NP
    hours[4][1] = 36; // US -> IS
    hours[4][2] = 4; // US -> CA
    hours[4][3] = 30; // US -> UK
    hours[4][4] = 0; // US -> US
  }

  public Integer get_hour(String start, String end) {
    Integer x = get_index(start);
    Integer y = get_index(end);
    return this.hours[x][y];
  }

  private Integer get_index(String str) {
    if (str.equals("NP"))
      return 0;
    if (str.equals("IS"))
      return 1;
    if (str.equals("CA"))
      return 2;
    if (str.equals("UK"))
      return 3;
    if (str.equals("US"))
      return 4;
    return null;
  }

  // enumeration
  List<String> route = new ArrayList<>();

  public void enumeration(Integer constraint_hour) {
    String c_start = "NP";
    route.add(c_start);
    c_remained[0] = null;

    enumeration_recursion(constraint_hour);
  }

  private void enumeration_recursion(Integer constraint_hour) {
    if (route.size() == 5) {
      int hour_total = get_hour_total();
      if (hour_total < constraint_hour) {
        print_result(hour_total);
      } else {
        System.out.print("[X]: ");
        print_result(hour_total);
      }
      return;
    }

    /** step01: just pick any child to continue each round **/
    for (int i = 0; i < c_remained.length; i++) {
      if (c_remained[i] == null)
        continue;

      String c_next = c_remained[i];

      route.add(c_next);
      c_remained[i] = null;

      enumeration_recursion(constraint_hour);

      route.remove(c_next);
      c_remained[i] = c_next;
    }
  }

  private int get_hour_total() {
    if (route.size() == 0)
      return 0;
    int hour_total = 0;
    String c_start = route.get(0);
    String c_end = null;
    for (int i = 1; i < route.size(); i++) {
      c_end = route.get(i);
      hour_total += get_hour(c_start, c_end);

      c_start = c_end;
    }

    return hour_total;
  }

  private void print_result(int hour_total) {
    for (int i = 0; i < route.size(); i++) {
      System.out.print(route.get(i));
      if (i != route.size() - 1) {
        System.out.print("->");
      }
    }

    System.out.println(" : " + hour_total);
  }

  public static void main(String[] args) {
    Travelplan_enum tp = new Travelplan_enum();
    tp.build_hour_table();
    Integer hour_constraint = 60; // 65 ~ 100
    tp.enumeration(hour_constraint);
  }
}