package org.epam.graph;

import java.util.Collection;
import java.util.List;

public interface Graph extends Collection<Node> {

    /**
     * Returns the element at the specified position in this list.
     *
     * @param index index of the node to return
     * @return the element at the specified position in this list
     * @throws IndexOutOfBoundsException if the index is out of range
     *         (<tt>index &lt; 0 || index &gt;= size()</tt>)
     */
    Node get(int index);

    /**
     * Removes the element at the specified position in this list (optional
     * operation).  Shifts any subsequent elements to the left (subtracts one
     * from their indices).  Returns the element that was removed from the
     * list.
     *
     * @param index the index of the element to be removed
     * @return the element previously at the specified position
     * @throws UnsupportedOperationException if the <tt>remove</tt> operation
     *         is not supported by this list
     * @throws IndexOutOfBoundsException if the index is out of range
     *         (<tt>index &lt; 0 || index &gt;= size()</tt>)
     */
    boolean remove(int index);

    /**
     * Returns a list of items that correspond to the shortest path
     * @param start first item on list
     * @param finish last item on list
     * @return
     */
    List<Node> findRoute(int start, int finish);


}
