package patterns.facade;

import patterns.Node;

public interface FacadeInterface {
    Node readTree(String format);
    void writeTree(Node node, String format);
}
