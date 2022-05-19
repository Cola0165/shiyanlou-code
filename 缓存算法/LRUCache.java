import java.util.HashMap;
import java.util.Map;

public class LRUCache<K, V> {
  // 头结点（最远使用）
  private Node<K, V> head;
  // 尾节点（最近使用）
  private Node<K, V> tail;
  // hashmap，存放节点
  private Map<K, Node<K, V>> datas;
  // 最大容量
  private int capacity;
  // 当前大小
  private int currentSize;

  public LRUCache(int capacity) {
    // 容量
    this.capacity = capacity;
    // 当前的大小为 0
    this.currentSize = 0;
    // 头节点初始化
    head = new Node<K, V>(null, null, null, null);
    tail = head;
    // hash 容器
    datas = new HashMap<K, Node<K, V>>();
  }

  public V get(K key) {
    // 获取节点
    Node<K, V> node = datas.get(key);
    if (node == null) {
      return null;
    } else if (node.key == tail.key) {
      return tail.value;
    }
    // 后一个节点
    Node<K, V> nextNode = node.next;
    // 前面一个节点
    Node<K, V> prevNode = node.pre;
    // 如果是第一个节点
    if (node.key == head.key) {
      nextNode.pre = null;
      head = nextNode;
    } else {
      // 从链表移除
      prevNode.next = nextNode;
      nextNode.pre = prevNode;
    }

    // 拼接到链表的尾部
    node.pre = tail;
    tail.next = node;
    tail = node;
    tail.next = null;
    return node.value;
  }

  public void put(K key, V value) {
    // 如果已经包含
    if (datas.containsKey(key)) {
      return;
    }
    // 新建节点，拼接到链表的尾部
    Node<K, V> node = new Node<K, V>(tail, null, key, value);
    tail.next = node;
    datas.put(key, node);
    tail = node;

    // 空间超出
    if (currentSize == capacity) {
      datas.remove(head.key);
      head = head.next;
      head.pre = null;
    } else if (currentSize < capacity) {
      if (currentSize == 0) {
        head = node;
      }
      currentSize++;
    }
  }

  // 每一个节点
  class Node<T, U> {
    // 键
    T key;
    // 值
    U value;
    // 前置节点
    Node<T, U> pre;
    // 下一个节点
    Node<T, U> next;

    public Node(Node<T, U> pre, Node<T, U> next, T key, U value) {
      this.pre = pre;
      this.value = value;
      this.key = key;
      this.next = next;
    }
  }
}