package patterns.iterators;

import patterns.Node;

import java.util.Stack;

public class IteratorDFS implements TreeIterator {
    private Node currentNode;
    private Stack<Node> stack = new Stack<>();

    public IteratorDFS(Node currentNode) {
        stack.add(currentNode);
    }

    @Override
    public boolean hasNext() {
        return !stack.isEmpty();
    }

    @Override
    public Node next() {
        currentNode = stack.pop();
        stack.addAll(currentNode.getChildren());
        return currentNode;
    }
}
