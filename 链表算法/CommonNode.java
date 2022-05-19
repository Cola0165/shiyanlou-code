class ListNode {
    int val;
    ListNode next = null;
  
    ListNode(int val) {
      this.val = val;
    }
  }
  
  public class CommonNode {
  
    public static void main(String[] args) {
      // 链表 1
      ListNode p1 = new ListNode(1);
      p1.next = new ListNode(2);
      p1.next.next = new ListNode(3);
  
      // 链表 2
      ListNode p2 = new ListNode(4);
      p2.next = new ListNode(5);
  
      // 相同节点
      ListNode common = new ListNode(6);
      common.next = new ListNode(7);
  
      p1.next.next.next = common;
      p2.next.next = common;
  
      CommonNode commonNode = new CommonNode();
      ListNode listNode = commonNode.findFirstCommonNode(p1, p2);
      System.out.println(listNode.val);
    }
  
    public ListNode findFirstCommonNode(ListNode pHead1, ListNode pHead2) {
      // 只要有一个为空，就不存在共同节点
      if (pHead1 == null || pHead2 == null) {
        return null;
      }
      ListNode head1 = pHead1;
      ListNode head2 = pHead2;
      while (head1 != head2) {
        // 如果下一个节点为空，则切换到另一个链表的头节点，否则下一个节点
        head1 = (head1 == null) ? pHead2 : head1.next;
        head2 = (head2 == null) ? pHead1 : head2.next;
      }
      return head1;
    }
  }