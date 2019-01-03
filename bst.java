class bst{
	class TreeNode{
		int val;
		TreeNode left;
		TreeNode right;
	}

	// check if it is a binary search tree
	public boolean isBst(TreeNode node){
		h(node, Integer.MIN_VALUE, Integer.MAX_VALUE)

	}

	public boolean h(TreeNode root, int leftB, int rightB){
		if(root == null){
			return true;
		}
		if(root.val > leftB && root.val < rightB){
			// go to left child
			h(root.left, leftB, root.val);
			// go to right child
			h(root.right, root.val, rightB);
		}else{
			return false;
		}
	}

	// given a range, print all numbers which in the range
	public void range(TreeNode root, int leftB, int rightB){
		if(root == null){
			return;
		}
		if(leftB < root.val){
			range(root.left, leftB, rightB);
		}else if(rightB < root.val){
			range(root.right, leftB, rightB);
		}
		if(root.val > leftB && root.val < rightB){
			System.out.println(root.val);
		}
	}
}