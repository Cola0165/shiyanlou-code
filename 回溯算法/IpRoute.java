import java.util.ArrayList;
import java.util.List;

public class IpRoute {
    List<String> res = new ArrayList<>();
    List<String> path = new ArrayList<>();

    public List<String> restoreIpAddresses(String s) {
        // 保证每个片段的长度至少为1，最多为3
        if (s == null || s.length() < 4 || s.length() > 12) {
            return res;
        }
        // 从索引 0 开始选择
        backTrace(s, 0);
        return res;
    }

    public void backTrace(String s, int startIndex) {
        // 分割
        if (path.size() == 4) {
            res.add(String.join(".", path));
            return;
        }

        for (int i = startIndex; i < s.length() && i < startIndex + 3; i++) {
            if ((s.length() - 1 - i) > 3 * (3 - path.size())) continue;
            if (isValid(s.substring(startIndex, i + 1))) {
                path.add(s.substring(startIndex, i + 1));
                backTrace(s, i + 1);
                path.remove(path.size() - 1);
            }
        }
    }

    public boolean isValid(String s) {
        if (s.charAt(0) == '0' && s.length() > 1) {
            return false;
        }
        if (s.length() > 3) {
            return false;
        }
        if (Integer.parseInt(s) > 255) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        IpRoute ipRoute = new IpRoute();
        String ip = "23454212";
        List<String> res = ipRoute.restoreIpAddresses(ip);
        System.out.println(ip + " 可能存在的ip：" + res);
    }
}