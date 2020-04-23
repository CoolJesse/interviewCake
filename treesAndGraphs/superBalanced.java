class superBalanced{

	public static<T> boolean isSuperBalanced(TreeNode<T> root){
		return height(root) != -1;
	}

	public static<T> int height(TreeNode<T> node){
		if(node == null)
			return 0;

		if(node.leftChild == null && node.rightChild == null)
			return 1;

		int leftChildHeight = height(node.leftChild);
		if(leftChildHeight == -1)
			return -1;

		int rightChildHeight = height(node.rightChild);
		if(rightChildHeight == -1)
			return -1;

		if(Math.abs(leftChildHeight - rightChildHeight) > 1)
			return -1;

		else
			return 1 + Math.max(leftChildHeight, rightChildHeight);
	}
}
