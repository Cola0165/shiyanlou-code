

import java.util.ArrayList;
import java.util.List;

public class Permutations {
    private List<String> results = new ArrayList<>();

    public List<String> permutation(String str) {
        StringBuffer sb = new StringBuffer();
        // 访问标识
        boolean[] visited = new boolean[str.length()];
        // 调用方法回溯
        backTrack(str, sb, visited);
        return results;
    }

    public void backTrack(String str, StringBuffer stringBuffer, boolean[] visited) {
        if (stringBuffer.length() == str.length()) {
            results.add(stringBuffer.toString());
        }
        for (int i = 0; i < str.length(); i++) {
            if (!visited[i]) {
                // 选择当前的字符，置为已经访问
                visited[i] = true;
                stringBuffer.append(str.charAt(i));
                // 继续递归下一个
                backTrack(str, stringBuffer, visited);
                // 回溯，退回上一步
                stringBuffer.deleteCharAt(stringBuffer.length() - 1);
                visited[i] = false;
            }
        }
    }

    public static void main(String[] args) {
        Permutations permutations = new Permutations();
        List<String> results = permutations.permutation("abc");
        results.forEach(r -> System.out.println(r));

    }
}
