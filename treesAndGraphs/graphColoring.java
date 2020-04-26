import java.util.Collections;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.Queue;
import java.util.LinkedList;

public class graphColoring{
/************************** Nested GraphNode class ***************************/
	public static class GraphNode {

		private String label;
		private Set<GraphNode> neighbors;
		private Optional<String> color;

		public GraphNode(String label) {
			this.label = label;
			neighbors = new HashSet<GraphNode>();
			color = Optional.empty();
		}

		public String getLabel() {
			return label;
		}

		public Set<GraphNode> getNeighbors() {
			return Collections.unmodifiableSet(neighbors);
		}

		public void addNeighbor(GraphNode neighbor) {
			neighbors.add(neighbor);
		}

		public boolean hasColor() {
			return color.isPresent();
		}

		public String getColor() {
			return color.get();
		}

		public void setColor(String color) {
			this.color = Optional.ofNullable(color);
		}
	}
/*****************************************************************************/
/*************************** Solution algorithm ******************************/
	public static void colorGraph(GraphNode[] graph, String[] colors){
		// create a valid coloring for the graph
		if(graph == null)
			return;

		Queue<GraphNode> q = new LinkedList<>();

		for(int i=0; i < graph.length; i++){
			if(!graph[i].hasColor())
				q.add(graph[i]);

			while(q.size() > 0){

				GraphNode current = q.poll();

				if(!current.hasColor()){
					Set<String> usedColors = new HashSet<>();

					for(GraphNode node : current.getNeighbors()){

						if(node == current)
							throw new RuntimeException("Cycle found for node " + current.getLabel());

						else if(!node.hasColor())
							q.add(node);

						else
							usedColors.add(node.getColor());
					}

					for(String color : colors){
						if(!usedColors.contains(color)){
							current.setColor(color);
							break;
					}
				}
			}
		}
	}
}
/*****************************************************************************/
/*************************** Better Solution *********************************/
	public static void colorGraph(GraphNode[] graph, String[] colors){
		for (GraphNode node : graph) {
			Set<GraphNode> neighbors = node.getNeighbors();

			if(neighbors.contains(node)) {
		   		throw new IllegalArgumentException(String.format(
		   		"Legal coloring impossible for node with loop: %s", node.getLabel()));
	   		}

		   // get the node's neighbors' colors, as a set so we
		   // can check if a color is illegal in constant time
		   Set<String> illegalColors = new HashSet<>();
		   
		   for (GraphNode neighbor : neighbors) {
			   if (neighbor.hasColor()) {
				   illegalColors.add(neighbor.getColor());
			   }
		   }

		   // assign the first legal color
		   for (String color : colors) {
			   if (!illegalColors.contains(color)) {
				   node.setColor(color);
				   break;
			   }
		   	}
   		}
	}
}
