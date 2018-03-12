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
     * Returns a list of items that correspond to the shortest path
     * @param start first item on list
     * @param finish last item on list
     * @return
     */
    List<Node> findRoute(int start, int finish);


}
