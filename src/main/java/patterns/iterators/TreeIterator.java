package patterns.iterators;

import patterns.Node;

public interface TreeIterator {
    Node next();
    boolean hasNext();
}
