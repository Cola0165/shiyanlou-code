class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

public class SwapTowNode {
    public static ListNode swapPairs(ListNode head) {
        ListNode cur = new ListNode(0);
        cur.next = head;
        ListNode fisrt = cur;
        ListNode next = cur;
        while (fisrt.next != null && fisrt.next.next != null) {
            next = fisrt.next.next.next;
            ListNode temp = fisrt.next;
            fisrt.next = fisrt.next.next;
            temp.next = next;
            fisrt.next.next = temp;


            fisrt = fisrt.next.next;
        }
        return cur.next;
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

    public static void main(String[] args) {
        ListNode head = initTestList();
        System.out.print("交换前：");
        printList(head);
        System.out.print("交换后：");
        ListNode result = swapPairs(head);
        printList(result);
    }
}