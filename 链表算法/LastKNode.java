public class LastKNode {

  public static void main(String[] args) {
    // 构建链表 1 --> 2 --> 3 --> 4
    ListNode head = new ListNode(1);
    head.next = new ListNode(2);
    head.next.next = new ListNode(3);
    head.next.next.next = new ListNode(4);
    // 查找第三个节点
    ListNode kNode = findKNode(head, 3);
    System.out.println(kNode.val);
  }

  public static ListNode findKNode(ListNode head, int k) {
    while (k > 1) {
      if (head != null) {
        head = head.next;
      }
      k--;
    }
    return head;
  }
}