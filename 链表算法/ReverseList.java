class ListNode {
    int val;
    ListNode next = null;
  
    ListNode(int val) {
      this.val = val;
    }
  }
  
  public class ReverseList {
  
    public static void main(String[] args) {
      ListNode head = new ListNode(1);
      head.next = new ListNode(2);
      head.next.next = new ListNode(3);
      head.next.next.next = new ListNode(4);
      // 打印
      printList(head);
      // 翻转链表
      ListNode rHead = reverse(head);
      // 打印
      printList(rHead);
    }
  
    public static ListNode reverse(ListNode head) {
      if (head == null) {
        // 判空
        return head;
      } else {
        // 新建空节点
        ListNode first = null;
        while (head != null) {
          // 保存下一个节点
          ListNode temp = head.next;
          // 将 head 的下一个节点指针修改为指向左边
          head.next = first;
          // 修改左边的链表的头节点
          first = head;
          // 修改需要翻转的头结点指针
          head = temp;
        }
        return first;
      }
    }
  
    // 打印链表
    public static void printList(ListNode head) {
      ListNode p = head;
      while (p != null) {
        System.out.print(p.val + " --> ");
        // 移动到下一个元素
        p = p.next;
      }
      System.out.println(" null");
    }
  }