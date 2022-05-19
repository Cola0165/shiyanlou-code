class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}
public class ReverseKList {
    public static ListNode reverseKGroup(ListNode head, int k) {
        if (k == 0 || k == 1) {
            return head;
        }
        int n = k;
        // 初始化一个前置节点，牵引着链表
        ListNode pre = new ListNode(0);
        pre.next = head;
        // 操作过程pre会变，first不会变
        ListNode first = pre;
        // 区间尾部
        ListNode tail = pre;
        // 如果走到链表尾部结束
        while (tail.next != null) {
            // 走过k步
            while (tail.next != null && k > 0) {
                k--;
                tail = tail.next;
            }
            // 剩下的不够k步，直接结束
            if (k > 0) {
                return first.next;
            }
            // 保存链表下一个开始部分，防止引用丢失
            ListNode nextNode = tail.next;
            // 断开尾部连接
            tail.next = null;
            // 需要翻转的头
            ListNode curHead = pre.next;
            ListNode temp = curHead;
            // 翻转
            ListNode node = reverse(temp);
            // 尾部指向翻转前的头部
            tail = curHead;
            // pre 的next连接上翻转后的头结点
            pre.next = node;
            curHead.next = nextNode;
            // pre 和tail指向同一个地方，可以开始下一次翻转
            pre = tail;
            k = n;
        }
        return first.next;
    }

    // 翻转链表，返回头结点
    private static ListNode reverse(ListNode node) {
        ListNode pre = null;
        while (node != null) {
            ListNode next = node.next;
            node.next = pre;
            pre = node;
            node = next;
        }
        return pre;
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
        ListNode head = initTestList();
        System.out.print("翻转前：");
        printList(head);
        System.out.print("每 2 个翻转后：");
        ListNode result = reverseKGroup(head, 2);
        printList(result);

        ListNode head1 = initTestList();
        System.out.print("每 3 个翻转后：");
        ListNode result1 = reverseKGroup(head1, 3);
        printList(result1);
    }

    static ListNode initTestList() {
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(2);
        listNode.next.next = new ListNode(3);
        listNode.next.next.next = new ListNode(4);
        listNode.next.next.next.next = new ListNode(5);
        listNode.next.next.next.next.next = new ListNode(6);
        listNode.next.next.next.next.next.next = new ListNode(7);
        listNode.next.next.next.next.next.next.next = new ListNode(8);
        return listNode;
    }
}