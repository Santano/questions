package practiceQuestions;

import java.util.*;

public class IterativePreOrder {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
//		TreeNode n1 = new TreeNode(5);
//		TreeNode n2 = new TreeNode(3);
//		TreeNode n3 = new TreeNode(4);
//
//		TreeNode n4 = new TreeNode(7);
//		TreeNode n5 = new TreeNode(9);
//		TreeNode n6 = new TreeNode(8);
//
//		n1.right = n4;
//		n1.left = n2;
//		// n2.left = n5;
//		n2.right = n3;
//		n5.left = n6;
//		n4.right = n5;
		TreeNode n1 = new TreeNode(1);
		TreeNode n2 = new TreeNode(2);
		n1.right = n2;
//		List<Integer> temp = preorderTraversal(n1);
	}

	public static List<Integer> preorderTraversal(TreeNode root) {
		List<Integer> po = new ArrayList<Integer>();
		if (root == null)
			return po;
		Stack<TreeNode> q = new Stack<TreeNode>();
		po.add(root.val);
		System.out.print(root.val + " ");
		q.add(root);
		while (!q.isEmpty()) {
			TreeNode curr = q.peek();
			while (curr != null && curr.left != null) {
				q.add(curr.left);
				po.add(curr.left.val);
				System.out.print(curr.left.val + " ");
				try {
					curr = q.peek();
				} catch (Exception e) {
					curr = null;
				}
			}
			try {
				curr = q.pop();
			} catch (Exception e) {
				curr = null;
			}
			if (curr == null)
				break;
			while (!q.isEmpty() && curr.right == null)
				curr = q.pop();
			if (curr.right != null) {
				po.add(curr.right.val);
				System.out.print(curr.right.val + " ");
				q.add(curr.right);
			}
		}
		return po;
	}

}

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
		val = x;
	}
}
