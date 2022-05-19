import java.util.Arrays;

public class MinNumberTest {

  public static void main(String args[]) {
    String result = minNumber(new int[] { 3, 32, 321 });
    System.out.print(result);
  }

  public static String minNumber(int[] numbers) {
    String[] strs = new String[numbers.length];
    for (int i = 0; i < numbers.length; i++) strs[i] =
      String.valueOf(numbers[i]);
    Arrays.sort(strs, (x, y) -> (x + y).compareTo(y + x));
    StringBuilder res = new StringBuilder();
    for (String s : strs) res.append(s);
    return res.toString();
  }
}