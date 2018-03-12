package org.epam.graph;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public abstract class AbstractGraph implements Graph {
    public abstract Node get(int index);

    public abstract List<Node> findRoute(int start, int finish);

    public abstract int size();

    public abstract boolean isEmpty();

    public abstract boolean contains(Object o);

    public abstract Iterator<Node> iterator();

    public abstract Object[] toArray();

    public abstract <T> T[] toArray(T[] a);

    public abstract boolean add(Node e);

    public abstract boolean remove(Object o);

    public abstract boolean containsAll(Collection<?> c);

    public abstract boolean addAll(Collection<? extends Node> c);

    public abstract boolean removeAll(Collection<?> c);

    public abstract boolean retainAll(Collection<?> c);

    public abstract void clear();
}
