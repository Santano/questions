package practiceQuestions;

public class RemoveNthNodeFromEnd {

	public static void main(String[] args) {
		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(2);
//		ListNode n3 = new ListNode(4);
//
//		ListNode n4 = new ListNode(3);
//		ListNode n5 = new ListNode(4);
//		ListNode n6 = new ListNode(5);
//
		n1.next = n2;
//		n2.next = n4;
//		n3.next = n4;
//		n4.next = n5;
//		n5.next = n6;
		removeNthFromEnd(n1, 3);
	}
	
	public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode slow = head;
        ListNode fast = head;
        int x = n;
        while (x >= 0 && fast != null) {
            fast = fast.next;
            x--;
        }
        if (fast == null && x > 0) {
            return head;
        }
        if (fast == null && x == 0) {
            return null;
        } 
        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }
        slow.next = slow.next.next;
        return head;
    }

}
