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
        out.add(1);
        out.add(0);
        Node n2 = new Node(in, out);

        in = new ArrayList<>();
        in.add(0);
        in.add(0);
        in.add(0);
        out = new ArrayList<>();
        out.add(1);
        out.add(0);
        out.add(0);
        Node n3 = new Node(in, out);

        g.add(n1);
        g.add(n2);
        g.add(n3);
    }

    @Test
    public void testAddMethod(){


        List<Integer> in = new ArrayList<>();
        in.add(0);
        in.add(0);
        in.add(1);
        in.add(0);
        List<Integer> out = new ArrayList<>();
        out.add(1);
        out.add(0);
        out.add(1);
        out.add(0);
        Node n4 = new Node(in, out);

        g.add(n4);

        List<Integer> expectedInForFirstNode = new ArrayList<>();
        expectedInForFirstNode.add(0);
        expectedInForFirstNode.add(1);
        expectedInForFirstNode.add(1);
        expectedInForFirstNode.add(1);

        assertArrayEquals(expectedInForFirstNode.toArray(), g.get(0).getIn().toArray());
    }
    @Ignore
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

        assertArrayEquals(expectedInForFirstNode.toArray(), g.get(0).getIn().toArray());
    }

    @Test
    public void testGetMethod(){
        Node actual = g.get(0);
        List<Integer> in = new ArrayList<>();
        in.add(0);
        in.add(1);
        in.add(1);
        List<Integer> out = new ArrayList<>();
        out.add(0);
        out.add(0);
        out.add(0);
        Node expected = new Node(in, out);

        assertArrayEquals(expected.getIn().toArray(), actual.getIn().toArray());


        assertArrayEquals(expected.getOut().toArray(), actual.getOut().toArray());
    }
}
