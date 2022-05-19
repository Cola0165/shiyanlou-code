package com.string;

class Node {
    int count;
    // 对应 26 个小写字母
    Node[] next = new Node[26];

    // 计数器初始化为0
    Node() {
        for (int i = 0; i < 26; i++) {
            next[i] = null;
            count = 0;
        }
    }
}

public class Tries {
    public static String[] findMinimumPrefix(String[] strs) {
        //  构建前缀树
        Node root = buildTree(strs);
        String[] results = new String[strs.length];
        for (int i = 0; i < strs.length; i++) {
            Node p = root;
            int j = 0;
            for (; j < strs[i].length(); j++) {
                if (p.next[strs[i].charAt(j) - 'a'].count == 0) {
                    // 下一个为0 说明当前是能识别的最短的前缀了
                    results[i] = strs[i].substring(0, j + 1);
                    break;
                }
                p = p.next[strs[i].charAt(j) - 'a'];
            }
            // 整个字符串才是唯一可区分的
            if (j == strs[i].length()) {
                results[i] = strs[i];
            }
        }
        return results;
    }

    private static Node buildTree(String[] strs) {
        Node root = new Node();
        for (int i = 0; i < strs.length; i++) {
            Node p = root;
            String tmp = strs[i];
            for (int j = 0; j < tmp.length(); j++) {
                // 不是新节点
                if (p.next[tmp.charAt(j) - 'a'] != null) {
                    // 计数器加1
                    p.next[tmp.charAt(j) - 'a'].count++;
                } else {
                    // 新节点
                    p.next[tmp.charAt(j) - 'a'] = new Node();
                }
                // 继续到下一个节点
                p = p.next[tmp.charAt(j) - 'a'];
            }
        }
        return root;
    }

    public static void main(String[] args) {
        String[] strs = {"meituanapp",
                "meituanwaimai",
                "dianpingliren",
                "dianpingjiehun",
                "mt"};
        String[] results = Tries.findMinimumPrefix(strs);
        for (int i = 0; i < results.length; i++) {
            System.out.println(results[i]);
        }
    }
}