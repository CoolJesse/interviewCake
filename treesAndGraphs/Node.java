
import java.util.List;

class Node<T>{
	/***************************** Node Fields ******************************/
  	public T data;
  	public List<Node<T>> adjacent;
	public boolean visited;
	/*************************** Node Constructor ***************************/
	public Node(T data){
		this(data, null, false);
	}
	public Node(T data, List<Node<T>> adjacent, boolean visited){
		this.data = data;
		this.adjacent = adjacent;
		this.visited = visited;
	}
}
