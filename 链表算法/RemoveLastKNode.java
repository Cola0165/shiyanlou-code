class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}
public class RemoveLastKNode {
    public static ListNode removeLastKNode(ListNode head, int n) {
        if (head == null) {
            return null;
        }
        // 前置牵引节点
        ListNode pre = new ListNode(-1);
        pre.next = head;
        // 快指针
        ListNode first = pre;
        // 慢指针
        ListNode second = pre;
        // 快指针先走 n 步
        while (n != 0 && first != null) {
            first = first.next;
            n--;
        }
        if (first != null) {
            // 快慢指针一起走
            while (first.next != null) {
                first = first.next;
                second = second.next;
            }
            // 删除该节点
            second.next = second.next.next;
        }
        // 返回链表的头节点
        return pre.next;
    }

    public static void main(String[] args) {
        ListNode head = initTestList();
        System.out.println("原链表：");
        printList(head);
        System.out.println("删除倒数第3个节点后的链表：");
        ListNode result = removeLastKNode(head, 3);
        printList(result);

    }

    static ListNode initTestList() {
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(2);
        listNode.next.next = new ListNode(3);
        listNode.next.next.next = new ListNode(4);
        listNode.next.next.next.next = new ListNode(5);
        listNode.next.next.next.next.next = new ListNode(6);
        listNode.next.next.next.next.next.next = new ListNode(7);
        return listNode;
    }

    private static void printList(ListNode head) {
        ListNode p = head;
        while (p != null) {
            System.out.print(p.val + " --> ");
            // 移动到下一个元素
            p = p.next;
        }
        System.out.println(" null");
    }
}