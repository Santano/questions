package practiceQuestions;

import java.util.ArrayList;
import java.util.List;

public class MergeList {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
//		ListNode n1 = new ListNode(1);
//		ListNode n2 = new ListNode(2);
//		// ListNode n3 = new ListNode(4);
//
//		ListNode n4 = new ListNode(3);
//		ListNode n5 = new ListNode(4);
//		ListNode n6 = new ListNode(5);
//
//		n1.next = n2;
//		n2.next = n4;
//		// n3.next = n4;
//		n4.next = n5;
//		n5.next = n6;
//
//		ListNode n11 = new ListNode(1);
//		ListNode n12 = new ListNode(2);
//		// ListNode n13 = new ListNode(4);
//
//		ListNode n14 = new ListNode(3);
//		ListNode n15 = new ListNode(4);
//		ListNode n16 = new ListNode(5);
//
//		n11.next = n12;
//		n12.next = n14;
//		// n13.next = n14;
//		n14.next = n15;
//		n15.next = n16;
//
//		List<ListNode> x = new ArrayList<ListNode>();
//		x.add(n1);
//		x.add(n11);
		mergeKLists(new ArrayList<ListNode>());
//		printList(n1);
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

	public static ListNode mergeKLists(List<ListNode> lists) {
		if (lists.size() == 0)
			return null;
		ListNode result = null;
		Boolean complete = false;
		ListNode head = null;
		while (!complete) {
			complete = true;
			ListNode minNode = null;
			for (ListNode n : lists) {
				if (n == null)
					continue;
				complete = false;
				if (minNode == null || n.val < minNode.val)
					minNode = n;
			}
			if (complete)
				break;
			if (result == null) {
				result = minNode;
				head = minNode;
			} else {
				result.next = minNode;
				result = result.next;
			}
			lists.remove(minNode);
			minNode = minNode.next;
			if (minNode != null)
				lists.add(minNode);

			// result.next = null;
		}
		result.next = null;
		return head;
	}

}
