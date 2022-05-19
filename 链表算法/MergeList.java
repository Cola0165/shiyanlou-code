class ListNode {
    int val;
    ListNode next = null;
  
    ListNode(int val) {
      this.val = val;
    }
  }
  
  public class MergeList {
      public static void main(String[] args) {
          // 1-->3-->4
          ListNode head1 = new ListNode(1);
          head1.next = new ListNode(3);
          head1.next.next = new ListNode(4);
  
          // 2-->6——>7
          ListNode head2 = new ListNode(2);
          head2.next = new ListNode(6);
          head2.next.next = new ListNode(7);
  
          ListNode head = merge(head1,head2);
          printList(head);
      }
  
      public static ListNode merge(ListNode list1, ListNode list2) {
          // 判空
          if (list1 == null) {
              return list2;
          } else if (list2 == null) {
              return list1;
          } else {
              // 创建-1头节点
              ListNode head = new ListNode(-1);
              ListNode first = head;
              // 只要不为空，则比较
              while (list1 != null && list2 != null) {
                  // list1的节点更小
                  if (list1.val < list2.val) {
                      first.next = new ListNode(list1.val);
                      list1 = list1.next;
                  } else {
                      // list2的节点更小
                      first.next = new ListNode(list2.val);
                      list2 = list2.next;
                  }
                  // 新链表指针后移
                  first = first.next;
              }
              // 如果list1有剩余元素全部遍历加入
              while (list1 != null) {
                  first.next = new ListNode(list1.val);
                  list1 = list1.next;
                  first = first.next;
              }
              // 如果list2有剩余元素全部遍历加入
              while (list2 != null) {
                  first.next = new ListNode(list2.val);
                  list2 = list2.next;
                  first = first.next;
              }
              return head.next;
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