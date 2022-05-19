import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

public class LFUCache<K, V> {
    // 容量
    int capacity;
    // 时间戳
    int timeStamp = 0;
    // 键值对
    Map<K, Node> map;
    // 按照频次排序的节点
    TreeSet<Node> frequencyNodes;

    public LFUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<K, Node>();
        frequencyNodes = new TreeSet<Node>();
    }

    public V get(K key) {
        // 如果不包含，直接返回
        if (!map.containsKey(key)) {
            return null;
        }
        // 获取值
        Node<K, V> node = map.get(key);
        // 删掉旧的值
        frequencyNodes.remove(node);
        // 更新使用次数
        node.usedCount += 1;
        // 更新最后一次使用的时间
        node.lastUsedTime = ++timeStamp;
        // 重新添加
        frequencyNodes.add(node);
        // 更新节点的值
        map.put(key, node);
        return node.value;
    }

    public void put(K key, V value) {
        // 容量是不是等于 0
        if (capacity == 0) {
            return;
        }
        // 之前不包含该 key
        if (!map.containsKey(key)) {
            // 容量超出
            if (map.size() == capacity) {
                // 移除第一个值（使用频率最低）
                map.remove(frequencyNodes.first().key);
                // 移除第一个
                frequencyNodes.remove(frequencyNodes.first());
            }
            // 创建新节点
            Node node = new Node(1, ++timeStamp, key, value);
            // 添加
            map.put(key, node);
            frequencyNodes.add(node);
        } else {
            Node node = map.get(key);
            // 移除掉，为了更新频率
            frequencyNodes.remove(node);
            // 更新使用次数
            node.usedCount += 1;
            node.lastUsedTime = ++timeStamp;
            node.value = value;
            frequencyNodes.add(node);
            // 添加
            map.put(key, node);
        }
    }
}

class Node<K, V> implements Comparable<Node> {
    // 使用次数，最后使用时间戳
    long usedCount, lastUsedTime;
    // 键
    K key;
    // 值
    V value;

    Node(long usedCount, long lastUsedTime, K key, V value) {
        this.usedCount = usedCount;
        this.lastUsedTime = lastUsedTime;
        this.key = key;
        this.value = value;
    }

    public int compareTo(Node node) {
        // 如果使用次数一样，就按照最后使用时间戳排序
        return (int) (usedCount == node.usedCount ? lastUsedTime - node.lastUsedTime : usedCount - node.usedCount);
    }
}