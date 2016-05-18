package com.work;

import java.util.List;

import org.jgrapht.GraphPath;
import org.jgrapht.alg.DijkstraShortestPath;
import org.jgrapht.alg.KShortestPaths;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.SimpleDirectedWeightedGraph;

public class WeightedDirectedGraphTry {
	static SimpleDirectedWeightedGraph<String, DefaultWeightedEdge> graph;

	public static void main(String args[]) {

		graph = new SimpleDirectedWeightedGraph<String, DefaultWeightedEdge>(
				DefaultWeightedEdge.class);

//		addYensGraph();
		addMyGraph();

		// System.out.println("Shortest path from 47 to 79:");
		// List shortest_path = DijkstraShortestPath.findPathBetween(graph, "C",
		// "H");
		// System.out.println(shortest_path);

		System.out.println("Now displaying k shortest paths:");
		KShortestPaths ksp = new KShortestPaths(graph, "A", 3);
		List<GraphPath> paths = ksp.getPaths("F");
		if (paths == null)
			System.out.println("no path found.");
		else {
			for (GraphPath p : paths) {
				System.out.println(p.getEdgeList());
			}
		}

	}

	public static void addMyGraph() {
		// TODO Auto-generated method stub
		graph.addVertex("C");
		graph.addVertex("D");
		graph.addVertex("E");
		graph.addVertex("F");
		graph.addVertex("A");
		graph.addVertex("B");

		DefaultWeightedEdge e1 = graph.addEdge("A", "B");
		graph.setEdgeWeight(e1, 25);

		DefaultWeightedEdge e2 = graph.addEdge("A", "C");
		graph.setEdgeWeight(e2, 35);

		DefaultWeightedEdge e3 = graph.addEdge("B", "E");
		graph.setEdgeWeight(e3, 90);

		DefaultWeightedEdge e4 = graph.addEdge("B", "C");
		graph.setEdgeWeight(e4, 15);

		DefaultWeightedEdge e5 = graph.addEdge("C", "B");
		graph.setEdgeWeight(e5, 50);

		DefaultWeightedEdge e6 = graph.addEdge("C", "D");
		graph.setEdgeWeight(e6, 50);

		DefaultWeightedEdge e7 = graph.addEdge("C", "E");
		graph.setEdgeWeight(e7, 30);

		DefaultWeightedEdge e8 = graph.addEdge("D", "E");
		graph.setEdgeWeight(e8, 60);

		DefaultWeightedEdge e9 = graph.addEdge("D", "F");
		graph.setEdgeWeight(e9, 20);

		DefaultWeightedEdge e10 = graph.addEdge("E", "D");
		graph.setEdgeWeight(e10, 10);

		DefaultWeightedEdge e11 = graph.addEdge("E", "F");
		graph.setEdgeWeight(e11, 70);
	}

	public static void addYensGraph() {
		// TODO Auto-generated method stub
		graph.addVertex("C");
		graph.addVertex("D");
		graph.addVertex("E");
		graph.addVertex("F");
		graph.addVertex("G");
		graph.addVertex("H");

		DefaultWeightedEdge e1 = graph.addEdge("C", "D");
		graph.setEdgeWeight(e1, 3);

		DefaultWeightedEdge e2 = graph.addEdge("C", "E");
		graph.setEdgeWeight(e2, 2);

		DefaultWeightedEdge e3 = graph.addEdge("D", "F");
		graph.setEdgeWeight(e3, 4);

		DefaultWeightedEdge e4 = graph.addEdge("E", "D");
		graph.setEdgeWeight(e4, 1);

		DefaultWeightedEdge e5 = graph.addEdge("E", "F");
		graph.setEdgeWeight(e5, 2);

		DefaultWeightedEdge e6 = graph.addEdge("E", "G");
		graph.setEdgeWeight(e6, 3);

		DefaultWeightedEdge e7 = graph.addEdge("F", "G");
		graph.setEdgeWeight(e7, 2);

		DefaultWeightedEdge e8 = graph.addEdge("F", "H");
		graph.setEdgeWeight(e8, 1);

		DefaultWeightedEdge e9 = graph.addEdge("G", "H");
		graph.setEdgeWeight(e9, 2);
	}
}
