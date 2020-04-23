import java.util.Random;

class Testing{

	public static void main(String[] args){

		Random rand = new Random();
		BinarySearchTree<Integer> tree_1 = new BinarySearchTree<>();
		BinarySearchTree<Integer> tree_2 = new BinarySearchTree<>();
		BinarySearchTree<Integer> tree_3 = new BinarySearchTree<>();
		BinarySearchTree<Integer> tree_4 = new BinarySearchTree<>();

		/** tree_1 **/
		for(int i=0; i < 20; i++){
			tree_1.add(rand.nextInt(100));
		}
		/** tree_2**/
			tree_2.add(69);

		/** tree_3 **/
			//do nothing

		/** tree_4 **/
			tree_4.add(10);
			tree_4.add(5);
			tree_4.add(4);
			tree_4.add(6);
			tree_4.add(15);
			tree_4.add(14);
			tree_4.add(16);
			//tree_4.add(2);
			//tree_4.add(1);

		System.out.println("Tree values: " + tree_1.toString());
		System.out.println("tree_1 is superBalanced " + tree_1.isSuperBalanced());

		System.out.println("Tree values: " + tree_2.toString());
		System.out.println("tree_1 is superBalanced " + tree_2.isSuperBalanced());

		System.out.println("Tree values: " + tree_3.toString());
		System.out.println("tree_1 is superBalanced " + tree_3.isSuperBalanced());

		System.out.println("Tree values: " + tree_4.toString());
		System.out.println("tree_1 is superBalanced " + tree_4.isSuperBalanced());
	}
}
