package patterns.iterators;


import patterns.Node;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Deque;

public class IteratorBFSPriority implements TreeIterator {
    private Node currentNode = null;
    private Deque<Node> deque = new ArrayDeque<>();

    public IteratorBFSPriority(Node currentNode) {
        deque.add(currentNode);
    }

    @Override
    public boolean hasNext() {
        return !deque.isEmpty();
    }

    @Override
    public Node next() {
        currentNode = deque.pop();
        ArrayList<Node> children = (ArrayList<Node>) currentNode.getChildren();
        children.sort(new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return o1.getPrioritet() - o2.getPrioritet();
            }
        });
        deque.addAll(children);
        return currentNode;
    }

}
