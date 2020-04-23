class BSTChecker{

	public boolean isValid(){
		//return isValid(root, Integer.MAX_VALUE, Integer.MIN_VALUE);
		return true;
	}

	private <T> boolean isValid(TreeNode<T> node, int maxValue, int minValue){
		if(node == null)
			return true;

		if(node.data >= maxValue || node.data <= minValue)
			return false;

		else{
			return isValid(node.leftChild, node.value, minValue) &&
			isValid(node.rightChild, maxValue, node.value);
		}
	}
}
