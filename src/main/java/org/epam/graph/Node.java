package org.epam.graph;

import java.util.List;

public class Node implements Comparable<Node> {

    private List<Integer> in;
    private List<Integer> out;
    //for increment index
    //private int index;
    //private static int count = 0;


    /**
     * Конструктор для заповнення звязків вузла
     *
     * @param in  індекси вузлів які мають шляхи до вузла
     * @param out індекси вузлів до яких йдуть шляхи від конкретного вузла
     */
    public Node(List<Integer> in, List<Integer> out) {
        this.in = in;
        this.out = out;
        //index = ++count;
    }

    public boolean addIn(int index) {
        return in.add(index);
    }

    public boolean addOut(int index) {
        return out.add(index);
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
//    public int getIndex() {
//        return index;
//    }

    public List<Integer> getIn() {
        return in;
    }

    public void setIn(List<Integer> in) {
        this.in = in;
    }

    public List<Integer> getOut() {
        return out;
    }

    public void setOut(List<Integer> out) {
        this.out = out;
    }

    @Override
    public int compareTo(Node node) {
        int resultOfCompareNodes = 0;
        //check if in lists and out lists of this node and compare node are less , more or equals
        //if more -> this node are greater then compare node
        if (this.in.size() > node.in.size() & this.out.size() > node.out.size())
            resultOfCompareNodes = 1;

        //if less -> this node are less then compare node
        else if (this.in.size() < node.in.size() & this.out.size() < node.out.size())
            resultOfCompareNodes = -1;
        //if equals -> checking the in lists and out lists for equals
        else if (this.in.size() == node.in.size() & this.out.size() == node.out.size()){
            // if in lists and out lists are equals -> nodes are equals
            if (compareList(this.in, node.in) == 0 & compareList(this.out, node.out) == 0)
                resultOfCompareNodes = 0;
            //else we can`t make any design about less or greater and return that this node a less then compare node
            else
                resultOfCompareNodes = -1;
        }
        else
            resultOfCompareNodes = -1;
        return resultOfCompareNodes;
    }
    private int compareList(List<Integer> list1, List<Integer> list2){
        int resultOfCompareNodes = 0;
        int countEquals = 0;
        for (int i = 0; i < list1.size(); i++){
            if (list1.get(i).intValue() == list2.get(i).intValue()){
                countEquals ++;
            }
        }
        if (countEquals == list1.size())
            resultOfCompareNodes = 0;
        else
            resultOfCompareNodes = -1;
        return resultOfCompareNodes;
    }
}
