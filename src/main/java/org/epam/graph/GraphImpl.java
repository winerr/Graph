package org.epam.graph;

import java.io.Serializable;
import java.util.*;

public class GraphImpl extends AbstractGraph implements Graph, Cloneable, Serializable, Comparable<GraphImpl> {

	private List<Node> nodes;

	public GraphImpl() {
	}

	public boolean add(Node e) {
		if (nodes == null) {
			nodes = new ArrayList<>();
			nodes.add(e);
		} else if (e.getIn().size() != nodes.size() + 1 || e.getOut().size() != nodes.size() + 1
				|| e.getIn().get(e.getIn().size() - 1) != 0 || e.getOut().get(e.getOut().size() - 1) != 0) {
			return false;
		} else {
			for (int i = 0; i < nodes.size(); i++) {
				nodes.get(i).addOut(e.getInByIndex(i));
				nodes.get(i).addIn(e.getOutByIndex(i));
			}
			nodes.add(e);
		}
		return true;
	}

	//join two graphs
	//joiningRules has list of nodes with in list and out list of this (current graph) nodes
	public GraphImpl join(GraphImpl graph, List<Node> joiningRules){
		//add adjacency matrix of graph.nodes to this.nodes
		for (Node node : graph.nodes) {
			for (int i = this.nodes.size(); i < this.nodes.size() + graph.nodes.size(); i++) {
				nodes.get(i).addOut(node.getInByIndex(i - this.nodes.size()));
				nodes.get(i).addIn(node.getOutByIndex(i - this.nodes.size()));

			}
			nodes.add(node);
		}
		//add adjacency matrices from joining rules list
		for (Node node : joiningRules) {
			for (int i = this.nodes.size(); i < this.nodes.size() + graph.nodes.size(); i++) {
				for (int j = 0; j < nodes.size(); j++) {
					nodes.get(i).addOut(node.getInByIndex(j));
					nodes.get(j).addIn(node.getOutByIndex(i));
				}
			}
		}
		return this;
	}

	public boolean remove(Object o) {
		return remove(indexOf(o));
	}

	@Override
	public boolean remove(int index) {
		if (index >= nodes.size()) {
			return false;
		} else {
			nodes.remove(index);
			for (Node node : nodes) {
				node.removeIn(index);
				node.removeOut(index);
			}
			return true;
		}
	}

	public Node get(int index) {
		if (index >= nodes.size())
			return null;
		return nodes.get(index);
	}

	public Node getNodeByIndex(int index) {
		return nodes.get(index-1);
	}

	public List<Integer> findShortestPath(int start, int end) {
		Route route = new Route(this);
		List <Route> allRoutes = route.generateAllRoutes(start, end, this);
		route = route.findShortestRoute(allRoutes);
		return route.getNodes();
	}

	@Override
	public String toString() {
		StringBuilder result = new StringBuilder();
		result.append(" ");
		for (int i = 0; i < nodes.size(); i++) {
			result.append(" " + (i + 1));
		}
		for (int i = 0; i < nodes.size(); i++) {
			result.append("\n");
			result.append((i + 1));
			for (int k = 0; k < nodes.get(i).getIn().size(); k++) {
				result.append(" ").append(nodes.get(i).getIn().get(k));
			}
		}
		return result.toString();
	}

	public int size() {
		return nodes.size();
	}

	public boolean isEmpty() {
		return size() == 0;
	}

	public Iterator<Node> iterator() {
		return nodes.iterator();
	}

	public Object[] toArray() {
		return nodes.toArray();
	}

	public <T> T[] toArray(T[] a) {
		return nodes.toArray(a);
	}

	public boolean contains(Object o) {
		return nodes.contains(o);
	}

	public boolean containsAll(Collection<?> c) {
		return nodes.containsAll(c);
	}

	public boolean addAll(Collection<? extends Node> c) {
		boolean modified = false;
		for (Node node : c)
			if (add(node))
				modified = true;
		return modified;
	}

	public boolean removeAll(Collection<?> c) {
		Objects.requireNonNull(c);
		boolean modified = false;
		Iterator<?> it = iterator();
		while (it.hasNext()) {
			if (c.contains(it.next())) {
				it.remove();
				modified = true;
			}
		}
		return modified;
	}

	public boolean retainAll(Collection<?> c) {
		Objects.requireNonNull(c);
		boolean modified = false;
		Iterator<Node> it = iterator();
		while (it.hasNext()) {
			if (!c.contains(it.next())) {
				it.remove();
				modified = true;
			}
		}
		return modified;
	}

	public void clear() {
		Iterator<Node> it = iterator();
		while (it.hasNext()) {
			it.next();
			it.remove();
		}
	}

	@Override
	public int indexOf(Object o) {
		return nodes.indexOf(o);
	}

	@Override
	public GraphImpl clone() {
		try {
			return (GraphImpl) super.clone();
		} catch (CloneNotSupportedException ex) {
			throw new InternalError();
		}
	}

	@Override
	public int compareTo(GraphImpl graph) {
		if (this.nodes.size() < graph.nodes.size())
			return -1;
		else if(this.nodes.size() > graph.nodes.size()){
			return 1;
		}
		else{
			int resultOfCompareNodes = -1;
			for (int i = 0; i < this.nodes.size(); i ++){
				resultOfCompareNodes = this.nodes.get(i).compareTo(graph.nodes.get(i));
			}
			return resultOfCompareNodes;
		}
	}
}
