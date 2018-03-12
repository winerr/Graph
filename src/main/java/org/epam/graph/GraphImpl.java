package org.epam.graph;

import java.io.Serializable;
import java.util.*;


public class GraphImpl extends AbstractGraph implements Graph, Cloneable, Serializable {

    private List<Node> nodes;

    public GraphImpl() {
    }

    public boolean add(Node e) {
        if(nodes == null){
            nodes = new ArrayList<>();
            nodes.add(e);
        }else{
            int index = 0;
            for (Node node: nodes){
                node.addIn(e.getInByIndex(index));
                node.addOut(e.getOutByIndex(index));
                index++;
            }
            nodes.add(e);
        }
        return false;
    }

    public boolean remove(Object o) {
        return remove(indexOf(o));
    }

    @Override
    public boolean remove(int index) {
        if(index>=nodes.size()){
        	return false;
        }else{
        	nodes.remove(index);
        	for(Node node : nodes){
        		node.removeIn(index);
        		node.removeOut(index);
        	}
        	return true;
        }
    }

    public Node get(int index) {
    	if(index >= nodes.si)
        return nodes.get(index);
    }

    public List<Node> findRoute(int start, int finish) {
        return null;
    }

    @Override
	public String toString() {
		StringBuilder result = new StringBuilder();
		for (int i = 0; i < nodes.size(); i++) {
			result.append("  " + i);
		}
		for (int i = 0; i < nodes.size(); i++) {
			result.append("\n");
			result.append(i);
			for (int k = 0; k < nodes.get(i).getIn().size(); k++) {
				result.append(nodes.get(i).getIn().get(k));
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
    public GraphImpl clone(){
    	 try {
    	      return (GraphImpl)super.clone();
    	    }
    	    catch(CloneNotSupportedException ex ) {
    	      throw new InternalError();
    	    }
    }
}
