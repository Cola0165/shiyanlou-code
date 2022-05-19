
class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}
public class DeleteDuplicationNode {
    public static ListNode deleteDuplication(ListNode pHead) {
        ListNode head = new ListNode(-1);
        head.next = pHead;
        // 上一个元素指针为pre
        ListNode pre = head, cur = pHead;
        while (cur != null) {
            // 存在相同节点
            if (cur.next != null && cur.val == cur.next.val) {
                cur = cur.next;
                // 删除相同节点
                while (cur.next != null && cur.val == cur.next.val) {
                    cur = cur.next;
                }
                // 跳到下一个不同的节点进行判断
                cur = cur.next;
                pre.next = cur;
            } else {
                pre = cur;
                cur = cur.next;
            }
        }
        return head.next;
    }

    static ListNode initTestList() {
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(2);
        listNode.next.next = new ListNode(2);
        listNode.next.next.next = new ListNode(3);
        listNode.next.next.next.next = new ListNode(3);
        listNode.next.next.next.next.next = new ListNode(3);
        listNode.next.next.next.next.next.next = new ListNode(5);
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
        System.out.println("原链表：");
        printList(head);
        System.out.println("删除重复节点后的链表：");
        ListNode result = deleteDuplication(head);
        printList(result);
    }
}
