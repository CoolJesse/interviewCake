import java.lang.StringBuffer;

public class BinarySearchTree< T extends Comparable<T> >{
/****************************************************************************/
/************************** Nested TreeNode class ***************************/
  private class TreeNode<T>{
    /************************* TreeNode Fields ****************************/
      T data;
      TreeNode<T> leftChild;
      TreeNode<T> rightChild;

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
 /***************************************************************************/
 /************************** Binary Tree Class ******************************/
/********************************** Fields **********************************/
  private TreeNode<T> root;
/******************************* Constructor ********************************/
  public BinarySearchTree(){
    root = null;
  }
/********************************* Methods **********************************/
/************************** Add element to tree *****************************/
  public void add(T data){
    if(root == null)
      root = new TreeNode<>(data);

    else
      add(root, data); //call add() helper function
  }
/******************* Remove specified element from tree ********************/
  public void remove(T data){
    if(isEmpty())
      throw new NullPointerException("Tree is empty");

    if(root.data.equals(data)){ //if root node contains data to be removed
      if(root.leftChild == null && root.rightChild == null) //root has no kids
        root = null;

      else
        balance(root); //root node contains children
    }

    else //root node does NOT contain data to remove, check tree
      remove(root, data);
  }
/************************* Check is tree is empty *************************/
  public boolean isEmpty(){return root == null;}
/********************* Find minimum element in tree **********************/
  public T min(){
    if(isEmpty())
      throw new NullPointerException("root node is null, tree is empty.");

    return min(root); //call min() helper function
  }
 /******************** Find maximum element in tree ***********************/
  public T max(){
    if(isEmpty())
      throw new NullPointerException("root node is null, tree is empty.");

    return max(root); //call max() helper function
  }
 /*************************** Find tree height ****************************/
 	public int height(){
		if(root == null)
			return 0;

		return maxHeight(root);
	}
 /**************************** toString() method **************************/
  @Override
  public String toString(){
    StringBuffer buffer = new StringBuffer();
    System.out.print("In order traversal: ");
    inOrder(root, buffer);

    return buffer.toString();
  }
  /*************** Pre Order traversal of binary search tree ***************/
  public String preOrderTraversal(){
    StringBuffer buffer = new StringBuffer();
    System.out.printf("Preorder traversal: ");
    preOrder(root, buffer);

    return buffer.toString();
  }
  /************** Post Order traversal of binary search tree ***************/
  public String postOrderTraversal(){
    StringBuffer buffer = new StringBuffer();
    System.out.printf("Postorder Traversal: ");
    postOrder(root, buffer);

    return buffer.toString();
  }
/***************************** Helper Methods *********************************/
/********************************** add() ************************************/
  private void add(TreeNode<T> node, T data){
    if(node.data.compareTo(data) >= 0){
      if(node.leftChild == null)
        node.leftChild = new TreeNode<>(data);

      else
        add(node.leftChild, data);
    }

    else{ //node.data < data
      if(node.rightChild == null)
        node.rightChild = new TreeNode<>(data);

      else
        add(node.rightChild, data);
    }
  }
/***************************** remove() helper ******************************/
  private void remove(TreeNode<T> node, T data){

	/** This remove() function is a helper function and is never called
	 directly by the user. Instead it is called by the earlier remove()
	 function. That function deals with the case of removing the root node
	 so this function does not need to worry about that **/

    // If value to be removed is less than current TreeNode value //
    if(node.data.compareTo(data) > 0){
      // If no leftChild exists data is not present in tree
      if(node.leftChild == null)
              System.out.println(data + " not present in tree");
      // If leftChild value is the one we want to delete
      else if(node.leftChild.data.equals(data))
        node.leftChild = balance(node.leftChild);
      // Otherwise continue through the tree
      else
        remove(node.leftChild, data);
    }

    // If value to be removed is greater than current TreeNode value //
    else{ // node.data.compareTo(data) <= 0
      // If no rightChild exists data is not present in tree
      if(node.rightChild == null)
        System.out.println(data + " not present in tree");
      // If rightChild value is the one we want to delete
      else if(node.rightChild.data.equals(data))
        node.rightChild = balance(node.rightChild);
      // Otherwise continue through the tree
      else
        remove(node.rightChild, data);
    }
  }
/** Once we find the node we wish to remove, call the balance() function to **/
  private TreeNode<T> balance(TreeNode<T> node){

    // Right subTree exits ///////////////////////////////////////////
      if(node.rightChild != null){
      // If right subtree has no left subTree
        if(node.rightChild.leftChild == null){
          node.rightChild.leftChild = node.leftChild;
          return node.rightChild;
        }

        else{
          // Move to right child of node we wish to delete
          TreeNode<T> balancingNode = node.rightChild;
          // Move through TreeNodes until we find the smallest value
          while(balancingNode.leftChild.leftChild != null){
            balancingNode = balancingNode.leftChild;
          }
        // We have now found the smallest value in the right subTree
          node.data = balancingNode.leftChild.data;
          balancingNode.leftChild = balance(balancingNode.leftChild);
        }
      }
    /////////////////////////////////////////////////////////////////
    // Right subTree does not exist but left subTree does ///////////
      else if(node.leftChild != null){
      // If left subTree has no right subtree
        if(node.leftChild.rightChild == null){
          node.leftChild.rightChild = node.rightChild;
          return node.leftChild;
        }

        else{
        // Move to left subTree of node we wish to delete
          TreeNode<T> balancingNode = node.leftChild;
          // Move through TreeNodes until we find the maximum value
          while(balancingNode.rightChild.rightChild != null){
            balancingNode = balancingNode.rightChild;
          }
        // We have now found the max value in the left subTree
          node.data = balancingNode.rightChild.data;
          balancingNode.rightChild = balance(balancingNode);
        }
      }
    /////////////////////////////////////////////////////////////////
    // TreeNode has no subtrees/no children /////////////////////////
      else
        node = null;

      return node;
  }
/*************** Find min() value in binary search tree **********************/
  private T min(TreeNode<T> node){
    if(node.leftChild == null)
      return node.data;

    else
      return min(node.leftChild);
  }
/**************** Find max() value in binary search tree *********************/
  private T max(TreeNode<T> node){
    if(node.rightChild == null)
      return node.data;

    else
      return max(node.rightChild);
  }
/****************** In Order traversal helper function ***********************/
  private void inOrder(TreeNode<T> node, StringBuffer buffer){

    if(node != null){

      //Visit leftChild
      inOrder(node.leftChild, buffer);

      //Visit node
      buffer.append(node.data.toString() + " ");

      //Visit rightChild
      inOrder(node.rightChild, buffer);
    }
  }
/****************** Pre Order traversal helper function **********************/
  private void preOrder(TreeNode<T> node, StringBuffer buffer){
    if(node != null){
      // Visit node
      buffer.append(node.data.toString() + " ");

      // Visit leftChild
      preOrder(node.leftChild, buffer);

      // Visit rightChild
      preOrder(node.rightChild, buffer);
    }
  }
/****************** Post Order traversal helper function *********************/
  private void postOrder(TreeNode<T> node, StringBuffer buffer){
    if(node != null){
      // Visit leftChild
      postOrder(node.leftChild, buffer);

      // Visit rightChild
      postOrder(node.rightChild, buffer);

      // Visit node
      buffer.append(node.data.toString() + " ");
    }
  }
/************************** minHeight() helper function **********************/
	public int minHeight(TreeNode<T> node){

		if(node == null)
			return 0;

		int leftHeight = 1 + minHeight(node.leftChild);
		int rightHeight = 1 + minHeight(node.rightChild);

		return Math.min(leftHeight, rightHeight);
	}
/************************** maxHeight() helper function **********************/
	public int maxHeight(TreeNode<T> node){

		if(node == null)
			return 0;

		int leftHeight = 1 + maxHeight(node.leftChild);
		int rightHeight = 1 + maxHeight(node.rightChild);

		return Math.max(leftHeight, rightHeight);
	}
/*****************************************************************************/
/***************** Methods for interview cake questions **********************/
/*****************************************************************************/

/****** Check if tree is "SuperBalanced" which is a made up thing *********/
	public boolean isSuperBalanced(){
		return isSuperBalanced(root) != -1;
	}
/******************** Is "SuperBalanced helper function" *********************/
/** This function will return -1 if it encounters a node where the difference
in height between its left and right children is greater than 1. Otherwise it
will return the total height of the tree. **/
	public int isSuperBalanced(TreeNode<T> node){

		if(node == null)
			return 0;

		if(node.leftChild == null && node.rightChild == null)
			return 1;

		int leftChildHeight = isSuperBalanced(node.leftChild);
		if(leftChildHeight == -1)
			return -1;

		int rightChildHeight = isSuperBalanced(node.rightChild);
		if(rightChildHeight == -1)
			return -1;

		if(Math.abs(leftChildHeight - rightChildHeight) > 1)
			return -1;

		else
			return 1 + Math.max(leftChildHeight, rightChildHeight);
	}
}
