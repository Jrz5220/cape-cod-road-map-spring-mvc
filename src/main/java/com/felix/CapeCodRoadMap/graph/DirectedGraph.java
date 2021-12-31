package com.felix.CapeCodRoadMap.graph;

import java.util.Collection;
import java.util.Deque;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class DirectedGraph<T> implements GraphInterface<T> {
	
	private Map<T, VertexInterface<T>> vertices;
	private int edgeCount;
	
	public DirectedGraph() {
		vertices = new HashMap<>();
		edgeCount = 0;
	}

	@Override
	public boolean addVertex(T vertexLabel) {
		boolean result = false;
		if(!vertices.containsKey(vertexLabel)) {
			vertices.put(vertexLabel, new Vertex<>(vertexLabel));
			result = true;
		}
		return result;
	}

	@Override
	public boolean addEdge(T begin, T end, double edgeWeight) {
		boolean result = false;
		VertexInterface<T> beginVertex = vertices.get(begin);
		VertexInterface<T> endVertex = vertices.get(end);
		if((beginVertex != null) && (endVertex != null))
			result = beginVertex.connect(endVertex, edgeWeight);
		if(result)
			edgeCount++;
		return result;
	}

	@Override
	public boolean addEdge(T begin, T end) {
		return addEdge(begin, end, 0);
	}

	@Override
	public boolean hasEdge(T begin, T end) {
		boolean found = false;
		VertexInterface<T> beginVertex = vertices.get(begin);
		VertexInterface<T> endVertex = vertices.get(end);
		if((beginVertex != null) && (endVertex != null)) {
			Iterator<VertexInterface<T>> neighbors = beginVertex.getNeighborIterator();
			while(!found && neighbors.hasNext()) {
				VertexInterface<T> nextNeighbor = neighbors.next();
				if(endVertex.equals(nextNeighbor))
					found = true;
			}
		}
		return found;
	}

	@Override
	public boolean isEmpty() {
		return vertices.isEmpty();
	}

	@Override
	public int getNumberOfVertices() {
		return vertices.size();
	}

	@Override
	public int getNumberOfEdges() {
		return edgeCount;
	}

	@Override
	public void clear() {
		vertices.clear();
		edgeCount = 0;
	}

	@Override
	public Queue<T> getBreadthFirstTraversal(T origin) {
		resetVertices();
		Queue<T> traversalOrder = new LinkedList<>();
		Queue<VertexInterface<T>> vertexQueue = new LinkedList<>();
		VertexInterface<T> originVertex = vertices.get(origin);
		originVertex.visit();
		traversalOrder.add(origin);
		vertexQueue.add(originVertex);
		while(!vertexQueue.isEmpty()) {
			VertexInterface<T> frontVertex = vertexQueue.remove();
			Iterator<VertexInterface<T>> neighbors = frontVertex.getNeighborIterator();
			while(neighbors.hasNext()) {
				VertexInterface<T> nextNeighbor = neighbors.next();
				if(!nextNeighbor.isVisited()) {
					nextNeighbor.visit();
					traversalOrder.add(nextNeighbor.getLabel());
					vertexQueue.add(nextNeighbor);
				}
			}
		}
		return traversalOrder;
	}

	@Override
	public Queue<T> getDepthFirstTraversal(T origin) {
		resetVertices();
		Queue<T> traversalOrder = new LinkedList<>();
		Deque<VertexInterface<T>> vertexStack = new LinkedList<>();
		VertexInterface<T> originVertex = vertices.get(origin);
		originVertex.visit();
		traversalOrder.add(origin);
		vertexStack.addLast(originVertex);
		while(!vertexStack.isEmpty()) {
			VertexInterface<T> topVertex = vertexStack.peekLast();
			if(topVertex.getUnvisitedNeighbor() != null) {
				VertexInterface<T> nextNeighbor = topVertex.getUnvisitedNeighbor();
				nextNeighbor.visit();
				traversalOrder.add(nextNeighbor.getLabel());
				vertexStack.addLast(nextNeighbor);
			} else
				vertexStack.removeLast();
		}
		return traversalOrder;
	}

	@Override
	public Deque<T> getTopologicalOrder() {
		// only for directed graphs with no cycles
		resetVertices();
		int numberOfVertices = getNumberOfVertices();
		Deque<T> vertexStack = new LinkedList<>();
		LinkedList<VertexInterface<T>> verticesInGraph = new LinkedList<>(vertices.values());
		LinkedList<VertexInterface<T>> verticesWithNeighbors = new LinkedList<>();
		for (int i = 0; i < numberOfVertices; i++) {
			VertexInterface<T> nextVertex = verticesInGraph.get(i);
			while (true) {
				if (!nextVertex.isVisited()) {
					if (nextVertex.getUnvisitedNeighbor() != null) {
						verticesWithNeighbors.push(nextVertex);
						nextVertex = nextVertex.getUnvisitedNeighbor();
					} else {
						verticesWithNeighbors.remove(nextVertex);
						nextVertex.visit();
						vertexStack.push(nextVertex.getLabel());
						break;
					}
				} else
					nextVertex = verticesWithNeighbors.remove();
			}
		}
		return vertexStack;
	}

	@Override
	public int getShortestPath(T begin, T end, Deque<T> path) {
		resetVertices();
		boolean done = false;
		Queue<VertexInterface<T>> vertexQueue = new LinkedList<>();
		VertexInterface<T> originVertex = vertices.get(begin);
		VertexInterface<T> endVertex = vertices.get(end);
		originVertex.visit();
		vertexQueue.add(originVertex);
		while(!done && !vertexQueue.isEmpty()) {
			VertexInterface<T> frontVertex = vertexQueue.remove();
			Iterator<VertexInterface<T>> neighbors = frontVertex.getNeighborIterator();
			// The shortest path will be found when the current vertex contains the end vertex as its next neighbor
			while(!done && neighbors.hasNext()) {
				VertexInterface<T> nextNeighbor = neighbors.next();
				if(!nextNeighbor.isVisited()) {
					nextNeighbor.visit();
					nextNeighbor.setCost(1 + frontVertex.getCost());
					nextNeighbor.setPredecessor(frontVertex);
					vertexQueue.add(nextNeighbor);
				}
				if(nextNeighbor.equals(endVertex))
					done = true;
			}
		}
		// Traversal ends; construct shortest path
		int pathLength = (int) endVertex.getCost();
		path.addFirst(endVertex.getLabel());
		VertexInterface<T> vertex = endVertex;
		while(vertex.hasPredecessor()) {
			vertex = vertex.getPredecessor();
			path.addFirst(vertex.getLabel());
		}
		return pathLength;
	}

	@Override
	public double getCheapestPath(T begin, T end, Deque<T> path) {
		resetVertices();
		boolean done = false;
		PriorityQueue<EntryPQ> pq = new PriorityQueue<>();		// the smallest cost has the highest priority
		VertexInterface<T> originVertex = vertices.get(begin);
		VertexInterface<T> endVertex = vertices.get(end);
		pq.add(new EntryPQ(null, originVertex, 0));
		while(!done && !pq.isEmpty()) {
			EntryPQ frontEntry = pq.remove();
			VertexInterface<T> frontVertex = frontEntry.getVertex();
			if(!frontVertex.isVisited()) {
				frontVertex.visit();
				frontVertex.setCost(frontEntry.getCost());
				frontVertex.setPredecessor(frontEntry.getPredecessor());
				if(frontVertex.equals(endVertex))
					done = true;
				else {
					Iterator<VertexInterface<T>> neighbors = frontVertex.getNeighborIterator();
					Iterator<Double> edgeWeights = frontVertex.getWeightIterator();
					while(neighbors.hasNext() && edgeWeights.hasNext()) {
						VertexInterface<T> nextNeighbor = neighbors.next();
						double weightOfEdgeToNeighbor = edgeWeights.next();
						if(!nextNeighbor.isVisited()) {
							double nextCost = weightOfEdgeToNeighbor + frontVertex.getCost();
							pq.add(new EntryPQ(frontVertex, nextNeighbor, nextCost));
						}
					}
				}
			}
		}
		// Traversal ends; construct cheapest path
		double pathCost = endVertex.getCost();
		path.addFirst(endVertex.getLabel());
		VertexInterface<T> vertex = endVertex;
		while(vertex.hasPredecessor()) {
			vertex = vertex.getPredecessor();
			path.addFirst(vertex.getLabel());
		}
		return pathCost;
	}
	
	// only required by methods declared in the GraphAlgorithmsInterface
	protected void resetVertices() {
		Collection<VertexInterface<T>> verticesValues = vertices.values();
		Iterator<VertexInterface<T>> vertexIterator = verticesValues.iterator();
		while (vertexIterator.hasNext()) {
			VertexInterface<T> nextVertex = vertexIterator.next();
			nextVertex.unVisit();
			nextVertex.setCost(0);
			nextVertex.setPredecessor(null);
		}
	}

	// only required by the priority queue in getCheapestPath
	private class EntryPQ implements Comparable<EntryPQ> {
		VertexInterface<T> vertex;
		VertexInterface<T> predecessor;
		double cost; // the priority value

		@SuppressWarnings("unused")
		public EntryPQ() {
			vertex = null;
			predecessor = null;
			cost = 0;
		}

		public EntryPQ(VertexInterface<T> begin, VertexInterface<T> end, double edgeWeight) {
			predecessor = begin;
			vertex = end;
			cost = edgeWeight;
		}

		public VertexInterface<T> getVertex() {
			return vertex;
		}

		@SuppressWarnings("unused")
		public void setVertex(VertexInterface<T> vertex) {
			this.vertex = vertex;
		}

		public VertexInterface<T> getPredecessor() {
			return predecessor;
		}

		@SuppressWarnings("unused")
		public void setPredecessor(VertexInterface<T> predecessor) {
			this.predecessor = predecessor;
		}

		public double getCost() {
			return cost;
		}

		@SuppressWarnings("unused")
		public void setCost(double cost) {
			this.cost = cost;
		}

		@Override
		public int compareTo(DirectedGraph<T>.EntryPQ o) {
			return (int) (cost - o.getCost());
		}
	} // end EntryPQ

}
