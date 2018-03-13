package org.epam;

import org.epam.graph.Graph;
import org.epam.graph.GraphImpl;
import org.epam.graph.Node;
import org.junit.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GraphImplJUnitTest extends Assert {
    private GraphImpl g1;

    @Before
    public void setUpGraph1(){
        g1 = new GraphImpl();
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

        g1.add(n1);
        g1.add(n2);
        g1.add(n3);
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

        g1.add(n4);

        List<Integer> expectedInForFirstNode = new ArrayList<>();
        expectedInForFirstNode.add(0);
        expectedInForFirstNode.add(1);
        expectedInForFirstNode.add(1);
        expectedInForFirstNode.add(1);

        assertArrayEquals(expectedInForFirstNode.toArray(), g1.get(0).getIn().toArray());
    }
    @Ignore
    @Test
    public void testAdd() {
        g1.add(new Node(new ArrayList<>(),new ArrayList<>()));
        g1.add(new Node(new ArrayList<>(),new ArrayList<>()));
        g1.add(new Node(new ArrayList<>(),new ArrayList<>()));
    }

    @Test
    public void testRemoveMethod(){
        g1.remove(0);

        List<Integer> expectedInForFirstNode = new ArrayList<>();
        expectedInForFirstNode.add(0);
        expectedInForFirstNode.add(0);

        assertArrayEquals(expectedInForFirstNode.toArray(), g1.get(0).getIn().toArray());
    }

    @Test
    public void testGetMethod(){
        Node actual = g1.get(0);
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

    @Test
    public void testCompareTo() {

        GraphImpl g2Equals = new GraphImpl();
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

        g2Equals.add(n1);
        g2Equals.add(n2);
        g2Equals.add(n3);

        GraphImpl g2Less = new GraphImpl();
        in = new ArrayList<>();
        in.add(0);
        out = new ArrayList<>();
        out.add(0);
        n1 = new Node(in, out);

        in = new ArrayList<>();
        in.add(0);
        in.add(0);
        out = new ArrayList<>();
        out.add(1);
        out.add(0);
        n2 = new Node(in, out);

        in = new ArrayList<>();
        in.add(0);
        in.add(0);
        in.add(0);
        out = new ArrayList<>();
        out.add(1);
        out.add(1);
        out.add(1);
        n3 = new Node(in, out);

        g2Less.add(n1);
        g2Less.add(n2);
        g2Less.add(n3);


        GraphImpl g2Greater = new GraphImpl();
        in = new ArrayList<>();
        in.add(0);
        out = new ArrayList<>();
        out.add(0);
        n1 = new Node(in, out);

        in = new ArrayList<>();
        in.add(0);
        in.add(0);
        out = new ArrayList<>();
        out.add(1);
        out.add(0);
        n2 = new Node(in, out);

        in = new ArrayList<>();
        in.add(0);
        in.add(0);
        in.add(0);
        out = new ArrayList<>();
        out.add(1);
        out.add(1);
        out.add(0);
        n3 = new Node(in, out);

        g2Greater.add(n1);
        g2Greater.add(n2);
        g2Greater.add(n3);

        assertEquals(0,g1.compareTo(g2Equals));
        assertEquals(1,g1.compareTo(g2Less));
        assertEquals(-1,g1.compareTo(g2Greater));
    }
}
