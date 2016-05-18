
import java.util.*;

import org.jgrapht.*;

/**
 * Inspects a graph for the biconnectivity property. See
 * {@link BlockCutpointGraph} for more information. A biconnected graph has only
 * one block (i.e. no cutpoints).
 * 
 * @author Guillaume Boulmier
 * @since July 5, 2007
 */
public class BiconnectivityInspector<V, E> {
	private BlockCutpointGraph<V, E> blockCutpointGraph;

	/**
	 * Running time = O(m) where m is the number of edges.
	 */
	public BiconnectivityInspector(UndirectedGraph<V, E> graph) {
		super();
		this.blockCutpointGraph = new BlockCutpointGraph<V, E>(graph);
	}

	/**
	 * Returns the biconnected vertex-components of the graph.
	 */
	public Set<Set<V>> getBiconnectedVertexComponents() {
		Set<Set<V>> biconnectedVertexComponents = new HashSet<Set<V>>();
		for (Iterator<UndirectedGraph<V, E>> iter = this.blockCutpointGraph
				.vertexSet().iterator(); iter.hasNext();) {
			UndirectedGraph<V, E> subgraph = iter.next();
			if (!subgraph.edgeSet().isEmpty()) {
				biconnectedVertexComponents.add(subgraph.vertexSet());
			}
		}

		return biconnectedVertexComponents;
	}

	/**
	 * Returns the biconnected vertex-components containing the vertex. A
	 * biconnected vertex-component contains all the vertices in the component.
	 * A vertex which is not a cutpoint is contained in exactly one component. A
	 * cutpoint is contained is at least 2 components.
	 * 
	 * @param vertex
	 * 
	 * @return set of all biconnected vertex-components containing the vertex.
	 */
	public Set<Set<V>> getBiconnectedVertexComponents(V vertex) {
		Set<Set<V>> vertexComponents = new HashSet<Set<V>>();
		for (Iterator<Set<V>> iter = getBiconnectedVertexComponents()
				.iterator(); iter.hasNext();) {
			Set<V> vertexComponent = iter.next();
			if (vertexComponent.contains(vertex)) {
				vertexComponents.add(vertexComponent);
			}
		}
		return vertexComponents;
	}

	/**
	 * Returns the cutpoints of the graph.
	 */
	public Set<V> getCutpoints() {
		return this.blockCutpointGraph.getCutpoints();
	}

	/**
	 * Returns <code>true</code> if the graph is biconnected (no cutpoint),
	 * <code>false</code> otherwise.
	 */
	public boolean isBiconnected() {
		return this.blockCutpointGraph.vertexSet().size() == 1;
	}
}

// End BiconnectivityInspector.java
