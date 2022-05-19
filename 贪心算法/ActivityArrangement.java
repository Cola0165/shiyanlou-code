import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ActivityArrangement {

  public static void main(String[] args) {
    List<Activity> list = new ArrayList<Activity>();
    list.add(new Activity(3, 5));
    list.add(new Activity(1, 4));
    list.add(new Activity(5, 7));
    list.add(new Activity(0, 6));
    list.add(new Activity(6, 10));
    list.add(new Activity(3, 8));
    list.add(new Activity(5, 9));
    list.add(new Activity(8, 12));
    list.add(new Activity(8, 11));
    list.add(new Activity(2, 13));
    list.add(new Activity(12, 14));
    boolean[] r = greedySelectActivity(list);
    System.out.print("被安排上的活动为：");
    for (int i = 0; i < list.size(); i++) {
      if (r[i] == true) System.out.print(
        "[" + list.get(i).start + ", " + list.get(i).end + "] "
      );
    }
    System.out.println();
  }

  public static boolean[] greedySelectActivity(List<Activity> list) {
    // 按照结束时间排序
    Collections.sort(
      list,
      new Comparator<Activity>() {

        @Override
        public int compare(Activity o1, Activity o2) {
          return o1.end - o2.end;
        }
      }
    );
    int n = list.size();
    boolean[] results = new boolean[n];
    results[0] = true;
    int j = 0;
    for (int i = 1; i < n; i++) {
      if (list.get(i).start >= list.get(j).end) {
        // 被选中
        results[i] = true;
        j = i;
      } else {
        results[i] = false;
      }
    }
    return results;
  }
}

class Activity {
  public int start;
  public int end;

  public Activity(int start, int end) {
    this.start = start;
    this.end = end;
  }
}