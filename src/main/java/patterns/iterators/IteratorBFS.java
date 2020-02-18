package patterns.iterators;

import patterns.Node;

import java.util.ArrayDeque;
import java.util.Deque;

public class IteratorBFS implements TreeIterator {
    private Node currentNode;
    private Deque<Node> deque = new ArrayDeque<>();

    public IteratorBFS(Node currentNode) {
        deque.add(currentNode);
    }

    @Override
    public boolean hasNext() {
        return !deque.isEmpty();
    }

    @Override
    public Node next() {
        currentNode = deque.pop();
        deque.addAll(currentNode.getChildren());
        return currentNode;
    }


}
