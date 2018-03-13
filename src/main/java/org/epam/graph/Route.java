package org.epam.graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Route implements Comparable <Route> {
    private List<Integer> nodeIndexes = new ArrayList<>();
    private Graph graph;
    private static List <Route> allRoutes = new ArrayList<>();

    // constructor for creating the first route instance
    public Route(Graph graph) {
        this.graph = graph;
    }

    // constructor for creating a route based on another one (used for recursion purposes)
    public Route(Route r) {
        this.nodeIndexes.addAll(r.getNodes());
        this.graph = r.graph;
    }

    //Returns the List of all final routes (from start index to end index)
    public List<Route> generateAllRoutes(int start, int end, Graph graph){
        Route firstRoute = new Route(graph);
        calculateFinalRoutes(firstRoute, start, end);
        List<Route> result = new ArrayList<>();
        result.addAll(allRoutes);
        allRoutes.clear();
        return result;
    }

    /*
    The method puts finalized routes into allRoutes field.
    Finalization is based on the calculation of transitional routes using recursion.
     */
    public void calculateFinalRoutes(Route oldRoute, int oldIndex, int endIndex){
        //add the node to the route
        oldRoute.getNodes().add(oldIndex);
        //add to the finalized routes if we found the endIndex
        if ( graph.getNodeByIndex(oldIndex).hasOutByIndex(endIndex)){
            oldRoute.getNodes().add(endIndex);
            allRoutes.add(oldRoute);
        }
        //use recursion for each of the "out nodes" that are contained in the current node
        else if (!graph.getNodeByIndex(oldIndex).getOut().isEmpty()){
            for (Integer tempIndex : graph.getNodeByIndex(oldIndex).getOut()){
                System.out.println("hi");
                Route temp = new Route(oldRoute);
                calculateFinalRoutes(temp, tempIndex, endIndex);
            }
        }
    }

    /*
    Returns the route with the smallest number of nodes.
    If there are several routes with the same number of nodes, the method picks the first one
    */
    public Route findShortestRoute(List<Route> routes){
        return Collections.min(routes);
    }

    public List<Integer> getNodes() {
        return nodeIndexes;
    }

    public int getDistance (){
        return nodeIndexes.size();
    }

    @Override
    public int compareTo(Route o) {
        return this.getDistance() - o.getDistance();
    }
}
