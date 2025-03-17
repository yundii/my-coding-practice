// 206. Reverse Linked List

class ListNode{
    int val;
    ListNode next;
    ListNode(int i) {
        val = i;
        next = null;
    }
    ListNode(int i, ListNode node) {
        val = i;
        next = node;
    }
}

class ReverseLinkedList{
    public ListNode reverseList(ListNode head) {
        ListNode curr = head;
        ListNode next = null;
        ListNode prev = null;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    public static void main(String[] args) {
        ReverseLinkedList solution = new ReverseLinkedList();
        ListNode node3 = new ListNode(3);
        ListNode node2 = new ListNode(2, node3);
        ListNode node1 = new ListNode(1, node2);
        ListNode newHead = solution.reverseList(node1);
        for (int i = 0; i < 3; i++) {
            System.out.println(newHead.val);
            newHead = newHead.next;
        }

    }
}