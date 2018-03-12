package org.epam.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Main {
    public static void main(String[] args) {
        Graph g = new GraphImpl();
        Integer []i = {0};
        Integer []o = {0};
        g.add(new Node(i, o));
        for (Node n: g){
            System.out.println(n.getIn());
        }
        System.out.println("-------------------------------------------");
        i = new Integer[]{0, 0};
        o = new Integer[]{1, 0};
        g.add(new Node(i, o));
        for (Node n: g){
            System.out.println(n.getIn());
        }
        System.out.println("-------------------------------------------");
        i = new Integer[]{0, 0, 0};
        o = new Integer[]{1, 0, 0};
        g.add(new Node(i, o));
        for (Node n: g){
            System.out.println(n.getIn());
        }
        System.out.println("-------------------------------------------");
        i = new Integer[]{0, 0, 1, 0};
        o = new Integer[]{1, 0, 1, 0};
        g.add(new Node(i, o));
        for (Node n: g){
            System.out.println(n.getIn());
        }
    }
}
