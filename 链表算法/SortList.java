class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}
public class SortList {
    public static ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode pre = new ListNode(-1);
        pre.next = head;
        ListNode fast = pre;
        ListNode slow = pre;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        ListNode first = pre.next;
        ListNode second = slow.next;
        slow.next = null;

        first = sortList(first);
        second = sortList(second);

        return merge(first, second);

    }

    public static ListNode merge(ListNode l1, ListNode l2) {
        ListNode pre = new ListNode(-1);
        ListNode node = pre;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                ListNode next = l1.next;
                node.next = l1;
                l1.next = null;
                node = node.next;
                l1 = next;
            } else {
                ListNode next = l2.next;
                node.next = l2;
                l2.next = null;
                node = node.next;
                l2 = next;
            }
        }
        if (l1 != null) {
            node.next = l1;
        }
        if (l2 != null) {
            node.next = l2;
        }

        return pre.next;
    }

    // 打印链表
    private static void printList(ListNode head) {
        ListNode p = head;
        while (p != null) {
            System.out.print(p.val + " --> ");
            // 移动到下一个元素
            p = p.next;
        }
        System.out.println(" null");
    }

    public static void main(String[] args) {
        System.out.print("排序前：");
        ListNode head = initTestList();
        printList(head);
        head = sortList(head);
        System.out.print("排序后：");
        printList(head);
    }

    static ListNode initTestList() {
        ListNode listNode = new ListNode(15);
        listNode.next = new ListNode(9);
        listNode.next.next = new ListNode(11);
        listNode.next.next.next = new ListNode(2);
        listNode.next.next.next.next = new ListNode(8);
        listNode.next.next.next.next.next = new ListNode(4);
        listNode.next.next.next.next.next.next = new ListNode(12);
        listNode.next.next.next.next.next.next.next = new ListNode(1);
        return listNode;
    }
}