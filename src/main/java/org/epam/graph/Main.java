package org.epam.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Graph g = new GraphImpl();

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

        in = new ArrayList<>();
        in.add(0);
        in.add(0);
        in.add(1);
        in.add(0);
        out = new ArrayList<>();
        out.add(1);
        out.add(0);
        out.add(1);
        out.add(0);
        Node n4 = new Node(in, out);

        g.add(n1);
        g.add(n2);
        g.add(n3);
        g.add(n4);

        for (Node n: g){
            System.out.println(n.getIn());
        }
    }
}
