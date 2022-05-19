import java.util.*;

public class Huffman {

  public static void main(String[] args) {
    String str = "Hello";
    System.out.println("原字符串：" + str);
    // 出现频率统计
    Map<Character, Integer> frequenceMap = getFrequency(str.toCharArray());
    printFrequency(frequenceMap);
    // 编码二进制字符串
    String binary = encode(str, frequenceMap);
    // 解码
    String decode = decode(binary, frequenceMap);
    System.out.println("编码后二进制：" + binary);
    System.out.println("解压字符串：" + decode);
    System.out.println(
      "长度变化：" + str.getBytes().length * 8 + " ===> " + binary.length()
    );
  }

  public static String encode(
    String str,
    Map<Character, Integer> frequenceMap
  ) {
    if (str == null || str.equals("")) {
      return "";
    }
    // 获取字符数组
    char[] chars = str.toCharArray();
    // 叶子节点
    List<Node> leafs = new ArrayList<Node>();
    // 建树
    buildTree(frequenceMap, leafs);
    // 编码之后的信息，每个字符对应二进制
    Map<Character, String> binaryMap = buildBinaryInfo(leafs);

    // 拼接起来
    StringBuilder buffer = new StringBuilder();
    for (char c : chars) {
      buffer.append(binaryMap.get(c));
    }

    return buffer.toString();
  }

  // 解码
  public static String decode(
    String binary,
    Map<Character, Integer> frequenceMap
  ) {
    if (binary == null || binary.equals("")) {
      return "";
    }
    // 二进制数组
    char[] binarys = binary.toCharArray();
    LinkedList<Character> binaryList = new LinkedList<>();
    int size = binarys.length;
    // 转列表
    for (int i = 0; i < size; i++) {
      binaryList.addLast(binarys[i]);
    }

    List<Node> leafs = new ArrayList<>();

    // 重建树
    Tree tree = buildTree(frequenceMap, leafs);

    StringBuffer buffer = new StringBuffer();

    // 只要还有二进制字符
    while (binaryList.size() > 0) {
      // 回到根节点
      Node node = tree.root;

      do {
        // 移除第一个二进制字符
        Character c = binaryList.removeFirst();
        if (c == '0') {
          // 左子树
          node = node.left;
        } else {
          // 右子树
          node = node.right;
        }
        // 只要不是叶子节点，就一直循环，到叶子节点结束
      } while (!node.isLeaf());
      // 添加当前节点的字符
      buffer.append(node.chars);
    }
    // 转字符串
    return buffer.toString();
  }

  // 对每个字符进行编码，也就是按照二进制来匹配
  private static Map<Character, String> buildBinaryInfo(List<Node> leafs) {
    Map<Character, String> binaryMap = new HashMap<>();
    for (Node node : leafs) {
      // 获取节点的第一个字符（其实叶子节点只有一个字符）
      Character c = node.chars.charAt(0);
      String binary = "";
      // 暂存当前节点
      Node tempNode = node;
      // 从叶子节点，开始往上，到根节点
      do {
        // 如果是左节点，则是 0
        if (tempNode.isLeftChild()) {
          binary = "0" + binary;
        } else {
          // 右节点，是 1
          binary = "1" + binary;
        }
        // 到上一层
        tempNode = tempNode.parent;
        // 直到没有父节点
      } while (tempNode.parent != null);
      // 存储起来
      binaryMap.put(c, binary);
    }

    return binaryMap;
  }

  // 统计字符出现的次数/频率
  public static Map<Character, Integer> getFrequency(char[] chars) {
    Map<Character, Integer> map = new HashMap<Character, Integer>();
    for (char c : chars) {
      // 已经出现过
      if (map.containsKey(c)) {
        // 频次加一
        map.put(c, map.get(c) + 1);
      } else {
        // 首次出现，频次为 1
        map.put(c, 1);
      }
    }
    return map;
  }

  // 打印
  public static void printFrequency(Map<Character, Integer> frequencyMap) {
    for (Map.Entry<Character, Integer> e : frequencyMap.entrySet()) {
      System.out.println(e.getKey() + " : " + e.getValue());
    }
  }

  // 按照出现频率建树
  private static Tree buildTree(
    Map<Character, Integer> frequencyMap,
    List<Node> leafs
  ) {
    // 转字符数组
    Character[] keys = frequencyMap.keySet().toArray(new Character[0]);

    // 初始化节点加到优先队列，频率高的在前面
    PriorityQueue<Node> queue = new PriorityQueue<>();
    for (Character c : keys) {
      Node node = new Node();
      // 字符
      node.chars = c.toString();
      // 出现频率
      node.frequence = frequencyMap.get(c);
      // 添加到队列
      queue.add(node);
      // 添加到叶子节点
      leafs.add(node);
    }
    while (queue.size() > 1) {
      // 弹出两个最低频的接点
      Node node1 = queue.poll();
      Node node2 = queue.poll();

      // 合成新的节点
      Node parent = new Node();
      // 字符串合并
      parent.chars = node1.chars + node2.chars;
      // 频率合并
      parent.frequence = node1.frequence + node2.frequence;

      parent.left = node1;
      parent.right = node2;

      node1.parent = parent;
      node2.parent = parent;

      queue.add(parent);
    }

    Tree tree = new Tree();
    // 最后一个是根节点
    tree.root = queue.poll();
    return tree;
  }
}

// 树
class Tree {
  // 根节点
  public Node root;

  public Node getRoot() {
    return root;
  }

  public void setRoot(Node root) {
    this.root = root;
  }
}

// 节点（实现 Comparable可排序）
class Node implements Comparable<Node> {
  public String chars = "";
  // 字符出现的频率
  public int frequence = 0;
  // 父节点
  public Node parent;
  // 左节点
  public Node left;
  // 右节点
  public Node right;

  // 重写排序方法（根据出现频率，高的在前面）
  @Override
  public int compareTo(Node n) {
    return frequence - n.frequence;
  }

  // 叶子节点
  public boolean isLeaf() {
    return chars.length() == 1;
  }

  // 根节点
  public boolean isRoot() {
    return parent == null;
  }

  // 是否是左节点
  public boolean isLeftChild() {
    return parent != null && this == parent.left;
  }
}