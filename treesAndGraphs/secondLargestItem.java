class secondLargestItem{
	public int findSecondLargest(TreeNode<T> root){
		if(root == null)
			throw new NullPointerException("Tree is empty!");

		if(root.leftChild == null && root.rightChild == null)
			throw new IllegalArgumentException("Tree must have at least 2 nodes!");

		TreeNode<T> current = root;
		int secondLargest = root.data;

		while(current.rightChild != null){
			secondLargest = current.data;
			current = current.rightChild;
		}

		if(current.leftChild != null){
			current = current.leftChild;
			secondLargest = current.data;
		}

		while(current.rightChild != null){
			secondLargest = current.data;
			current = current.rightChild;
		}
		
		return secondLargest;
	}

}
