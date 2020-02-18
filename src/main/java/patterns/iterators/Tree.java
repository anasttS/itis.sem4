package patterns.iterators;

import patterns.iterators.IteratorBFS;
import patterns.iterators.IteratorBFSPriority;
import patterns.iterators.IteratorDFS;

public interface Tree {
    IteratorBFS createIteratorBFS();
    IteratorDFS createIteratorDFS();
    IteratorBFSPriority createIteratorBFSPriority();
}
