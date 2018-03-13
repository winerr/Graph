package org.epam;

import org.epam.graph.Graph;
import org.epam.graph.GraphImpl;
import org.epam.graph.Node;
import org.junit.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GraphImplJUnitTest extends Assert {
	  private Graph g;

	    @Before
	    public void setUpGraph(){
	        g = new GraphImpl();
	        List<Integer> in = new ArrayList<>();
	        in.add(0);
	        List<Integer> out = new ArrayList<>();
	        out.add(0);
	        Node n1 = new Node(in, out);

	        in = new ArrayList<>();
	        in.add(0);
	        in.add(0);
	        out = new ArrayList<>();
	        out.add(10);
	        out.add(0);
	        Node n2 = new Node(in, out);

	        in = new ArrayList<>();
	        in.add(0);
	        in.add(10);
	        in.add(0);
	        out = new ArrayList<>();
	        out.add(30);
	        out.add(0);
	        out.add(0);
	        Node n3 = new Node(in, out);

	        in = new ArrayList<>();
	        in.add(0);
	        in.add(0);
	        in.add(20);
	        in.add(0);
	        out = new ArrayList<>();
	        out.add(15);
	        out.add(0);
	        out.add(20);
	        out.add(0);
	        Node n4 = new Node(in, out);

	        in = new ArrayList<>();
	        in.add(0);
	        in.add(20);
	        in.add(10);
	        in.add(0);
	        in.add(0);
	        out = new ArrayList<>();
	        out.add(0);
	        out.add(15);
	        out.add(10);
	        out.add(20);
	        out.add(0);
	        Node n5 = new Node(in, out);

	        g.add(n1);
	        g.add(n2);
	        g.add(n3);
	        g.add(n4);
	        g.add(n5);
	    }

	    @Test
	    public void testAddMethod(){


	        List<Integer> in = new ArrayList<>();
	        in.add(0);
	        in.add(0);
	        in.add(1);
	        in.add(0);
	        in.add(0);
	        in.add(0);
	        List<Integer> out = new ArrayList<>();
	        out.add(1);
	        out.add(0);
	        out.add(1);
	        out.add(0);
	        out.add(0);
	        out.add(0);
	        Node n4 = new Node(in, out);

	        g.add(n4);

	        List<Integer> expectedInForFirstNode = new ArrayList<>();
	        expectedInForFirstNode.add(0);
	        expectedInForFirstNode.add(10);
	        expectedInForFirstNode.add(30);
	        expectedInForFirstNode.add(15);
	        expectedInForFirstNode.add(0);
	        expectedInForFirstNode.add(1);

	        assertArrayEquals(expectedInForFirstNode.toArray(), g.get(0).getIn().toArray());
	    }

	    @Test
	    public void testAdd() {
	        g.add(new Node(new ArrayList<>(),new ArrayList<>()));
	        g.add(new Node(new ArrayList<>(),new ArrayList<>()));
	        g.add(new Node(new ArrayList<>(),new ArrayList<>()));
	    }

	    @Test
	    public void testRemoveMethod(){
	        g.remove(0);

	        List<Integer> expectedInForFirstNode = new ArrayList<>();
	        expectedInForFirstNode.add(0);
	        expectedInForFirstNode.add(0);
	        expectedInForFirstNode.add(0);
	        expectedInForFirstNode.add(15);


	        assertArrayEquals(expectedInForFirstNode.toArray(), g.get(0).getIn().toArray());
	    }

	    @Test
	    public void testGetMethod(){
	        Node actual = g.get(0);
	        List<Integer> in = new ArrayList<>();
	        in.add(0);
	        in.add(10);
	        in.add(30);
	        in.add(15);
	        in.add(0);
	        List<Integer> out = new ArrayList<>();
	        out.add(0);
	        out.add(0);
	        out.add(0);
	        out.add(0);
	        out.add(0);
	        Node expected = new Node(in, out);

	        assertArrayEquals(expected.getIn().toArray(), actual.getIn().toArray());


	        assertArrayEquals(expected.getOut().toArray(), actual.getOut().toArray());
	    }

	    @Ignore
	    @Test
	    public void testFindRouteMethod(){
	        List<Integer> actual = g.findShortestPath(0,4);
	        List<Integer> expected = new ArrayList<>();
	        expected.add(0);
	        expected.add(3);
	        expected.add(4);

	        assertArrayEquals(expected.toArray(), actual.toArray());
	    }

}
