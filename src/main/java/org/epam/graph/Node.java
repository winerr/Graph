package org.epam.graph;

import java.util.List;

public class Node {
    List<Integer> in;
    List<Integer> out;


    /**
     * Конструктор для заповнення звязків вузла
     * @param in індекси вузлів які мають шляхи до вузла
     * @param out індекси вузлів до яких йдуть шляхи від конкретного вузла
     */
    public Node(List<Integer> in, List<Integer> out) {
        this.in = in;
        this.out = out;
    }
}
