class ListNode {
    int val;
    ListNode next = null;
  
    ListNode(int val) {
      this.val = val;
    }
  }
  
  public class CycleLink {
  
    public static void main(String[] args) {
      ListNode head = new ListNode(1);
      head.next = new ListNode(2);
      head.next.next = new ListNode(3);
      head.next.next.next = new ListNode(4);
      head.next.next.next.next = head.next;
      System.out.println(findCycleStartNode(head).val);
    }
  
    public static ListNode findCycleStartNode(ListNode head) {
      if (head == null || head.next == null) {
        return null;
      }
      // 快指针
      ListNode fast = head;
      // 慢指针
      ListNode slow = head;
      // 两个指针同时移动
      while (fast != null && fast.next != null) {
        // 快指针每次移动两步
        fast = fast.next.next;
        // 慢指针每次移动一步
        slow = slow.next;
        if (fast == slow) {
          break;
        }
      }
      // 判空可以避免没有环的情况，没有环则不会相遇
      if (fast == null || slow != fast) {
        return null;
      }
      //有环则找入口节点，把快指针放到起点
      fast = head;
      // 再次同时移动
      while (fast != slow) {
        // 两个指针都是每次移动一次
        fast = fast.next;
        slow = slow.next;
      }
      // 相遇的地方就是环的起点
      return fast;
    }
  }