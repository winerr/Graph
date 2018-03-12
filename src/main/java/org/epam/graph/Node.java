package org.epam.graph;

import java.util.List;

public class Node {
    private List<Integer> in;
    private List<Integer> out;


    /**
     * Конструктор для заповнення звязків вузла
     * @param in індекси вузлів які мають шляхи до вузла
     * @param out індекси вузлів до яких йдуть шляхи від конкретного вузла
     */
    public Node(List<Integer> in, List<Integer> out) {
        this.in = in;
        this.out = out;
    }

    public boolean addIn(int index){
        return in.add(index);
    }

    public boolean addOut(int index){
        return in.add(index);
    }

    public boolean removeIn(int index){
    	return in.remove(in.get(index));
    }

    public boolean removeOut(int index){
    	return out.remove(out.get(index));
    }


    public int getInByIndex(int index){
        return in.get(index);
    }

    public int getOutByIndex(int index){
        return out.get(index);
    }
}
