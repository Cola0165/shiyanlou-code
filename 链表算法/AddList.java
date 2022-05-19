class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

public class AddList {
    public static void main(String[] args) {
        ListNode listNode1 = initList1();
        printList(listNode1);
        ListNode listNode2 = initList2();
        printList(listNode2);
        System.out.println("结果：");
        ListNode result = addTwoNumbers(listNode1, listNode2);
        printList(result);
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(0);
        ListNode head = result;
        // 定义临时变量表示进位数
        int temp = 0;
        while (l1 != null || l2 != null || temp != 0) {
            // 两个数的当前位相加，加上之前的进位
            int sum = (l1 != null ? l1.val : 0) + (l2 != null ? l2.val : 0) + temp;
            // 再次进位
            temp = sum / 10;
            // 余数就是相加后的当前位
            head.next = new ListNode(sum % 10);
            // 指针指向下一位
            head = head.next;
            // 如果为null了，那么一直保持为null即可，.next()会导致空指针
            l1 = (l1 != null) ? l1.next : l1;
            l2 = (l2 != null) ? l2.next : l2;
        }
        return result.next;
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

    static private ListNode initList1() {
        ListNode listNode = new ListNode(6);
        listNode.next = new ListNode(7);
        listNode.next.next = new ListNode(8);
        listNode.next.next.next = new ListNode(9);
        return listNode;
    }

    static private ListNode initList2() {
        ListNode listNode = new ListNode(5);
        listNode.next = new ListNode(4);
        listNode.next.next = new ListNode(3);
        listNode.next.next.next = new ListNode(2);
        listNode.next.next.next.next = new ListNode(1);
        return listNode;
    }
}