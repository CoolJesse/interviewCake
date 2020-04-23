class TreeNode<T>{
  /************************* TreeNode Fields ****************************/
	public T data;
	public TreeNode<T> leftChild;
	public TreeNode<T> rightChild;
  /***********************TreeNode Constructors *************************/
	public TreeNode(T data){
	  this(data, null, null);
	}
	public TreeNode(T data, TreeNode<T> left, TreeNode<T> right){
	  this.data = data;
	  leftChild = left;
	  rightChild = right;
	}
}
