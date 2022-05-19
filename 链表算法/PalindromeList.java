class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}
public class PalindromeList {
    public static boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        // 快慢指针
        ListNode slow = head, fast = head;
        // 已经翻转的部分的头结点（初始化为null）
        ListNode pre = null;
        while (fast != null && fast.next != null) {
            // 快指针往后走
            fast = fast.next.next;
            // 慢指针的下一个节点
            ListNode temp = slow.next;
            // 慢指针指向已经翻转的头结点
            slow.next = pre;
            // 更新已经翻转的头结点
            pre = slow;
            // 慢指针指向了之前的下一个节点
            slow = temp;
        }
        // 说明是单数个节点，慢指针其实在中心，需要往下走一个节点
        if (fast != null) {
            slow = slow.next;
        }
        // 对比两个链表
        while (pre != null && slow != null) {
            if (pre.val != slow.val) {
                return false;
            }
            pre = pre.next;
            slow = slow.next;
        }
        return true;
    }

    static ListNode initTestList() {
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(2);
        listNode.next.next = new ListNode(3);
        listNode.next.next.next = new ListNode(4);
        listNode.next.next.next.next = new ListNode(3);
        listNode.next.next.next.next.next = new ListNode(2);
        listNode.next.next.next.next.next.next = new ListNode(1);
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

    public static void main(String[] args) {
        ListNode head = initTestList();
        printList(head);
        System.out.println("是否是回文链表：" + isPalindrome(head));
    }
}