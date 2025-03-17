public class ListNode {
    int val;
    ListNode next;
    ListNode() {};
    ListNode(int i){
        this.val = i;
    }
    ListNode(int i, ListNode node){
        this.val = i;
        this.next = node;
    }
}


