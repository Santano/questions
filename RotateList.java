package practiceQuestions;

public class RotateList {

	public static void main(String[] args) {
		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(2);
//		ListNode n3 = new ListNode(4);
//
//		ListNode n4 = new ListNode(3);
//		ListNode n5 = new ListNode(4);
//		ListNode n6 = new ListNode(5);

		n1.next = n2;
//		n2.next = n3;
//		n3.next = n4;
//		n4.next = n5;
//		n5.next = n6;
		printList(n1);
		n1 = rotateRight(n1, 3);
		printList(n1);
	}

	public static void printList(ListNode x) {
		if (x != null) {
			System.out.print(x.val + " ");
			while (x.next != null) {
				System.out.print(x.next.val + " ");
				x = x.next;
			}
			System.out.println();
		}

	}

	public static ListNode rotateRight(ListNode head, int n) {
		if (n == 0 || head == null)
			return head;
		int len = 1;
		ListNode curr = head;
		while (curr.next != null) {
			len++;
			curr = curr.next;
		}
		n = n % len;
		len = len - n;
		while (len > 0) {
			curr.next = head;
			curr = curr.next;
			head = head.next;
			curr.next = null;			
			len--;
		}
		return head;
	}
}

class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
		next = null;
	}
}
