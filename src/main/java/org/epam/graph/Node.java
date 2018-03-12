package org.epam.graph;

import java.util.List;

public class Node {

    private List<Integer> in;
    private List<Integer> out;
    //for increment index
    private int index;
    private static int count = 0;


    /**
     * Конструктор для заповнення звязків вузла
     *
     * @param in  індекси вузлів які мають шляхи до вузла
     * @param out індекси вузлів до яких йдуть шляхи від конкретного вузла
     */
    public Node(List<Integer> in, List<Integer> out) {
        this.in = in;
        this.out = out;
        index = ++count;
    }

    public boolean addIn(int index) {
        return in.add(index);
    }

    public boolean addOut(int index) {
        return in.add(index);
    }

    public boolean removeIn(int index) {
        return in.remove(in.get(index));
    }

    public boolean removeOut(int index) {
        return out.remove(out.get(index));
    }


    public int getInByIndex(int index) {
        return in.get(index);
    }

    public int getOutByIndex(int index) {
        return out.get(index);
    }


    //чи існує індекс в списку вхідних зв'язків
    public boolean hasInByIndex(int index) {
        return in.contains(index);
    }

    //чи існує індекс в списку вихідних зв'язків
    public boolean hasOutByIndex(int index) {
        return out.contains(index);
    }

    //return current instance index
    public int getIndex() {
        return index;
    }
}
