
class RandomListNode {
    int label;
    RandomListNode next = null;
    RandomListNode random = null;

    RandomListNode(int label) {
        this.label = label;
    }
}

public class RandomListCopy {
    public static void main(String[] args) {
        RandomListNode node1 = new RandomListNode(1);
        RandomListNode node2 = new RandomListNode(2);
        RandomListNode node3 = new RandomListNode(3);
        RandomListNode node4 = new RandomListNode(4);
        RandomListNode node5 = new RandomListNode(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        node2.random = node1;
        node1.random = node3;

        System.out.print("原链表：");
        printList(node1);

        RandomListCopy randomListCopy = new RandomListCopy();
        RandomListNode newNode = randomListCopy.Clone(node1);
        System.out.print("copy的链表：");
        printList(newNode);
    }

    private static void printList(RandomListNode head) {
        RandomListNode p = head;
        while (p != null) {
            System.out.print(p.label);
            if (p.random != null) {
                System.out.print(("(" + p.random.label + ")"));
            }
            System.out.print(" --> ");
            // 移动到下一个元素
            p = p.next;
        }
        System.out.println(" null");
    }

    public static RandomListNode Clone(RandomListNode pHead) {
        if (pHead == null) {
            return null;
        }
        RandomListNode head = new RandomListNode(pHead.label);
        RandomListNode newHead = head;
        RandomListNode oldHead = pHead;
        while (oldHead.next != null) {
            RandomListNode next = new RandomListNode(oldHead.next.label);
            newHead.next = next;

            oldHead = oldHead.next;
            newHead = newHead.next;
        }

        RandomListNode newRandomHead = head;
        RandomListNode oldRandomHead = pHead;
        while (oldRandomHead != null) {
            // 找到第一个节点的随机节点
            RandomListNode randomNode = oldRandomHead.random;
            if (randomNode != null) {
                RandomListNode temp = pHead;
                RandomListNode tempNew = head;
                while (temp != randomNode) {
                    temp = temp.next;
                    tempNew = tempNew.next;
                }
                newRandomHead.random = tempNew;
            }
            oldRandomHead = oldRandomHead.next;
            newRandomHead = newRandomHead.next;
        }
        return head;
    }
}